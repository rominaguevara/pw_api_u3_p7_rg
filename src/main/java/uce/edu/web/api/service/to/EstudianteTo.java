package uce.edu.web.api.service.to;

import java.io.Serializable;

import jakarta.persistence.Column;

public class EstudianteTo implements Serializable{
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer Semestre;

    //CONSTRUCTORES
    public EstudianteTo(){

    }   

    public EstudianteTo(Integer id, String nombre, String apellido, Integer edad, Integer semestre) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        Semestre = semestre;
    }

    //SETTER Y GETTER
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    public Integer getSemestre() {
        return Semestre;
    }
    public void setSemestre(Integer semestre) {
        Semestre = semestre;
    }


    
}
