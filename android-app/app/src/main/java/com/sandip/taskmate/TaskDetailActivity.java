package com.sandip.taskmate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    private int taskPosition;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        taskPosition = getIntent().getIntExtra("task_position", -1);

        if (taskPosition < 0 || taskPosition >= MainActivity.tasks.size()) {
            finish();
            return;
        }

        task = MainActivity.tasks.get(taskPosition);

        TextView titleView = findViewById(R.id.detailTitle);
        TextView descView = findViewById(R.id.detailDescription);
        TextView priorityView = findViewById(R.id.detailPriority);
        Switch completedSwitch = findViewById(R.id.completedSwitch);
        Button deleteButton = findViewById(R.id.deleteButton);
        Button backButton = findViewById(R.id.backButton);

        titleView.setText(task.getTitle());

        String desc = task.getDescription();
        descView.setText(desc.isEmpty() ? "No description provided." : desc);

        if (task.isHighPriority()) {
            priorityView.setText("High Priority");
            priorityView.setTextColor(getResources().getColor(R.color.priority_high, null));
        } else {
            priorityView.setText("Normal Priority");
            priorityView.setTextColor(getResources().getColor(R.color.priority_normal, null));
        }

        completedSwitch.setChecked(task.isCompleted());

        completedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                task.setCompleted(isChecked);
                String msg = isChecked ? "Marked as completed" : "Marked as pending";
                Toast.makeText(TaskDetailActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.tasks.remove(taskPosition);
                Toast.makeText(TaskDetailActivity.this, "Task deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
