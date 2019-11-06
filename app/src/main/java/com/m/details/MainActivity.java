package com.m.details;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.m.details.adapter.UserDetailAdapter;
import com.m.details.model.UserDetail;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName,etAge;
    RadioButton rbMale, rbFemale, rbOthers;
    Spinner spinner;
    Button btnSave;
    RadioGroup rg;
    RecyclerView recyclerView;
    String gen;
    int img;
    List<UserDetail> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        etAge=findViewById(R.id.etAge);
        rbMale=findViewById(R.id.rbMale);
        rbFemale=findViewById(R.id.rbFemale);
        rbOthers=findViewById(R.id.rbOthers);
        btnSave=findViewById(R.id.btnSave);
        spinner=findViewById(R.id.spinner);
        rg=findViewById(R.id.rg);


        btnSave.setOnClickListener(this);



        String images []={"Select Image","messi","taylor"};
        ArrayAdapter adapter= new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,images

        );
        spinner.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        if(TextUtils.equals(etName.getText().toString(),"")){
            return;
        }
        if(TextUtils.equals(etAge.getText().toString(),"")){
            return;
        }

        recyclerView = findViewById(R.id.recyclerView);

        if(rbMale.isChecked()){
            gen="Male";
        }
        if(rbFemale.isChecked()){
            gen="Female";
        }
        if(rbOthers.isChecked()){
            gen="Others";
        }
        String image=spinner.getSelectedItem().toString();
        if(image=="messi"){
            img=  R.drawable.messi ;
        }

        if(image=="taylor"){
            img=  R.drawable.taylor ;
        }


        int age=Integer.parseInt(etAge.getText().toString());

        userList.add(new UserDetail(etName.getText().toString(), age, gen, img));
        UserDetailAdapter userDetailAdapter = new UserDetailAdapter(this, userList);
        recyclerView.setAdapter(userDetailAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));






        etName.setText("");
        etAge.setText("");
        rbFemale.clearFocus();
        rbOthers.clearFocus();
        rbMale.clearFocus();
        spinner.clearFocus();

    }
}
