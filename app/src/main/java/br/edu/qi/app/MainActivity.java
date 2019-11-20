package br.edu.qi.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static br.edu.qi.app.GetNumber.phoneBeanLists;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    private PhoneAdapter phoneAdapter;
    private Button btnnext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetNumber.getNumber( this );

        lv = (ListView) findViewById( R.id.lv );


        btnnext = (Button) findViewById( R.id.next );


        phoneAdapter = new PhoneAdapter( GetNumber.phoneBeanLists, this );
        lv.setAdapter( phoneAdapter );



        btnnext.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, NextActivity.class );
                startActivity( intent );

            }
        } );


    }
    private ArrayList<PhoneBean> getModel(boolean isSelect){
        ArrayList<PhoneBean> list = new ArrayList<>();
        for(int i = 0; i < 4; i++){

            PhoneBean model = new PhoneBean();
            model.setSelected(isSelect);
            model.setPhoneNumber( String.valueOf( phoneBeanLists.get( i ) ) );
            list.add(model);
        }
        return list;
    }
}