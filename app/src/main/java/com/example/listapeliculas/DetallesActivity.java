package com.example.listapeliculas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.listapeliculas.databinding.ActivityDetallesBinding;
import com.example.listapeliculas.modelo.Pelicula;

public class DetallesActivity extends AppCompatActivity {

    private ActivityDetallesBinding binding;
    private DetallesActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetallesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetallesActivityViewModel.class);

        Bundle bundle = getIntent().getBundleExtra("pelicula");
        Pelicula pelicula = (Pelicula) bundle.getSerializable("pelicula");

        vm.setPelicula(pelicula);

        vm.getPelicula().observe(this, new Observer<Pelicula>() {
            @Override
            public void onChanged(Pelicula pelicula) {
                // Actualizar vista con los datos correspondientes
                binding.tvTitulo.setText(pelicula.getNombre());
                binding.tvEstrenoDetalles.setText("Estreno en " + pelicula.getEstreno());
                binding.tvDescripcionDetalles.setText(pelicula.getDescripcion());
                binding.tvDirectorDetalles.setText(pelicula.getDirector());
                binding.tvGenerosDetalles.setText(pelicula.getGenero());

                Glide.with(DetallesActivity.this)
                        .load(pelicula.getImagen())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(binding.ivPortada);
            }
        });

    }
}