package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "docente")
public class DocenteModel {

    private int id;
    private String tipoDocumento;
	private String numeroIdentificacion;
	private String nombres;
	private String apellidos;
	private String grupo;
	private String email;
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (nullable = false, unique = true)
	
    public int getId() {
		return id;
	}
	
    public void setId(int id) {
		this.id = id;
	}
	
    public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
    public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	
    public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
    }
	
    public String getNombres() {
		return nombres;
	}
	
    public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
    public String getApellidos() {
		return apellidos;
	}
	
    public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
    public String getGrupo() {
		return grupo;
	}
	
    public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
    public String getEmail() {
		return email;
	}
	
    public void setEmail(String email) {
		this.email = email;
	}
}