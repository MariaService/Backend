package es.back.odontologia.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T0002_ROL")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rol;

    @Column(name = "Fecha_Creacion")
    private Date fechaCreacion;

    @Column(name = "Descricion_Rol")
    private String  descricionRol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getDescricionRol() {
		return descricionRol;
	}

	public void setDescricionRol(String descricionRol) {
		this.descricionRol = descricionRol;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", rol=" + rol + ", fechaCreacion=" + fechaCreacion + ", descricionRol="
				+ descricionRol + "]";
	}
    
    

}
