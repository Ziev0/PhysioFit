package com.example.physiofit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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

        // First RecyclerView
        RecyclerView recyclerViewHorizontal = view.findViewById(R.id.recyclerViewPopularExercises);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        List<Workout> newWorkoutCards = new ArrayList<>();
        newWorkoutCards.add(new Workout(R.drawable.image1, "Wing and Chest Training", "Intermediate", "07 Min", 50, "Details"));

        NewWorkoutAdapter newAdapter = new NewWorkoutAdapter(newWorkoutCards, getActivity());
        recyclerViewHorizontal.setAdapter(newAdapter);

        //Second RecyclerView
        RecyclerView recyclerViewVertical = view.findViewById(R.id.recommendationRecyclerView);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Workout> workoutList = new ArrayList<>();
        workoutList.add(new Workout(R.drawable.image2, "Get Back On Your Feet", "Intermediate", "20 times up a day", 45, "Workout details here"));

        WorkoutCardAdapter cardsAdapter = new WorkoutCardAdapter(workoutList, getActivity());
        recyclerViewVertical.setAdapter(cardsAdapter);

        //Third RecyclerView
        RecyclerView physiotherapistRV = view.findViewById(R.id.physiotherapist_recycler_view);
        int numberOfColumns = 2; // Number of columns in each row
        physiotherapistRV.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));

        List<Physiotherapist> physiotherapistList = new ArrayList<>();
        // Populate your physiotherapistList here
        physiotherapistList.add(new Physiotherapist(R.drawable.image4, "Dr. John Doe","Orthopedics", 4.5f));
        physiotherapistList.add(new Physiotherapist(R.drawable.image5, "Dr. Jane Smith","Geriatric", 4.0f));
        // Add more items as needed


        PhysiotherapistAdapter adapter = new PhysiotherapistAdapter(requireContext(), physiotherapistList);
        physiotherapistRV.setAdapter(adapter);
    }
}
