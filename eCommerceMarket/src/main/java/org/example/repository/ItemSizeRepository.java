package org.example.repository;

import org.example.model.ItemSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSizeRepository extends JpaRepository<ItemSize, Integer> {
}
