package com.alexandre.webService.resources;

import com.alexandre.webService.entities.Order;
import com.alexandre.webService.entities.User;
import com.alexandre.webService.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;


    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> findAll(){
        return new ResponseEntity<>(orderService.findAllOrders(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable Long id){
//        Optional<Order> obj = orderService.findById(id);
//        return ResponseEntity.ok().body(obj);
        return new ResponseEntity<>(orderService.findById(id), HttpStatusCode.valueOf(200));
    }
}
