package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/stores")
    public List<Store> getAllStores(Pageable pageable) {
        return storeRepository.findAll();
    }

    @GetMapping("/stores/{storeId}")
    public Store getOneStore(@PathVariable Long storeId) {
        return storeRepository.findById(storeId).map(store -> {
            return store;
        }).orElseThrow(() -> new NotFoundException("Store not found with id " + storeId));
    }

    @PostMapping("/stores")
    public Store createStore(@Valid @RequestBody Store store) {
        return storeRepository.save(store);
    }

    @PutMapping("/stores/{storeId}")
    public Store updateStore(@PathVariable Long storeId, @Valid @RequestBody Store storeRequest) {
        return storeRepository.findById(storeId).map(store -> {
            store.setName(storeRequest.getName());
            store.setDescription(storeRequest.getDescription());
            return storeRepository.save(store);
        }).orElseThrow(() -> new NotFoundException("Store not found with id " + storeId));
    }

    @DeleteMapping("/stores/{storeId}")
    public ResponseEntity<?> deleteStore(@PathVariable Long storeId) {
        return storeRepository.findById(storeId).map(store -> {
            storeRepository.delete(store);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("Store not found with id " + storeId));
    }
}