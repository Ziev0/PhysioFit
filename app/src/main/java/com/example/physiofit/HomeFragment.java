package com.example.physiofit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set up the toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        }

        // Initialize the RecyclerView
        RecyclerView recyclerViewHorizontal = view.findViewById(R.id.recyclerViewPopularExercises);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        List<Workout> newWorkoutCards = new ArrayList<>();
        newWorkoutCards.add(new Workout(R.drawable.image1, "Wing and Chest Training", "Intermediate", "07 Min", 50, "Details"));

        NewWorkoutAdapter newAdapter = new NewWorkoutAdapter(newWorkoutCards, getActivity());
        recyclerViewHorizontal.setAdapter(newAdapter);

        RecyclerView recyclerViewVertical = view.findViewById(R.id.recommendationRecyclerView);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Workout> workoutList = new ArrayList<>();
        // Add your workout data here
        workoutList.add(new Workout(R.drawable.image2, "Get Back On Your Feet", "Intermediate", "20 times up a day", 45, "Workout details here"));

        WorkoutCardAdapter cardsAdapter = new WorkoutCardAdapter(workoutList, getActivity());
        recyclerViewVertical.setAdapter(cardsAdapter);
    }
}
