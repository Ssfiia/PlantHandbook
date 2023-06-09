package com.example.planthandbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> {

    private final List<Plant> plants;
    private final LayoutInflater inflater;

    public PlantAdapter(Context context, List<Plant> plants) {
        this.inflater = LayoutInflater.from(context);
        this.plants = plants;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Plant plant = plants.get(position);
        holder.plantView.setImageResource(plant.getPlantResource());
        holder.nameView.setText(plant.getName());
        holder.plantDescriptionView.setText(plant.getPlantDescription());
        holder.populationSizeView.setText(plant.getPopulationSize());
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView plantView;
        final TextView nameView, plantDescriptionView, populationSizeView;

        ViewHolder(View view){
            super(view);
            plantView = view.findViewById(R.id.plantResource);
            nameView = view.findViewById(R.id.name);
            plantDescriptionView = view.findViewById(R.id.plantDescription);
            populationSizeView = view.findViewById(R.id.populationSize);

        }
    }

}
