package com.alfonso.ClubNautico.entity;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="salidas")
@Data //Uso lombok para simplificar el codigo (constructores, getters y setter)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Salida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_salida;
	private Date fecha_hora;
	private String destino;
	
	// Relacion Salida con Barco
	@ManyToOne
	@JoinColumn(name="id_barco")
	private Barco barco;
	
	
	// Relacion Salida con Patron
	@ManyToOne
	@JoinColumn(name="id_patron")
	private Patron patron;
	
	
	//Getters and setters porque @Data no funciona
	public Long getId_salida() {
		return id_salida;
	}

	public void setId_salida(Long id_salida) {
		this.id_salida = id_salida;
	}

	public Date getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	
	
}
