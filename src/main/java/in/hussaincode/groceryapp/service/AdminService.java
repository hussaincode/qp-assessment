package in.hussaincode.groceryapp.service;

import in.hussaincode.groceryapp.entity.GroceryItem;

import java.util.List;

public interface AdminService {
    void addGroceryItem(GroceryItem item);
    List<GroceryItem> viewGroceryItems();
    void removeGroceryItem(Long itemId);
    void updateGroceryItem(Long itemId, GroceryItem updatedItem);
    void manageInventory(Long itemId, int quantity);
}
