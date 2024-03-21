package de.uniba.dsam.group.project.controllers;//package de.uniba.dsam.group.project.controllers;//package de.uniba.dsam.group.project.controllers;
//
//import de.uniba.dsam.group.project.models.OrderItem;
//import de.uniba.dsam.group.project.services.OrderItemsService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/orderItems")
//public class OrderItemsController {
//    private final OrderItemsService oderItemsService;
//    public OrderItemsController(OrderItemsService oderItemsService) {
//        this.oderItemsService = oderItemsService;
//    }
//
//    @GetMapping("/order/{orderId}")
//    public ResponseEntity<List<OrderItem>> findByOrderId(@PathVariable Long orderId){
//        List<OrderItem> orderItems = oderItemsService.findAllOrderedItemsByOrderId(orderId);
//        return (orderItems != null) ? new ResponseEntity<>(orderItems, HttpStatus.OK):
//                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping
//    public ResponseEntity<String> crateOrderItem(@RequestBody OrderItem orderItem){
//        this.oderItemsService.createOrderItem(orderItem);
//        return new ResponseEntity<>("Order Item Created successfully.", HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<OrderItem> findOrderItemById(@PathVariable Long id){
//        OrderItem orderItem = this.oderItemsService.findOrderItemById(id);
//        if (orderItem != null) {
//            return new ResponseEntity<>(orderItem, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteOrderItemById(@PathVariable Long id){
//        boolean isDeleted = this.oderItemsService.deleteOrderItemById(id);
//        return isDeleted ? new ResponseEntity<>("Order Item deleted successfully!", HttpStatus.OK):
//                new ResponseEntity<>("Could not find the id", HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateOrderItemById(@RequestBody OrderItem updatedOrderItem, @PathVariable Long id){
//        boolean isUpdated = this.oderItemsService.updateOrderItems(updatedOrderItem, id);
//        return isUpdated ? new ResponseEntity<>("OrderItem updated successfully!", HttpStatus.OK):
//                new ResponseEntity<>("Could not update.", HttpStatus.NOT_ACCEPTABLE);
//    }
//}
//
