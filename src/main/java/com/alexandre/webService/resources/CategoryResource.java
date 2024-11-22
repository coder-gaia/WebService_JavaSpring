package com.alexandre.webService.resources;

import com.alexandre.webService.entities.Category;
import com.alexandre.webService.entities.Order;
import com.alexandre.webService.services.CategoryService;
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
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<>(categoryService.findAllOrders(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id), HttpStatusCode.valueOf(200));
    }
}
