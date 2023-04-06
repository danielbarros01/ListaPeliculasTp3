package com.example.listapeliculas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.example.listapeliculas.databinding.ActivityMainBinding;
import com.example.listapeliculas.modelo.Pelicula;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mv;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        RecyclerView rv = binding.rvLista;
        GridLayoutManager grilla = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(grilla);

        mv.getPeliculas().observe(this, new Observer<ArrayList<Pelicula>>() {
            @Override
            public void onChanged(ArrayList<Pelicula> peliculas) {
                MainAdapter adapter = new MainAdapter(MainActivity.this, peliculas, getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });
    }
}