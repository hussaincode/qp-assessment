package in.hussaincode.groceryapp.repository;

import in.hussaincode.groceryapp.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
}
