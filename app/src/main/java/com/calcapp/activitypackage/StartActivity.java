package com.calcapp.activitypackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import controlPackage.DevDialog;

public class StartActivity extends AppCompatActivity {
    Button transfer, math, developer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        transfer = findViewById(R.id.button_transfer);
        math = findViewById(R.id.button_math);
        developer = findViewById(R.id.button_info_developer);

        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, TransferActivity.class);
                startActivity(intent);
            }
        });
        math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MathActivity.class);
                startActivity(intent);
            }
        });
        developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
            }
        });
    }
    protected void createDialog(){
        FragmentManager manager = getSupportFragmentManager();
        DevDialog dialogDev = new DevDialog();
        dialogDev.show(manager, "DialogDev");
    }
}