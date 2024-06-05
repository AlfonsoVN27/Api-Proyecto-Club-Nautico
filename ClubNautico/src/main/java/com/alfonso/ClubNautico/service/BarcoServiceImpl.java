package com.alfonso.ClubNautico.service;

import java.util.List;


import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfonso.ClubNautico.entity.Barco;
import com.alfonso.ClubNautico.repository.BarcoRepository;

@Service
public class BarcoServiceImpl implements BarcoService{
	
	@Autowired
	BarcoRepository barcoRep;
	
	@Override
	public List<Barco> findAllBarcos() {
		// TODO Auto-generated method stub
		return barcoRep.findAll();
	}

	@Override
	public Barco saveBarco(Barco barco) {
		// TODO Auto-generated method stub
		return barcoRep.save(barco);
	}

	@Override
	public Barco updateBarco(Long id, Barco barco) {
		// TODO Auto-generated method stub
		
		Barco b = barcoRep.findById(id).get();
		if(Objects.nonNull(barco.getMatricula()) && !"".equalsIgnoreCase(barco.getMatricula())){
			b.setMatricula(barco.getMatricula());
		}
		
		if(Objects.nonNull(barco.getNombre()) && !"".equalsIgnoreCase(barco.getNombre())){
			b.setNombre(barco.getNombre());
		}
		
		if(Objects.nonNull(barco.getNum_amarre()) && !"".equalsIgnoreCase(barco.getNum_amarre())){
			b.setNum_amarre(barco.getNum_amarre());
		}
		
		if(Objects.nonNull(barco.getCuota()) && !"".equalsIgnoreCase(barco.getCuota())){
			b.setCuota(barco.getCuota());
		}
		
		return barcoRep.save(b);
	}

	@Override
	public void deleteBarco(Long id) {
		// TODO Auto-generated method stub
		
		barcoRep.deleteById(id);	
	}
	
	
	public Optional<Barco> findBarcoById(Long id) {
        return barcoRep.findById(id);
    }
	
	/*@Override
	public Optional<Barco> findByIdBarco(Long id) {
		// TODO Auto-generated method stub
		return barcoRep.findById(id);
	}*/

}
