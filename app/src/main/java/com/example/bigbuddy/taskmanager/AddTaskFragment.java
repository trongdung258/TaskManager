package com.example.bigbuddy.taskmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
public class AddTaskFragment extends DialogFragment implements View.OnClickListener{
    private Button btnOk;
    private Button btnCancel;
    private SeekBar sbTimeForWork;
    private SeekBar sbTimeForBreak;
    private EditText edtNameOfTask;
    private CallBackToUpdateListView callBacker;
    public static AddTaskFragment addTaskFragment;
    private TaskStore taskStore ;

    public static AddTaskFragment create(CallBackToUpdateListView callBacker){
        addTaskFragment = new AddTaskFragment();
        addTaskFragment.callBacker = callBacker;
        return addTaskFragment;
    }
    public AddTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view ;
        view = inflater.inflate(R.layout.fragment_add_task, container, false);
        init(view);
        return view;
    }
    private void init(View view){
        taskStore = new TaskStore(getContext(),TaskStore.NAMEDATABASE,null,TaskStore.VERSION);
        btnOk = (Button)view.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
        btnCancel = (Button)view.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);
        sbTimeForWork = (SeekBar)view.findViewById(R.id.sb_time_for_work);
        sbTimeForWork.setMax(600);
        sbTimeForBreak = (SeekBar)view.findViewById(R.id.sb_time_for_break);
        sbTimeForBreak.setMax(600);
        edtNameOfTask = (EditText)view.findViewById(R.id.edt_name_of_task);
    }

    private void onClickOk(){
        Task task = new Task(edtNameOfTask.getText().toString()
                                ,sbTimeForWork.getProgress()
                                ,sbTimeForBreak.getProgress()
                                ,0);
        taskStore.addTask(task);
        callBacker.callBack();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ok:
                onClickOk();
                dismiss();
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
            default:
                break;
        }
    }
}
