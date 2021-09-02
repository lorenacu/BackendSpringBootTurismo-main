package com.turismogta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turismogta.entity.codigoQr;

@Repository
public interface codigoQrRepository extends JpaRepository<codigoQr, Integer> {

}
