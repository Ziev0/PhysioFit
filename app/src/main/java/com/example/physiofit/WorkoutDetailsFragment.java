package com.example.physiofit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WorkoutDetailsFragment extends Fragment {
    private static final String ARG_WORKOUT = "workout";

    private Workout workout;

    public static WorkoutDetailsFragment newInstance(Workout workout) {
        WorkoutDetailsFragment fragment = new WorkoutDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_WORKOUT, workout);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            workout = getArguments().getParcelable(ARG_WORKOUT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workout_details, container, false);

        TextView workoutNameTextView = view.findViewById(R.id.workout_name);
        TextView workoutDetailsTextView = view.findViewById(R.id.workout_details);

        workoutNameTextView.setText(workout.getName());
        workoutDetailsTextView.setText(workout.getDetails());

        return view;
    }
}
