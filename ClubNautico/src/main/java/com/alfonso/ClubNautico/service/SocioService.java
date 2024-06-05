package com.alfonso.ClubNautico.service;

import java.util.List;
import java.util.Optional;

import com.alfonso.ClubNautico.entity.Socio;

public interface SocioService {
	
	List<Socio> findAllSocios();
	
	Socio saveSocio(Socio socio);
	Socio updateSocio(Long id, Socio socio);
	void deleteSocio(Long id);
	Optional<Socio> findById(Long id);

}
