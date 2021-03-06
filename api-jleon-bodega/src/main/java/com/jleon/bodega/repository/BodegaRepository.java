package com.jleon.bodega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jleon.bodega.model.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer> {

}
