package com.example.physiofit;
import com.bumptech.glide.Glide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NewWorkoutAdapter extends RecyclerView.Adapter<NewWorkoutAdapter.WorkoutCardSimpleViewHolder> {
    private List<Workout> workoutList;
    private FragmentActivity activity;

    public NewWorkoutAdapter(List<Workout> workoutList, FragmentActivity activity) {
        this.workoutList = workoutList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public WorkoutCardSimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.square_workout_card, parent, false);
        return new WorkoutCardSimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutCardSimpleViewHolder holder, int position) {
        Workout workout = workoutList.get(position);
        holder.workoutTitle.setText(workout.getName());
        holder.workoutDuration.setText(workout.getDescription());

        // Load image using Glide
        Glide.with(holder.workoutImage.getContext())
                .load(workout.getImageResId())
                .placeholder(R.drawable.placeholder) // Placeholder image
                .error(R.drawable.error) // Error image
                .into(holder.workoutImage);

        holder.itemView.setOnClickListener(v -> {
            WorkoutDetailsFragment fragment = WorkoutDetailsFragment.newInstance(workout);
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    public static class WorkoutCardSimpleViewHolder extends RecyclerView.ViewHolder {
        ImageView workoutImage;
        TextView workoutTitle;
        TextView workoutDuration;

        public WorkoutCardSimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            workoutImage = itemView.findViewById(R.id.workout_image);
            workoutTitle = itemView.findViewById(R.id.workout_title);
            workoutDuration = itemView.findViewById(R.id.workout_duration);
        }
    }
}
