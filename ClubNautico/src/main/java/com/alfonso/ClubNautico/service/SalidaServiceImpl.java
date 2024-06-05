package com.alfonso.ClubNautico.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfonso.ClubNautico.entity.Salida;
import com.alfonso.ClubNautico.repository.SalidaRepository;

@Service
public class SalidaServiceImpl implements SalidaService{

	@Autowired
	SalidaRepository salidaRep;
	
	@Override
	public List<Salida> findAllSalidas() {
		// TODO Auto-generated method stub
		return salidaRep.findAll();
	}

	@Override
	public Salida saveSalida(Salida salida) {
		// TODO Auto-generated method stub
		return salidaRep.save(salida);
	}

	@Override
	public Salida updateSalida(Long id, Salida salida) {
		// TODO Auto-generated method stub
		Salida s = salidaRep.findById(id).get();
		if (Objects.nonNull(salida.getFecha_hora())) {
		    s.setFecha_hora(salida.getFecha_hora());
		}
		
		if(Objects.nonNull(salida.getDestino()) && !"".equalsIgnoreCase(salida.getDestino())){
			s.setDestino(salida.getDestino());
		}
		
		return salidaRep.save(s);
	}

	@Override
	public void deleteSalida(Long id) {
		// TODO Auto-generated method stub
		salidaRep.deleteById(id);
	}

	@Override
	public Optional<Salida> findSalidaById(Long id) {
		// TODO Auto-generated method stub
		return salidaRep.findById(id);
	}

}
