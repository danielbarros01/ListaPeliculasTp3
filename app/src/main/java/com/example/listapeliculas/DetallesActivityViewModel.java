package com.example.listapeliculas;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.listapeliculas.modelo.Pelicula;

import java.util.ArrayList;

public class DetallesActivityViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<Pelicula> pelicula = new MutableLiveData<>();;

    public DetallesActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Pelicula> getPelicula() {
        if (pelicula.getValue() == null) {
            this.pelicula = new MutableLiveData<>();
        }

        return pelicula;
    }

    public void setPelicula(Pelicula p) {
        pelicula.setValue(p);
    }
}
