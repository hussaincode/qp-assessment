package in.hussaincode.groceryapp.service;

import in.hussaincode.groceryapp.entity.GroceryItem;
import in.hussaincode.groceryapp.entity.OrderItemRequest;
import in.hussaincode.groceryapp.entity.Orders;
import in.hussaincode.groceryapp.exception.ItemNotFoundException;
import in.hussaincode.groceryapp.repository.GroceryItemRepository;
import in.hussaincode.groceryapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<GroceryItem> viewAvailableItems() {
        return groceryItemRepository.findAll();
    }

    public Orders placeOrder(List<OrderItemRequest> orderItems) {
        // List to store items that are not found
        List<String> notFoundItems = new ArrayList<>();

        // Iterate through the items in the order
        for (OrderItemRequest orderItem : orderItems) {
            // Retrieve the grocery item by name
            GroceryItem groceryItem = groceryItemRepository.findByName(orderItem.getItemName());

            if (groceryItem == null || groceryItem.getQuantity() < orderItem.getQuantity()) {
                // If the item is not found or there is not enough quantity in stock, add its name to the list
                notFoundItems.add(orderItem.getItemName());
            }
        }

        // If any items are not found, throw ItemNotFoundException
        if (!notFoundItems.isEmpty()) {
            try {
                throw new ItemNotFoundException("Items not found or insufficient stock: " + notFoundItems);
            } catch (ItemNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        // Continue with placing the order...

        // Create a list to store grocery items
        List<GroceryItem> orderedItems = new ArrayList<>();

        // Iterate through the items in the order
        for (OrderItemRequest orderItem : orderItems) {
            // Retrieve the grocery item by name
            GroceryItem groceryItem = groceryItemRepository.findByName(orderItem.getItemName());

            // Update the quantity in stock
            groceryItem.setQuantity(groceryItem.getQuantity() - orderItem.getQuantity());
            groceryItemRepository.save(groceryItem);

            // Add the grocery item to the list of ordered items
            orderedItems.add(groceryItem);
        }

        // Create the order
        Orders order = new Orders();
        order.setItems(orderedItems);

        // Calculate the total amount based on the ordered items
        double totalAmount = orderedItems.stream()
                .mapToDouble(item -> item.getPrice() * orderItems.stream()
                        .filter(orderItem -> orderItem.getItemName().equals(item.getName()))
                        .findFirst().orElseThrow(() -> new RuntimeException("Unexpected error"))
                        .getQuantity())
                .sum();
        order.setTotalAmount(totalAmount);

        // Save the order
        orderRepository.save(order);

        return order;
    }

}