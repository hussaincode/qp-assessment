package in.hussaincode.groceryapp.controller;

import in.hussaincode.groceryapp.entity.GroceryItem;
import in.hussaincode.groceryapp.entity.OrderItemRequest;
import in.hussaincode.groceryapp.entity.Orders;
import in.hussaincode.groceryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/items")
    public List<GroceryItem> viewAvailableItems() {
        return userService.viewAvailableItems();
    }

    @PostMapping("/orders")
    public Orders placeOrder(@RequestBody List<OrderItemRequest> items) {
        return userService.placeOrder(items);
    }
}
