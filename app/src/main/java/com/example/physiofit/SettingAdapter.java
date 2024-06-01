package com.example.physiofit;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.ViewHolder> {

    private List<SettingItem> settingItemList;

    public SettingAdapter(List<SettingItem> settingItemList) {
        this.settingItemList = settingItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SettingItem settingItem = settingItemList.get(position);
        holder.itemName.setText(settingItem.getName());
        holder.itemIcon.setImageResource(settingItem.getIconResId());
    }

    @Override
    public int getItemCount() {
        return settingItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemName;
        public ImageView itemIcon;
        public ImageView itemSubtext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemIcon = itemView.findViewById(R.id.item_icon);
            //itemSubtext = itemView.findViewById(R.id.item_subtext);
        }
    }
}
