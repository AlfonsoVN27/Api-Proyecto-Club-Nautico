package com.alfonso.ClubNautico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alfonso.ClubNautico.entity.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long>	{

	//Hago la consulta con IoC
	Optional<Socio> findById(Long id);
}
