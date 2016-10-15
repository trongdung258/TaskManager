package com.example.bigbuddy.taskmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Vector;

/**
 * Created by trong on 10/15/2016.
 */

public class TaskStore extends SQLiteOpenHelper {
    public static final String NAMEDATABASE = "tasksmanager";
    public static final int VERSION = 1;


    public TaskStore(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreatable = "CREATE TABLE 'task'('id' "
                + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + "'name' TEXT,"
                + " 'timework' INTEGER,"
                + " 'timebreak' INTEGER,"
                + " 'times' INTEGER)";
        db.execSQL(queryCreatable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", task.getName());
        contentValues.put("timework", task.getTimeWork());
        contentValues.put("timebreak",task.getTimeBreak());
        contentValues.put("times",task.getTimes());
        db.insert("task", null, contentValues);
    }
    public Vector<Task> getAllTask(){
        Vector<Task> allTask = new Vector<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT name,timework,timebreak,times FROM task";
        Cursor cursor = db.rawQuery(sql,new String[0]);
        while (cursor.moveToNext()){
            String name = cursor.getString(0);
            int timework = cursor.getInt(1);
            int timebreak = cursor.getInt(2);
            int times = cursor.getInt(3);
            Task task = new Task(name,timework,timebreak,times);
            allTask.add(task);
        }
        cursor.close();
        return  allTask;
    }
    public void deleteTask(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("task","name ="+name,null);
    }
    public void editTask(Task task,String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", task.getName());
        contentValues.put("timework", task.getTimeWork());
        contentValues.put("timebreak",task.getTimeBreak());
        contentValues.put("times",task.getTimes());
        db.update("task",contentValues,"name = "+name,null);
    }
}
