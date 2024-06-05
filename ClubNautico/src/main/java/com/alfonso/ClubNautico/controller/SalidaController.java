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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alfonso.ClubNautico.entity.Patron;
import com.alfonso.ClubNautico.entity.Salida;
import com.alfonso.ClubNautico.repository.PatronRepository;
import com.alfonso.ClubNautico.service.SalidaService;

@RestController
@RequestMapping("/api/salidas")
public class SalidaController {
	
	@Autowired
	SalidaService salidaServ;
	
	@Autowired
	PatronRepository patronRep;
	
	@GetMapping // Esta anotación muestra todos las salidas
	public List<Salida> findAllSalidas(){
		return salidaServ.findAllSalidas();
	}
	
	
	@GetMapping("/findSalidaById/{id}") // Esta obtiene una salida por su id
    public ResponseEntity<Salida> getById(@PathVariable Long id) {
        Optional<Salida> salidaOpt = salidaServ.findSalidaById(id);
        return salidaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	
	@PostMapping("/createSalida") // Esta anotación crea una nueva salida
	public Salida saveSalida(@RequestBody Salida salida) {
        Long id_patron = salida.getPatron().getId_patron();
        Patron patron = patronRep.findById(id_patron)
                .orElseThrow(() -> new IllegalArgumentException("El patron " + id_patron + " no existe"));
        salida.setPatron(patron);
        return salidaServ.saveSalida(salida);
    }
	/*public Salida saveSalida(@RequestBody Salida salida) {
		return salidaServ.saveSalida(salida);
	}*/

	
	@PutMapping("/updateSalida/{id}") // Esta anotación actualiza una nueva salida
	public Salida updateSalida(@PathVariable Long id, @RequestBody Salida salida) { //indico que en la url voy a recibir una variable id de tipo Long y un objeto salida
		return salidaServ.updateSalida(id, salida);
	}

	
	@DeleteMapping("/deleteSalida/{id}") // Esta anotación elimina una salida
	public String deleteSalida(@PathVariable Long id) { // Indico que en la url voy a recibir una variable id de tipo Long
		salidaServ.deleteSalida(id);
		
		return "La salida " + id + " ha sido eliminada";
	}

}
