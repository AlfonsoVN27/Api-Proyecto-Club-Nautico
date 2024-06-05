package com.alfonso.ClubNautico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alfonso.ClubNautico.entity.Salida;

@Repository
public interface SalidaRepository extends JpaRepository<Salida, Long>{

}
