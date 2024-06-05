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

import com.alfonso.ClubNautico.entity.Patron;
import com.alfonso.ClubNautico.service.PatronService;

@RestController
public class PatronController {
	
	@Autowired
	PatronService patronServ;
	
	@GetMapping("/findAllPatrones") // Esta anotacion muestra todos los patrones
	public List<Patron> findAllPatrones(){
		return patronServ.findAllPatrones();
	}
	
	@GetMapping("/findPatronById/{id}") // Esta obtiene un patron por su id
    public ResponseEntity<Patron> getById(@PathVariable Long id) {
        Optional<Patron> patronOpt = patronServ.findPatronById(id);
        return patronOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@PostMapping("/createPatron") // Esta anotacion crea un nuevo patron
	public Patron savePatron(@RequestBody Patron patron) {
		return patronServ.savePatron(patron);
	}
	
	@PutMapping("/updatePatron/{id}") // Esta anotacion actualiza un nuevo patron
	public Patron updatePatron(@PathVariable Long id, @RequestBody Patron patron) { //indico que en la url voy a recibir una variable id de tipo Long y un objeto patron
		return patronServ.updatePatron(id, patron);
	}

	@DeleteMapping("/deletePatron/{id}") // Esta anotacion elimina un patron
	public String deletePatron(@PathVariable Long id) { //indico que en la url voy a recibir una variable id de tipo Long
		patronServ.deletePatron(id);
		
		return "El patron " + id + " ha sido eliminado";
	}

}
