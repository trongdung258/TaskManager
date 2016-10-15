package com.example.bigbuddy.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by trong on 10/15/2016.
 */

public class ListViewTasksAdapter extends BaseAdapter {
    private Vector<Task> listTask;
    private Context mContext;

    public ListViewTasksAdapter(Context mContext, Vector<Task> tasks){
        this.listTask = tasks;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return this.listTask.size();
    }

    @Override
    public Task getItem(int position) {
        return this.listTask.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_task, null);
        }
        ((TextView)convertView.findViewById(R.id.tv_name_of_task)).setText(getItem(position).getName());
        ((TextView)convertView.findViewById(R.id.tv_time_for_work)).setText(" "+getItem(position).getTimeWork());
        ((TextView)convertView.findViewById(R.id.tv_time_for_break)).setText(" "+getItem(position).getTimeBreak());
        return convertView;
    }
}
