package com.alfonso.ClubNautico.service;

import java.util.List;


import java.util.Optional;

import com.alfonso.ClubNautico.entity.Barco;

public interface BarcoService {
	
	List<Barco> findAllBarcos();
	Optional<Barco> findBarcoById(Long id);
	Barco saveBarco(Barco barco);
	Barco updateBarco(Long id, Barco barco);
	void deleteBarco(Long id);
	
	
}
