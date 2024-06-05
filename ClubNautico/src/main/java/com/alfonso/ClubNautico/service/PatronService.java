package com.alfonso.ClubNautico.service;

import java.util.List;
import java.util.Optional;

import com.alfonso.ClubNautico.entity.Patron;

public interface PatronService {
	
	List<Patron> findAllPatrones();
	Patron savePatron(Patron patron);
	Patron updatePatron(Long id, Patron patron);
	void deletePatron(Long id);
	Optional<Patron> findPatronById(Long id);
	

}
