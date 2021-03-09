package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for search
        EditText theFilter = (EditText)findViewById(R.id.searchFilter);

        listView = (ListView)findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        /*
        ArrayList arrayList = new ArrayList();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        arrayList.add("four");

*/
        String s[] = new String[]{"one","WebView","Next","two","three"};
        arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,s);
        listView.setAdapter(arrayAdapter);

        //search items
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).arrayAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

//This code is used for onclick listener in listView
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        String value = (String) listView.getItemAtPosition(position);


        if(value.equals("WebView"))
        {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/java-tutorial"));
            startActivity(intent);
        }
        else if (value.equals("Next"))
        {
            Intent intent = new Intent(this,next.class);
            startActivity(intent);
        }
        else
            {
            Toast.makeText(this, "clciked"+position, Toast.LENGTH_SHORT).show();
        }




    }
}

/*** this code is use in activity main.xml in listView then it can fetch data from string.xml
 android:entries="@array/list"
 */