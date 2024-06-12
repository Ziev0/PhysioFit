package com.example.physiofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhysiotherapistAdapter extends RecyclerView.Adapter<PhysiotherapistAdapter.ViewHolder> {
    private List<Physiotherapist> physiotherapistList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView profilePicture;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.physiotherapist_name);
            profilePicture = view.findViewById(R.id.physiotherapist_image);
        }
    }

    public PhysiotherapistAdapter(List<Physiotherapist> itemList) {
        this.physiotherapistList = itemList;
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
    }

    @Override
    public int getItemCount() {
        return physiotherapistList.size();
    }
}
