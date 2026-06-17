package com.sandip.taskmate;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item_task, parent, false);
        }

        TextView titleText = convertView.findViewById(R.id.itemTitle);
        TextView descText = convertView.findViewById(R.id.itemDescription);
        TextView priorityBadge = convertView.findViewById(R.id.priorityBadge);
        TextView statusText = convertView.findViewById(R.id.statusText);

        titleText.setText(task.getTitle());
        descText.setText(task.getDescription().isEmpty() ? "No description" : task.getDescription());

        if (task.isHighPriority()) {
            priorityBadge.setVisibility(View.VISIBLE);
        } else {
            priorityBadge.setVisibility(View.GONE);
        }

        if (task.isCompleted()) {
            statusText.setText("Done");
            statusText.setTextColor(Color.parseColor("#4CAF50"));
            convertView.setAlpha(0.6f);
        } else {
            statusText.setText("Pending");
            statusText.setTextColor(Color.parseColor("#FF9800"));
            convertView.setAlpha(1.0f);
        }

        return convertView;
    }
}
