package br.edu.qi.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static br.edu.qi.app.GetNumber.phoneBeanLists;

public class NextActivity extends AppCompatActivity {


    private TextView tv;
    private Button btnMapa;
    private DatabaseReference mDatabase;
    private ListView listView;
    private PhoneAdapter phoneAdapter;
    private ArrayList<PhoneBean> contactModelArrayList;
    private CustomAdapter customAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        btnMapa  = (Button) findViewById(R.id.btnMapa);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        TextView tv=(TextView)findViewById(R.id.tv);
        listView = (ListView) findViewById(R.id.listView);



        for (int i = 0; i < phoneBeanLists.size(); i++){



            if(phoneBeanLists.get(i).getSelected()) {

                String str=( phoneBeanLists.get(i).getPhoneNumber());

                PhoneBean contactModel = new PhoneBean();
                contactModel.setPhoneNumber(str);
                contactModelArrayList.add(contactModel);

                customAdapter = new CustomAdapter(this,contactModelArrayList);
                listView.setAdapter(customAdapter);






                tv.setText(str);



                mDatabase.child("location").child("PhoneNumber").setValue(str);
            }
        }





        btnMapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(NextActivity.this, MapsActivity.class);
                startActivity(it);
            }
        });


        }
    }

