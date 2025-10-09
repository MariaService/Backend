package es.back.odontologia.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T0001_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Column(name = "Fecha_Creacion")
    private Date fechaCreacion;
    
    @Column(name = "Fecha_Nac")
    private Date fechaNac;


    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "Estatus", referencedColumnName = "id")
    private Estatus estatus;

    @ManyToOne
    @JoinColumn(name = "IDROL", referencedColumnName = "id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "IDFOTOGRAFIA", referencedColumnName = "id")
    private Fotografia fotografia;

    @Column(name = "NombreCompleto")
    private String nombreCompleto;

    
    private String tel;
    private String notas;
    @Column(name = "NickName")
    private String nickName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Estatus getEstatus() {
		return estatus;
	}
	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Fotografia getFotografia() {
		return fotografia;
	}
	public void setFotografia(Fotografia fotografia) {
		this.fotografia = fotografia;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", fechaCreacion=" + fechaCreacion
				+ ", fechaNac=" + fechaNac + ", fechaModificacion=" + fechaModificacion + ", estatus=" + estatus
				+ ", rol=" + rol + ", fotografia=" + fotografia + ", nombreCompleto=" + nombreCompleto + ", tel=" + tel
				+ ", notas=" + notas + ", nickName=" + nickName + "]";
	}
	
	
	
    // Getters y Setters
    
    
    
    
    
}