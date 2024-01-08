package in.hussaincode.groceryapp.service;

import in.hussaincode.groceryapp.entity.GroceryItem;
import in.hussaincode.groceryapp.entity.OrderItemRequest;
import in.hussaincode.groceryapp.entity.Orders;

import java.util.List;

public interface UserService {
    List<GroceryItem> viewAvailableItems();

    Orders placeOrder(List<OrderItemRequest> items);
}