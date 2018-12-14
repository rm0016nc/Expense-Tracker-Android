package com.example.rm0016nc.a365project2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Preferences extends Fragment {

    databaseHelper myDB;

    View view;
    Button backround;
    Button normal;
    Button resetBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_preferences, container, false);
        backround = (Button) rootview.findViewById(R.id.background);
        resetBtn = (Button) rootview.findViewById(R.id.resetBtn);
        normal = (Button) rootview.findViewById(R.id.normal);

        myDB = new databaseHelper(getContext());

        backround.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view = getActivity().getWindow().getDecorView();
                view.setBackgroundResource(R.color.soothing);
            }
        });

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view = getActivity().getWindow().getDecorView();
                view.setBackgroundResource(R.color.white);
            }
        });

        DeleteData();
        return rootview;

    }

        public void DeleteData() {
            resetBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer deletedRows = myDB.resetData();
                    if (deletedRows > 0){
                        Toast.makeText(getContext(), "Reset successful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Reset Unsuccessful", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
}
