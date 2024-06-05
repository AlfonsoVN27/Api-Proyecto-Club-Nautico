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

import com.alfonso.ClubNautico.entity.Barco;
import com.alfonso.ClubNautico.entity.Socio;
import com.alfonso.ClubNautico.service.BarcoService;
import com.alfonso.ClubNautico.service.SocioService;

@RestController
public class BarcoController {
	
	@Autowired
	BarcoService barcoServ;
	
	@Autowired
    SocioService socioService;
	
	
	@GetMapping("/findAllBarcos") // Esta anotacion muestra todos los barcos
	public List<Barco> findAllBarcos(){
		return barcoServ.findAllBarcos();
	}
	
	
	@GetMapping("/findBarcoById/{id}") // Esta anotación obtiene un barco por su id
    public ResponseEntity<Barco> getById(@PathVariable Long id) {
        Optional<Barco> barcoOpt = barcoServ.findBarcoById(id);
        return barcoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	
	@PostMapping("/createBarco/{id}") // Este crea el barco y se lo asocia a un socio segun el id 
	public ResponseEntity<Socio> addBarcoToSocio(@PathVariable Long id, @RequestBody Barco barco) {
        Optional<Socio> socioOpt = socioService.findById(id);
        if (socioOpt.isPresent()) {
            Socio socio = socioOpt.get();
            barco.setSocio(socio);
            socio.getBarcos().add(barco);
            socioService.saveSocio(socio);
            return ResponseEntity.ok(socio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	
	@PutMapping("/updateBarco/{id}") // Esta anotacion actualiza un nuevo barco
	public Barco updateBarco(@PathVariable Long id, @RequestBody Barco barco) { //indico que en la url voy a recibir una variable id de tipo Long y un objeto barco
		return barcoServ.updateBarco(id, barco);
	}

	
	@DeleteMapping("/deleteBarco/{id}") // Esta anotacion elimina un barco
	public String deleteBarco(@PathVariable Long id) { //indico que en la url voy a recibir una variable id de tipo Long
		barcoServ.deleteBarco(id);
		
		return "El barco " + id + " ha sido eliminado";
	}

}
