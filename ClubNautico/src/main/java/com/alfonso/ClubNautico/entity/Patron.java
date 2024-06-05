package com.alfonso.ClubNautico.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="patrones")
@Data //Uso lombok para simplificar el codigo (constructores, getters y setter)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patron {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_patron;
	private String nombre;
	private String apellidos;
	private String dni;

	
	// Relacion entre Patron y Salida (Un patron puede controlar varias salida)
	@OneToMany(mappedBy = "patron", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Salida> salidas;
	
	
	//Getters and setters porque @Data no funciona
	public Long getId_patron() {
		return id_patron;
	}

	public void setId_patron(Long id_patron) {
		this.id_patron = id_patron;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Salida> getSalidas() {
		return salidas;
	}

	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}

	
	

}
