package com.mationate.wineapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mationate.wineapp.models.Wine;

import java.util.List;

public class WinesAdapter extends  RecyclerView.Adapter<WinesAdapter.ViewHolder>  {

    private List <Wine> wines = new Queries().wines();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_wines,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Wine wine = wines.get(position);
        holder.wineName.setText(wine.getWineName());
        holder.wineYear.setText(wine.getWineYear());
        holder.wineType.setText(wine.getWineType());
    }

    @Override
    public int getItemCount() {
        return wines.size();
    }

    public void update(Wine wine) {
        wines.add(wine);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView wineName, wineYear, wineType;

        public ViewHolder(View itemView) {
            super(itemView);

            wineName = itemView.findViewById(R.id.nameTv);
            wineYear = itemView.findViewById(R.id.yearTv);
            wineType = itemView.findViewById(R.id.typeTv);
        }

    }
}
