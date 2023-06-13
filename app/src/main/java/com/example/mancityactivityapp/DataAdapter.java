package com.example.mancityactivityapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private Context context;
    private int rowId;
    private Squad squad;

    private RecyclerViewInterface recyclerViewInterface;

    public DataAdapter(Context context, int rowId, Squad squad,RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.rowId = rowId;
        this.squad = squad;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(this.rowId,parent, false);

        return new ViewHolder(v,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(String.format("%s #%s", this.squad.getPlayerAt(position).getName(),this.squad.getPlayerAt(position).getShirtNumber()));
        String name = this.squad.getPlayerAt(position).getImage();
        name = name.substring(0, name.indexOf("."));
        int imageId = this.context.getResources().getIdentifier(name, "drawable", this.context.getPackageName());
        holder.icon.setImageResource(imageId);
        holder.icon.setBackgroundResource(R.color.light_blue);

    }

    @Override
    public int getItemCount() {
        return this.squad.getSquadSize();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView icon;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            name = itemView.findViewById(R.id.player_name);
            icon = itemView.findViewById(R.id.player_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // call the interface method
                    if (recyclerViewInterface != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onClickItem(position);
                        }
                    }
                }
            });

        }
    }
}
