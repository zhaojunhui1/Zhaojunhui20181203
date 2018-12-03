package com.bwie.zhaojunhui1203;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Dao {
    private static Dao instance;
    private SQLiteDatabase database;
    private Dao(Context context){
        database = new MyHelper(context).getWritableDatabase();
    }
    public static Dao getInstance(Context context){
        if (instance == null){
            instance = new Dao(context);
        }
        return instance;
    }

    //添加
    public void add(String name){
        ContentValues values = new ContentValues();
        values.put("name", name);
        database.insert("user", null, values);
    }

    //清空最近
    public void delAll(){
        database.delete("user", null, null);
    }



}
