package com.example.basicsandroid.activity.test;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.basicsandroid.R;
import com.example.basicsandroid.activity.sqlite.SqliteNew;

public class Test3Activity extends AppCompatActivity {
    private SqliteNew sqliteNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

        initView();
    }

    private void initView() {

        //数据库名  游标  版本
        sqliteNew = new SqliteNew(this, "BOOK.db", null, 2);
        SQLiteDatabase sqLiteDatabase = sqliteNew.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        //开始组装第一条数据
        contentValues.put("name", "mawei");
        contentValues.put("autor", "liJuan");
        //第二个参数  缺省的字段的名字,如果没有值 就在数据库中存储为null缺省的字段的名字,如果没有值 就在数据库中存储为null
        sqLiteDatabase.insert("Book", null, contentValues);


        //
        sqLiteDatabase.update("Book", contentValues, "name = ?", new String[]{"an  jia"});


        sqLiteDatabase.delete("Book", "name = ?", new String[]{"an  jia"});
    }
}
