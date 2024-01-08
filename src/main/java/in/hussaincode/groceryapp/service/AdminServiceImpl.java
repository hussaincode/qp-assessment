package in.hussaincode.groceryapp.service;

import in.hussaincode.groceryapp.entity.GroceryItem;
import in.hussaincode.groceryapp.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Override
    public void addGroceryItem(GroceryItem item) {
        groceryItemRepository.save(item);
    }

    @Override
    public List<GroceryItem> viewGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public void removeGroceryItem(Long itemId) {
        groceryItemRepository.deleteById(itemId);
    }

    @Override
    public void updateGroceryItem(Long itemId, GroceryItem updatedItem) {
        Optional<GroceryItem> existingItem = groceryItemRepository.findById(itemId);
        if (existingItem.isPresent()) {
            updatedItem.setId(itemId);
            groceryItemRepository.save(updatedItem);
        }
    }

    @Override
    public void manageInventory(Long itemId, int quantity) {
        Optional<GroceryItem> existingItem = groceryItemRepository.findById(itemId);
        existingItem.ifPresent(item -> {
            item.setQuantity(item.getQuantity() + quantity);
            groceryItemRepository.save(item);
        });
    }

}
