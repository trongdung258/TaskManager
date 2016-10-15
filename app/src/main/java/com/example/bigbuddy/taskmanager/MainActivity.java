package com.example.bigbuddy.taskmanager;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FloatingActionButton fbAddTask;
    BlankFragment blankFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        blankFragment = new BlankFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.task_list_fragment,blankFragment,"aA")
                .commit();
        fbAddTask = (FloatingActionButton)findViewById(R.id.fb_add_task);
        fbAddTask.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.fb_add_task){
            AddTaskFragment addTaskFragment = AddTaskFragment.create(blankFragment);
            getSupportFragmentManager().beginTransaction().add(addTaskFragment,"add").commit();
        }
    }
}
