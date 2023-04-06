package com.example.listapeliculas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.listapeliculas.modelo.Pelicula;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<Pelicula> peliculas;
    private LayoutInflater inflater;

    public MainAdapter(Context context, List<Pelicula> peliculas, LayoutInflater inflater) {
        this.context = context;
        this.peliculas = peliculas;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.item_pelicula, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.descripcion.setText(peliculas.get(position).getDescripcion());
        holder.nombre.setText(peliculas.get(position).getNombre());

        Glide.with(context)
                .load(peliculas.get(position).getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoPelicula);

        //Click del boton
        holder.btnDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("pelicula", peliculas.get(position));
                Intent intent = new Intent(context, DetallesActivity.class);
                intent.putExtra("pelicula", bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fotoPelicula;
        TextView nombre,descripcion;
        Button btnDetalles;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoPelicula = itemView.findViewById(R.id.ivPelicula);
            descripcion = itemView.findViewById(R.id.tvDescripcionPelicula);
            nombre = itemView.findViewById(R.id.tvNombrePelicula);
            btnDetalles = itemView.findViewById(R.id.btnDetallesPelicula);
        }
    }
}
