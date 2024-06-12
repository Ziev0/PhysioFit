package com.example.physiofit;
import com.bumptech.glide.Glide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WorkoutCardAdapter extends RecyclerView.Adapter<WorkoutCardViewHolder> {
    private List<Workout> workoutList;
    private FragmentActivity activity;

    public WorkoutCardAdapter(List<Workout> workoutList, FragmentActivity activity) {
        this.workoutList = workoutList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public WorkoutCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_card, parent, false);
        return new WorkoutCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutCardViewHolder holder, int position) {
        Workout workout = workoutList.get(position);
        holder.workoutName.setText(workout.getName());
        holder.workoutLevel.setText(workout.getLevel());
        holder.workoutDescription.setText(workout.getDescription());
        holder.workoutProgress.setProgress(workout.getProgress());

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
}
