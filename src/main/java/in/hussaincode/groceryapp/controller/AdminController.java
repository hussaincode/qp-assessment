package in.hussaincode.groceryapp.controller;

import in.hussaincode.groceryapp.entity.GroceryItem;
import in.hussaincode.groceryapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/items")
    public String addGroceryItem(@RequestBody GroceryItem item) {
        adminService.addGroceryItem(item);
        return "Item added successfully";
    }

    @GetMapping("/items")
    public List<GroceryItem> viewGroceryItems() {
        return adminService.viewGroceryItems();
    }

    @DeleteMapping("/items/{itemId}")
    public String removeGroceryItem(@PathVariable Long itemId) {
        adminService.removeGroceryItem(itemId);
        return "Item removed successfully";
    }

    @PutMapping("/items/{itemId}")
    public String updateGroceryItem(@PathVariable Long itemId, @RequestBody GroceryItem updatedItem) {
        adminService.updateGroceryItem(itemId, updatedItem);
        return "Item updated successfully";
    }

    @PatchMapping("/items/{itemId}/inventory")
    public String manageInventory(@PathVariable Long itemId, @RequestParam int quantity) {
        adminService.manageInventory(itemId, quantity);
        return "Inventory updated successfully";
    }
}
