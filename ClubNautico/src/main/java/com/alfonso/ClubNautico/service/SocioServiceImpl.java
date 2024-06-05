package com.alfonso.ClubNautico.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfonso.ClubNautico.entity.Socio;
import com.alfonso.ClubNautico.repository.SocioRepository;

@Service
public class SocioServiceImpl implements SocioService{

	@Autowired
	SocioRepository socioRep;
	
	@Override
	public List<Socio> findAllSocios() {
		// TODO Auto-generated method stub
		return socioRep.findAll();
	}

	@Override
	public Socio saveSocio(Socio socio) {
		// TODO Auto-generated method stub
		return socioRep.save(socio);
	}

	@Override
	public Socio updateSocio(Long id, Socio socio) {
		// TODO Auto-generated method stub
		
		Socio s = socioRep.findById(id).get();
		if(Objects.nonNull(socio.getDni()) && !"".equalsIgnoreCase(socio.getDni())){
			s.setDni(socio.getDni());
		}
		
		if(Objects.nonNull(socio.getNombre()) && !"".equalsIgnoreCase(socio.getNombre())){
			s.setNombre(socio.getNombre());
		}
		
		if(Objects.nonNull(socio.getApellidos()) && !"".equalsIgnoreCase(socio.getApellidos())){
			s.setApellidos(socio.getApellidos());
		}
		
		if(Objects.nonNull(socio.getNum_telef()) && !"".equalsIgnoreCase(socio.getNum_telef())){
			s.setNum_telef(socio.getNum_telef());
		}
		
		return socioRep.save(s);
	}

	@Override
	public void deleteSocio(Long id) {
		// TODO Auto-generated method stub
		
		socioRep.deleteById(id);
		
	}

	@Override
	public Optional<Socio> findById(Long id) {
		// TODO Auto-generated method stub
		return socioRep.findById(id);
	}
	

}
