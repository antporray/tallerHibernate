package org.springframework.samples.petclinic.alumn;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.samples.petclinic.model.BaseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "alumnos")
public class Alumno extends BaseEntity {

    @Column(name = "nombre")
    @NotEmpty
    @ApiModelProperty(notes="Nombre del alumno")
    private String nombre;

    @Column(name = "apellidos")
    @NotEmpty
    @ApiModelProperty(notes="Apellido del alumno")
    private String apellidos;

    @Column(name = "fechaNacimiento")
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaNacimiento;
    
    @Column(name = "nota")
    @NotNull
    private Integer nota;
    
  
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ ", nota=" + nota + ", id=" + id + "]";
	}
    
}