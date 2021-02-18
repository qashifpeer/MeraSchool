package com.kashifpeer.meraschool;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SheetListActivity extends AppCompatActivity {
    private ListView sheetList;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listItems = new ArrayList<String>();
    private long cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_list);

        cid = getIntent().getLongExtra("cid",-1);
        Log.i("1234567890", "onCreate: "+cid);
        loadListItems();
        sheetList = findViewById(R.id.sheetList);
        adapter = new ArrayAdapter<>(this,R.layout.sheet_list,R.id.date_list_item,listItems);
        sheetList.setAdapter(adapter);

    }

    private void loadListItems() {
        Cursor cursor = new com.kashifpeer.meraschool.DbHelper(this).getDistinctMonths(cid);

        Log.i("1234567890", "loadListItems: "+cursor.getCount());
        while (cursor.moveToNext()){
            String date = cursor.getString(cursor.getColumnIndex(com.kashifpeer.meraschool.DbHelper.DATE_KEY));//01.04.2020
            listItems.add(date.substring(3));
        }
    }
}