package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    @Query(value = "SELECT * FROM Stores WHERE name like %?%", nativeQuery = true)
    List<Store> storeNameLike(String name);

}
