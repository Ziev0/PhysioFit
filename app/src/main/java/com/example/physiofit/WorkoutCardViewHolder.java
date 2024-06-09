package com.example.physiofit;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class WorkoutCardViewHolder extends RecyclerView.ViewHolder {
    public ImageView workoutImage;
    public TextView workoutName;
    public TextView workoutLevel;
    public TextView workoutDescription;
    public ProgressBar workoutProgress;

    public WorkoutCardViewHolder(View itemView) {
        super(itemView);
        workoutImage = itemView.findViewById(R.id.workout_image);
        workoutName = itemView.findViewById(R.id.workout_name);
        workoutLevel = itemView.findViewById(R.id.workout_level);
        workoutDescription = itemView.findViewById(R.id.workout_description);
        workoutProgress = itemView.findViewById(R.id.workout_progress);
    }
}
