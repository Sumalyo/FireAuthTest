package com.datta.fireauthtest;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class FiringactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_landing);
        String data = getIntent().getStringExtra("Username");
        String data_1=getIntent().getStringExtra("Id");
        TextView show_email = (TextView)findViewById(R.id.email_show);
        TextView show_pass = (TextView)findViewById(R.id.id_show);
        if(data_1 !=null && data != null )
        {show_email.setText(data);
        show_pass.setText(data_1);}
        else
        {
            show_email.setText("Welcome");
            show_pass.setText("Hacker");
        }
        MaterialButton map_butt = findViewById(R.id.map_button);
        map_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent I = new Intent(FiringactActivity.this,map_act.class);
                startActivity(I);
            }
        });
    }


}
