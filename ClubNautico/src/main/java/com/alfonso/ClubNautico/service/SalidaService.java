package com.alfonso.ClubNautico.service;

import java.util.List;
import java.util.Optional;

import com.alfonso.ClubNautico.entity.Salida;

public interface SalidaService {
	
	List<Salida> findAllSalidas();
	Salida saveSalida(Salida salida);
	Salida updateSalida(Long id, Salida salida);
	void deleteSalida(Long id);
	Optional<Salida> findSalidaById(Long id);

}
