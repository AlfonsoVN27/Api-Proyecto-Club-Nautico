package com.alfonso.ClubNautico.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="barcos", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
@Data //Uso lombok para simplificar el codigo (constructores, getters y setter)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Barco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_barco;
	private String matricula;
	private String nombre;
	private String num_amarre;
	private String cuota;
	
	// Relacion Barco con Socio
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //especifico que me la muestre cuando yo la pida
	@JoinColumn(name="id_socio") // marco que sea la propietaria
	@JsonProperty(access = Access.WRITE_ONLY)
	private Socio socio;
	
	
	// Relacion Barco con Salida (Un barco puede realizar muchas salidas)
	@OneToMany(mappedBy = "barco", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Salida> salidas;
	
	
	//Getters and setters porque @Data no funciona
	public Long getId_barco() {
		return id_barco;
	}
	public void setId_barco(Long id_barco) {
		this.id_barco = id_barco;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNum_amarre() {
		return num_amarre;
	}
	public void setNum_amarre(String num_amarre) {
		this.num_amarre = num_amarre;
	}
	public String getCuota() {
		return cuota;
	}
	public void setCuota(String cuota) {
		this.cuota = cuota;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public List<Salida> getSalidas() {
		return salidas;
	}
	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}


}
