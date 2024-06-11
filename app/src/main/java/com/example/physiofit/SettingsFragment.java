package com.example.physiofit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// SettingsFragment.java
public class SettingsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        List<SettingItem> settingsList = new ArrayList<>();
        settingsList.add(new SettingItem(R.drawable.ic_profile, "Account", "Privacy, security, change number"));
        settingsList.add(new SettingItem(R.drawable.ic_chat, "Chat", "Chat history, theme, wallpapers"));
        settingsList.add(new SettingItem(R.drawable.ic_notifications, "Notifications", "Messages, group and others"));
        settingsList.add(new SettingItem(R.drawable.ic_help, "Help", "Help center, contact us, privacy policy"));
        settingsList.add(new SettingItem(R.drawable.ic_storage, "Storage and data", "Network usage, storage usage"));
        settingsList.add(new SettingItem(R.drawable.ic_invite, "Invite a friend", ""));

        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SettingsAdapter(settingsList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
