package com.example.listapeliculas;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.listapeliculas.modelo.Pelicula;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    ArrayList<Pelicula> lista = new ArrayList<>();
    private MutableLiveData<ArrayList<Pelicula>> peliculas = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();

        lista.add(new Pelicula("Pulp Fiction", "Un ladrón profesional y su socio", "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", "1994", "Crimen, Drama", "Quentin Tarantino"));
        lista.add(new Pelicula("El Padrino", "La historia de una familia de mafiosos", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", "1972", "Crimen, Drama", "Francis Ford Coppola"));
        lista.add(new Pelicula("Jurassic Park", "Parque temático con dinosaurios clonados", "https://m.media-amazon.com/images/M/MV5BMjM2MDgxMDg0Nl5BMl5BanBnXkFtZTgwNTM2OTM5NDE@._V1_SX300.jpg", "1993", "Aventura, Ciencia ficción", "Steven Spielberg"));
        lista.add(new Pelicula("El Rey León", "Un joven león lucha por reclamar su trono", "https://m.media-amazon.com/images/M/MV5BYTYxNGMyZTYtMjE3MS00MzNjLWFjNmYtMDk3N2FmM2JiM2M1XkEyXkFqcGdeQXVyNjY5NDU4NzI@._V1_SX300.jpg", "1994", "Animación, Aventura", "Rob Minkoff, Roger Allers"));
        lista.add(new Pelicula("Regreso al Futuro", "Un joven viaja en el tiempo con un DeLorean", "https://m.media-amazon.com/images/M/MV5BZmU0M2Y1OGUtZjIxNi00ZjBkLTg1MjgtOWIyNThiZWIwYjRiXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "1985", "Ciencia ficción, Comedia", "Robert Zemeckis"));
        lista.add(new Pelicula("Interstellar", "Un grupo de astronautas viajan a través de un agujero de gusano", "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg", "2014", "Ciencia ficción, Drama", "Christopher Nolan"));

        peliculas.setValue(lista);
    }

    public LiveData<ArrayList<Pelicula>> getPeliculas() {
        if (peliculas.getValue() == null) {
            this.peliculas = new MutableLiveData<>();
        }

        return peliculas;
    }

}
