package com.sandip.taskmate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText descriptionInput;
    private Switch prioritySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        titleInput = findViewById(R.id.titleInput);
        descriptionInput = findViewById(R.id.descriptionInput);
        prioritySwitch = findViewById(R.id.prioritySwitch);
        Button saveButton = findViewById(R.id.saveButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInput.getText().toString().trim();
                String description = descriptionInput.getText().toString().trim();
                boolean isHighPriority = prioritySwitch.isChecked();

                if (title.isEmpty()) {
                    titleInput.setError("Task title is required");
                    titleInput.requestFocus();
                    return;
                }

                Task newTask = new Task(title, description, isHighPriority);
                MainActivity.tasks.add(newTask);
                Toast.makeText(AddTaskActivity.this, "Task added successfully!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
