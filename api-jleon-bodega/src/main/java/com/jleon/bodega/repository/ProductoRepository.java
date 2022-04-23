package com.jleon.bodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jleon.bodega.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
