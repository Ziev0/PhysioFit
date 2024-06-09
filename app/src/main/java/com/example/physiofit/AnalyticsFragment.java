package com.example.physiofit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsFragment extends Fragment {
    private RecyclerView recyclerView;
    private WorkoutCardAdapter adapter;
    private List<Workout> workoutList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_analytics, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Toolbar toolbar = view.findViewById(R.id.analytics_toolbar);
        TextView toolbarTitle = toolbar.findViewById(R.id.title_bar);

        // Set the title
        toolbarTitle.setText("Analytics");

        workoutList = new ArrayList<>();
        // Add your workout data here
        workoutList.add(new Workout(R.drawable.image2, "Get Back On Your Feet", "Intermediate", "20 times up a day", 45, "Workout details here"));

        adapter = new WorkoutCardAdapter(workoutList, getActivity());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
