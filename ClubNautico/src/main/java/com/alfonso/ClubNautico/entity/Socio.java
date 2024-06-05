package com.alfonso.ClubNautico.entity;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="socios")
@Data//Uso lombok para simplificar el codigo (constructores, getters y setter)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Socio {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id_socio;
		private String dni;
		private String nombre;
		private String apellidos;
		private String num_telef;
		
		//Relacion Socio con Barco (Donde un socio puede tener uno o varios barcos)
		@OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private Set<Barco> barcos = new HashSet<>();
		
		//Getters and setters porque @Data no funciona
		public Long getId_socio() {
			return id_socio;
		}
		public void setId_socio(Long id_socio) {
			this.id_socio = id_socio;
		}
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
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
		public String getNum_telef() {
			return num_telef;
		}
		public void setNum_telef(String num_telef) {
			this.num_telef = num_telef;
		}
		public Set<Barco> getBarcos() {
			return barcos;
		}
		public void setBarcos(Set<Barco> barcos) {
			this.barcos = barcos;
		}
		
		
}
