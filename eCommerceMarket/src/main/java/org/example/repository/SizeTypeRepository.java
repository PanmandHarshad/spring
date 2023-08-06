package org.example.repository;

import org.example.model.SizeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeTypeRepository extends JpaRepository<SizeType, Integer> {
}
