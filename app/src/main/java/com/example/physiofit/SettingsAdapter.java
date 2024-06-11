package com.example.physiofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {
    private List<SettingItem> settingsList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView title;
        public TextView subtitle;

        public ViewHolder(View view) {
            super(view);
            icon = view.findViewById(R.id.item_icon);
            title = view.findViewById(R.id.item_name);
            subtitle = view.findViewById(R.id.item_subtext);
        }
    }

    public SettingsAdapter(List<SettingItem> settingsList) {
        this.settingsList = settingsList;
    }

    @Override
    public SettingsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_setting, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SettingItem item = settingsList.get(position);
        holder.icon.setImageResource(item.getIcon());
        holder.title.setText(item.getTitle());
        holder.subtitle.setText(item.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return settingsList.size();
    }
}