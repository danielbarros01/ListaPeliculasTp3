package com.example.listapeliculas.modelo;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String nombre, descripcion, imagen, estreno, genero, director;

    public Pelicula(String nombre, String descripcion, String imagen, String estreno, String genero, String director) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.estreno = estreno;
        this.genero = genero;
        this.director = director;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstreno() {
        return estreno;
    }

    public void setEstreno(String estreno) {
        this.estreno = estreno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
