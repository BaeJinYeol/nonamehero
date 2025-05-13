package com.example.nonamehero.repository;

import com.example.nonamehero.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
