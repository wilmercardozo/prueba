package com.example.tipovia.repository;

import com.example.tipovia.entity.TipoVia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoViaRepository extends JpaRepository<TipoVia,Long> {
}
