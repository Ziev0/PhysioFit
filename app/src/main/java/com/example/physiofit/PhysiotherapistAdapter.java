package com.example.physiofit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhysiotherapistAdapter extends RecyclerView.Adapter<PhysiotherapistAdapter.ViewHolder> {
    private List<Physiotherapist> physiotherapistList;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView profilePicture;
        public RatingBar rating;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.physiotherapist_name);
            profilePicture = view.findViewById(R.id.physiotherapist_image);
        }
    }

    public PhysiotherapistAdapter(Context context, List<Physiotherapist> physiotherapistList) {
        this.context = context;
        this.physiotherapistList = physiotherapistList;
    }

    @Override
    public PhysiotherapistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.physiotherapist_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Physiotherapist physiotherapist = physiotherapistList.get(position);
        holder.name.setText(physiotherapist.getName());
        holder.profilePicture.setImageResource(physiotherapist.getProfilePicture());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PhysiotherapistActivity.class);
            intent.putExtra("physiotherapist", physiotherapist);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return physiotherapistList.size();
    }
}
