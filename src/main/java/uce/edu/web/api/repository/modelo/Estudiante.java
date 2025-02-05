package uce.edu.web.api.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_estudiante", sequenceName = "seq_estudiante", allocationSize = 1)
    @Column(name = "est_id")
    private Integer id;

    @Column(name = "est_nombre")
    private String nombre;

    @Column(name = "est_apellido")
    private String apellido;

    @Column(name = "est_edad")
    private Integer edad;

    @Column(name = "est_semestre")
    private Integer Semestre;


    //CINSTRUCTORES
    public Estudiante() {

    }

    public Estudiante(Integer id, String nombre, String apellido, Integer edad, Integer semestre) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        Semestre = semestre;
    }

    // GETTER Y SETTER
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
