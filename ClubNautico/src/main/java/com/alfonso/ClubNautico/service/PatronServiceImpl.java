package com.alfonso.ClubNautico.service;

import java.util.List;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfonso.ClubNautico.entity.Patron;
import com.alfonso.ClubNautico.repository.PatronRepository;

@Service
public class PatronServiceImpl implements PatronService{
	
	@Autowired
	PatronRepository patronRep;

	@Override
	public List<Patron> findAllPatrones() {
		// TODO Auto-generated method stub
		return patronRep.findAll();
	}

	@Override
	public Patron savePatron(Patron patron) {
		// TODO Auto-generated method stub
		return patronRep.save(patron);
	}

	@Override
	public Patron updatePatron(Long id, Patron patron) {
		// TODO Auto-generated method stub
		
		Patron p = patronRep.findById(id).get();
		if(Objects.nonNull(patron.getNombre()) && !"".equalsIgnoreCase(patron.getNombre())){
			p.setNombre(patron.getNombre());
		}
		
		if(Objects.nonNull(patron.getApellidos()) && !"".equalsIgnoreCase(patron.getApellidos())){
			p.setApellidos(patron.getApellidos());
		}
		
		if(Objects.nonNull(patron.getDni()) && !"".equalsIgnoreCase(patron.getApellidos())){
			p.setDni(patron.getDni());
		}
		
		return patronRep.save(p);
	}

	@Override
	public void deletePatron(Long id) {
		// TODO Auto-generated method stub
		
		patronRep.deleteById(id);
	}

	@Override
	public Optional<Patron> findPatronById(Long id) {
		// TODO Auto-generated method stub
		return patronRep.findById(id);
	}


}
