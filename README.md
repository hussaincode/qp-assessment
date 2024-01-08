************************************ Read this before running the project ***********************************

* Tech used - Java Springboot, Data JPA, Docker
*************************************************************************************************************
1. Colne this repo

2. Build the project

3. Run the project

 Then hit the url given below:-
 
 For Admin -
1. To get all the grocery item available - Curl Get http://localhost:8080/admin/items

2. To Add the item in the stock - Curl Post http://localhost:8080/admin/items and in body send this data as json

{"name": "Oil",
"price": 150,
"quantity": 5
}

3. To Delete - http://localhost:8080/admin/items/{itemId}

4. To Update - http://localhost:8080/admin/items/4 and in body send this json data

{"name": "Refine",
"price": 170,
"quantity": 6
}

5. To Update the stock of some specific item : Curl Patch http://localhost:8080/admin/items/{}itemId/inventory?quantity=5 and in parameter add the quantity of that specifc item

For User -

1. To View items available in the store - Curl Get http://localhost:8080/user/items

2. To Order - Curl Post http://localhost:8080/user/orders and in body send the items that you want to order as json

[
  {
    "itemName": "Refine",
    "quantity": 1
  },
  {
    "itemName": "Rice",
    "quantity": 1
  }
]



*************************************************** Thank You ***************************************************
