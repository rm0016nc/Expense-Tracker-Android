package com.example.rm0016nc.a365project2;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class App extends Fragment {
    EditText housetxt;
    EditText foodtxt;
    EditText mistxt;
    Button addbtn;
    Button trackBtn;
    EditText remain;
    EditText expense;
    TextView budget;
    EditText change;
    Button deleteBtn;
    Button updateBtn;
    databaseHelper myDb;
    String id;
    Double totalExp = 0.0;
    Double houseexp;
    Double foodexp;
    Double misexp;
    Double remaining;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_app, container, false);

        myDb = new databaseHelper(getContext());
        housetxt = (EditText) rootView.findViewById(R.id.housetxt);
        foodtxt = (EditText) rootView.findViewById(R.id.foodtxt);
        mistxt = (EditText)rootView.findViewById(R.id.mistxt);
        budget = (TextView) rootView.findViewById(R.id.budget);
        change = (EditText) rootView.findViewById(R.id.change);
        addbtn = (Button) rootView.findViewById(R.id.addbtn);
        trackBtn = (Button) rootView.findViewById(R.id.trackBtn);
        deleteBtn = (Button) rootView.findViewById(R.id.deleteBtn);
        updateBtn = (Button) rootView.findViewById(R.id.updateBtn);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bud = foodtxt.getText().toString();
                String food = housetxt.getText().toString();
                String misc = mistxt.getText().toString();
                if (housetxt.length() != 0) {
                    AddData(bud, food, misc);
                    housetxt.setText("");
                    mistxt.setText("");
                } else {
                    Toast.makeText(getContext(),"You must put something in the field", Toast.LENGTH_LONG).show();
                }
            }
        });
//        AddData();
        viewAll();
        DeleteData();
        updateData();

        return rootView;
    }

    public void AddData (final String budgetM, final String foodM, final String misM) {
        boolean isInserted = myDb.insertData(budgetM, foodM, misM);
        if (isInserted = true)
            Toast.makeText(getContext(), "Data inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getContext(), "Data not inserted", Toast.LENGTH_LONG).show();
    }

        public void viewAll() {
            trackBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), DisplayExpense.class);
                    startActivity(intent);


//                    Cursor res = myDb.getAllData();
//                    if (res.getCount() == 0) {
//                        // Show message
//                        showMessage("Error"," Nothing found");
//                        return;
//                    }
//
//                    while (res.moveToNext()) {
//                        id = res.getString(0);
//                        foodexp = res.getDouble(1);
//                        houseexp = res.getDouble(2);
//                        misexp = res.getDouble(3);
//
//                        budget.setText("Your set budget is $"+foodexp);
//                    }
//
//                    totalExp += (houseexp+misexp);
//                    remaining = foodexp-totalExp;
//
//                    // Show all data
//
//                    expense.append("("+"(F) $"+houseexp.toString()+"+"+"(M) $"+misexp.toString()+")" +"+");
//                    remain.setText("$"+remaining.toString());
                }
            });
        }

    public  void showMessage(String title, String Messsage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Messsage);
        builder.show();
    }

    public void updateData() {
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDb.updateData(change.getText().toString(),foodtxt.getText().toString(), housetxt.getText().toString(), mistxt.getText().toString());
                if (isUpdate == true) {
                    change.setText("");
                    Toast.makeText(getContext(), "Data is updated", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getContext(), "Data is not updated", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void DeleteData() {
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(change.getText().toString());
                if (deletedRows > 0){
                    Toast.makeText(getContext(), "Data deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Data not deleted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
