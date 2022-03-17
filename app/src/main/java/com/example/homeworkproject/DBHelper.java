package com.example.homeworkproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_version =1 ;
    private static final String DB_NAME = "KooSang.DB";

    public DBHelper(@Nullable Context context) {
        super(context,DB_NAME,null,DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 데이터 베이스가 생성될 때 호출

        // 데이터 베이스 - 테이블 - 컬럼 -값
        db.execSQL("CREATE TABLE IF NOT EXISTS TodoList (id INTEGER PRIMARY KEY AUTOINCREMENT, checking BOOLEAN, title TEXT NOT NULL, content TEXT NOT NULL, writeDate TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    // SELECT 문
    public ArrayList<TodoItem> getTodoList(){
        ArrayList<TodoItem> todoItems = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TodoList ORDER BY writeDate DESC", null);
        if(cursor.getCount() !=0){
            while (cursor.moveToNext()){
                @SuppressLint("Range") int id=cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") boolean checking = cursor.getInt(cursor.getColumnIndex("checking"))>0;
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));
                @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("content"));
                @SuppressLint("Range") String writeDate = cursor.getString(cursor.getColumnIndex("writeDate"));

                TodoItem todoItem = new TodoItem();
                todoItem.setId(id);
                todoItem.setChecking(checking);
                todoItem.setTitle(title);
                todoItem.setContent(content);
                todoItem.setWriteDate(writeDate);
                todoItems.add(todoItem);
            }
        }
        cursor.close();
        return todoItems;
    }

    // INSERT 문 (할일목록을 DB에 넣는다)
    public void InsertTodo(String _title, String _content, String _writeDate) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO TodoList (checking, title ,content, writeDate) VALUES( false , '"+_title +"','"+_content+ "','"+_writeDate+ "');");
    }

    // UPDATE 문
    public void UpdateTodo(boolean _checking, String _title, String _content, String _writeDate, int _id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE TodoList SET checking="+_checking +", title='"+_title+"', content= '"+_content+"',writeDate='"+_writeDate+"' Where id='" +_id+"'");
    }

    // DELETE 문
    public void deleteTodo(int _id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM TodoList WHERE id = '"+_id+"'");
    }


}
