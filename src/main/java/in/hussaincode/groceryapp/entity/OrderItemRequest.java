package in.hussaincode.groceryapp.entity;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Long itemId;
    private String itemName;
    private int quantity;
}
