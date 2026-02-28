package com.example.item_service;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/items")
public class ItemController {

    private List<String> items = new ArrayList<>(List.of("Book", "Laptop", "Phone"));

    @GetMapping
    public List<String> getItems() {
        return items;
    }

    @PostMapping
    public ResponseEntity<String> addItem(@RequestBody String item) {
        items.add(item);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item added: " + item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getItem(@PathVariable int id) {
        if (id < 0 || id >= items.size())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(items.get(id));
    }
}
