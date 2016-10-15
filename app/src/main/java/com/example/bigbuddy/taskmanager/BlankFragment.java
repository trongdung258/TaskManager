package com.example.bigbuddy.taskmanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Vector;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements CallBackToUpdateListView {

    private TaskStore taskStore ;
    private ListView listView;
    private Vector<Task> listTask;
    ListViewTasksAdapter listViewTasksAdapter;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        init(view);
        return view;
    }
    private void init(View view){
        taskStore = new TaskStore(getContext(),TaskStore.NAMEDATABASE,null,TaskStore.VERSION);
        listView = (ListView)view.findViewById(R.id.list_task);
    }

    @Override
    public void onStart() {
        super.onStart();
        listTask = taskStore.getAllTask();
        listViewTasksAdapter = new ListViewTasksAdapter(getContext(),listTask);
        listView.setAdapter(listViewTasksAdapter);
    }

    @Override
    public void callBack() {
        listViewTasksAdapter.notifyDataSetChanged();
        Log.d("AAAAAAAAAAAAAAAA",""+listTask.size());
    }
}
