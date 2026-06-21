package com.sandip.taskmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Task> tasks = new ArrayList<>();

    private ListView taskListView;
    private TextView emptyText;
    private TextView taskCountText;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskListView = findViewById(R.id.taskListView);
        emptyText = findViewById(R.id.emptyText);
        taskCountText = findViewById(R.id.taskCountText);
        Button addButton = findViewById(R.id.addButton);

        taskAdapter = new TaskAdapter(this, tasks);
        taskListView.setAdapter(taskAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });

        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, TaskDetailActivity.class);
                intent.putExtra("task_position", position);
                startActivity(intent);
            }
        });

        refreshView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        taskAdapter.notifyDataSetChanged();
        refreshView();
    }

    private void refreshView() {
        if (tasks.isEmpty()) {
            emptyText.setVisibility(View.VISIBLE);
            taskListView.setVisibility(View.GONE);
            taskCountText.setText("");
        } else {
            emptyText.setVisibility(View.GONE);
            taskListView.setVisibility(View.VISIBLE);
            taskCountText.setText(tasks.size() + " tasks");
        }
    }
}
