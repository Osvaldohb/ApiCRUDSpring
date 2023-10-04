package com.prueba.api.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String Nombre;

    private String ApellidoP;

    private String ApellidoM;

    private Integer Edad;

    public User() {
    }

    public User(Long ID, String nombre, String apellidoP, String apellidoM, Integer edad) {
        this.ID = ID;
        Nombre = nombre;
        ApellidoP = apellidoP;
        ApellidoM = apellidoM;
        Edad = edad;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String apellidoP) {
        ApellidoP = apellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String apellidoM) {
        ApellidoM = apellidoM;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Nombre='" + Nombre + '\'' +
                ", ApellidoP='" + ApellidoP + '\'' +
                ", ApellidoM='" + ApellidoM + '\'' +
                ", Edad=" + Edad +
                '}';
    }
}
