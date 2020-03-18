package com.example.via.repository;

import com.example.via.entity.Via;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaRepository extends JpaRepository<Via,Long> {
}
