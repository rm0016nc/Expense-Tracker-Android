package com.example.rm0016nc.a365project2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DisplayExpense extends AppCompatActivity {

    databaseHelper myDB;
    Double expense1;
    Double expense2;
    Double budget;
    Double totalexp = 0.0;
    Double remainingbud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_expense);

        ListView listView = (ListView) findViewById(R.id.display_listview);
        myDB = new databaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getAllData();

        if(data.getCount() == 0){
            Toast.makeText(this,"The database was empty",Toast.LENGTH_LONG).show();
        } else{

            while (data.moveToNext()){
                theList.add("This is entry : ~~~~"+data.getString(0)+"~~~~");
                budget = Double.valueOf(data.getString(1));
                expense1 = Double.valueOf(data.getString(2));
                expense2 = Double.valueOf(data.getString(3));
                totalexp += expense1+expense2;
                remainingbud = budget-totalexp;
//                theList.add("Budget: "+data.getString(1));
                theList.add("Food: $"+data.getString(2));
                theList.add("Miscellaneous: $"+data.getString(3));

                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
            theList.add("Total expense for this month is: $"+totalexp.toString());
            theList.add("Remaining budget is: $"+remainingbud.toString());
        }
    }
}
