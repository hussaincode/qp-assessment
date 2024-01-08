package in.hussaincode.groceryapp.repository;

import in.hussaincode.groceryapp.entity.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem,Long> {

    GroceryItem findByName(String itemName);
}
