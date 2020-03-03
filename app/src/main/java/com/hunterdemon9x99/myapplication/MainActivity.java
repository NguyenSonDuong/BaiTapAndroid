package com.hunterdemon9x99.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnUpdate, btnDelete;
    ListView lvItem;
    EditText edtNhap;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter ;
    public static int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        edtNhap = (EditText) findViewById(R.id.edtNhap);
        lvItem = (ListView) findViewById(R.id.lvItem);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,list);
        lvItem.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNhap.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Nhập dữ liệu đi", Toast.LENGTH_SHORT).show();
                    return;
                }
                list.add(edtNhap.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNhap.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Nhập dữ liệu đi", Toast.LENGTH_SHORT).show();
                    return;
                }
                list.set(MainActivity.position,edtNhap.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
            }
        });
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtNhap.setText(list.get(position));
                MainActivity.position = position;
            }
        });

        lvItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Temb.class);
                intent.putExtra("KEY",list.get(position));
                startActivity(intent);
                return false;
            }
        });
    }
}
