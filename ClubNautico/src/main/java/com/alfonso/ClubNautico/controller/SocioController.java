package com.alfonso.ClubNautico.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alfonso.ClubNautico.entity.Socio;
import com.alfonso.ClubNautico.service.SocioService;

@RestController
public class SocioController {

	@Autowired
	SocioService socioServ;
	
	
	@GetMapping("/findAllSocios") // Esta anotación muestra todos los socios y si estos tienen barcos, los mostrara también
	public List<Socio> findAllSocios(){
		return socioServ.findAllSocios();
	}
	
	
	@GetMapping("/findById/{id}") // Esta anotación obtiene un socio por su id
    public ResponseEntity<Socio> getById(@PathVariable Long id) {
        Optional<Socio> socioOpt = socioServ.findById(id);
        return socioOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	
	@PostMapping("/createSocio") // Esta anotación crea un nuevo socio
	public Socio saveSocio(@RequestBody Socio socio) {
		return socioServ.saveSocio(socio);
	}

	
	@PutMapping("/updateSocio/{id}") // Esta anotación actualiza un nuevo socio
	public Socio updateSocio(@PathVariable Long id, @RequestBody Socio socio) { //indico que en la url voy a recibir una variable id de tipo Long y un objeto socio
		return socioServ.updateSocio(id, socio);
	}

	
	@DeleteMapping("/deleteSocio/{id}") // Esta anotación elimina un socio
	public String deleteSocio(@PathVariable Long id) { // Indico que en la url voy a recibir una variable id de tipo Long
		socioServ.deleteSocio(id);
		
		return "El socio " + id + " ha sido eliminado";
	}
	

}