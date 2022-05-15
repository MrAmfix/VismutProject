package com.calcapp.activitypackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.math.BigInteger;
import controlPackage.ControlTransfer;
import executeClass.fromDecimalNumber;

public class TransferActivity extends AppCompatActivity {
    TextView Result;
    EditText Number, NumSysFrom, NumSysTo;
    Button Press, Info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        Result = findViewById(R.id.textontop);
        Number = findViewById(R.id.number);
        NumSysFrom = findViewById(R.id.numsysfrom);
        NumSysTo = findViewById(R.id.numsysto);
        Press = findViewById(R.id.buttongo);
        Info = findViewById(R.id.button_info_special_t);

        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransferActivity.this, InstructionActivity.class);
                startActivity(intent);
            }
        });

        Press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numFrom = NumSysFrom.getText().toString();
                String numTo = NumSysTo.getText().toString();
                String num = Number.getText().toString();
                if(numFrom.isEmpty() || numTo.isEmpty() || num.isEmpty()){
                    Toast.makeText(TransferActivity.this, "Вы не ввели все данные.", Toast.LENGTH_SHORT).show();
                    Result.setText("");
                }
                else{
                    fromDecimalNumber in = ControlTransfer.doTransfer(numFrom, numTo, num);
                    if(in == null){
                        Toast.makeText(TransferActivity.this, "Данные введены неправильно.", Toast.LENGTH_SHORT).show();
                        Result.setText("");
                    }
                    else{
                        String result = "";
                        if(!in.getSign()){
                            result += "- ";
                        }
                        if(in.getOriginalNumerator().equals(BigInteger.ZERO)){
                            result += "0";
                        }
                        else{
                            result += in.getInteger();
                        }
                        if(!(in.getOriginalDenominator().equals(BigInteger.ONE))){
                            result += (" " + in.getFloat() + " / " + in.getDenominator());
                        }
                        Result.setText(result);
                    }
                }
            }
        });
    }
}