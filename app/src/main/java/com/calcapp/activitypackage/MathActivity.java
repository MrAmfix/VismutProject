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

import controlPackage.ControlMath;
import executeClass.fromDecimalNumber;

public class MathActivity extends AppCompatActivity {
    String numb1, numb2, fromSys, toSys;
    TextView result;
    EditText num1, num2, fromsys, tosys;
    Button add, subtract, multiply, divide, info;
    Button pow; //, sqrt, log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        result = findViewById(R.id.resultmath);
        num1 = findViewById(R.id.math_firstnum);
        num2 = findViewById(R.id.math_secondnum);
        fromsys = findViewById(R.id.math_fromsys);
        tosys = findViewById(R.id.math_tosys);
        add = findViewById(R.id.button_add);
        subtract = findViewById(R.id.button_subtract);
        multiply = findViewById(R.id.button_multiply);
        divide = findViewById(R.id.button_divide);
        pow = findViewById(R.id.button_pow);
//        sqrt = findViewById(R.id.button_sqrt);
//        log = findViewById(R.id.button_log);
        info = findViewById(R.id.button_info_special);

        info.setOnClickListener(new View.OnClickListener() {
            // ПЕРЕПИСАТЬ ИНСТРУКЦИЮ ПОДРОБНЕЕ В НОВОЙ АКТИВНОСТИ!
            @Override
            public void onClick(View v) {
//                String info = "Особенности работы:\n1) Возведение в степень - второе число должно быть целым,\n" +
//                        "Дано в 10-чной системе и меньше 50\n" +
//                        "2) Извлечение корня - Первое число должно быть целым, не превышающее 2^63 - 1\nВторое число не используется" +
//                        "3) Вычисление логарифма - Первое число должно быть целым\n" +
//                        "Второе должно быть целым, больше 1 и меньше 2^50";
//                Toast.makeText(MathActivity.this, info, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MathActivity.this, InstructionActivity.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numb1 = num1.getText().toString();
                numb2 = num2.getText().toString();
                fromSys = fromsys.getText().toString();
                toSys = tosys.getText().toString();
                if(numb1.isEmpty() || numb2.isEmpty() || fromSys.isEmpty() || toSys.isEmpty()){
                    Toast.makeText(MathActivity.this, "Вы не ввели все данные", Toast.LENGTH_SHORT).show();
                    result.setText("");
                }
                else{
                    fromDecimalNumber content = ControlMath.calculate(new ControlMath.DataPath(numb1, numb2, fromSys, toSys), "add");
                    if(content == null){
                        Toast.makeText(MathActivity.this, "Данные введены неправильно.", Toast.LENGTH_SHORT).show();
                        result.setText("");
                    }
                    else{
                        String Result = "";
                        if(!content.getSign()){
                            Result += "- ";
                        }
                        if(content.getOriginalNumerator().equals(BigInteger.ZERO)){
                            Result += "0";
                        }
                        else{
                            Result += content.getInteger();
                        }
                        if(!(content.getOriginalDenominator().equals(BigInteger.ONE))){
                            Result += (" " + content.getFloat() + " / " + content.getDenominator());
                        }
                        result.setText(Result);
                    }
                }
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numb1 = num1.getText().toString();
                numb2 = num2.getText().toString();
                fromSys = fromsys.getText().toString();
                toSys = tosys.getText().toString();
                if(numb1.isEmpty() || numb2.isEmpty() || fromSys.isEmpty() || toSys.isEmpty()){
                    Toast.makeText(MathActivity.this, "Вы не ввели все данные", Toast.LENGTH_SHORT).show();
                    result.setText("");
                }
                else{
                    fromDecimalNumber content = ControlMath.calculate(new ControlMath.DataPath(numb1, numb2, fromSys, toSys), "subtract");
                    if(content == null){
                        Toast.makeText(MathActivity.this, "Данные введены неправильно.", Toast.LENGTH_SHORT).show();
                        result.setText("");
                    }
                    else{
                        String Result = "";
                        if(!content.getSign()){
                            Result += "- ";
                        }
                        if(content.getOriginalNumerator().equals(BigInteger.ZERO)){
                            Result += "0";
                        }
                        else{
                            Result += content.getInteger();
                        }
                        if(!(content.getOriginalDenominator().equals(BigInteger.ONE))){
                            Result += (" " + content.getFloat() + " / " + content.getDenominator());
                        }
                        result.setText(Result);
                    }
                }
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numb1 = num1.getText().toString();
                numb2 = num2.getText().toString();
                fromSys = fromsys.getText().toString();
                toSys = tosys.getText().toString();
                if(numb1.isEmpty() || numb2.isEmpty() || fromSys.isEmpty() || toSys.isEmpty()){
                    Toast.makeText(MathActivity.this, "Вы не ввели все данные", Toast.LENGTH_SHORT).show();
                    result.setText("");
                }
                else{
                    fromDecimalNumber content = ControlMath.calculate(new ControlMath.DataPath(numb1, numb2, fromSys, toSys), "multiply");
                    if(content == null){
                        Toast.makeText(MathActivity.this, "Данные введены неправильно.", Toast.LENGTH_SHORT).show();
                        result.setText("");
                    }
                    else{
                        String Result = "";
                        if(!content.getSign()){
                            Result += "- ";
                        }
                        if(content.getOriginalNumerator().equals(BigInteger.ZERO)){
                            Result += "0";
                        }
                        else{
                            Result += content.getInteger();
                        }
                        if(!(content.getOriginalDenominator().equals(BigInteger.ONE))){
                            Result += (" " + content.getFloat() + " / " + content.getDenominator());
                        }
                        result.setText(Result);
                    }
                }
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numb1 = num1.getText().toString();
                numb2 = num2.getText().toString();
                fromSys = fromsys.getText().toString();
                toSys = tosys.getText().toString();
                if(numb1.isEmpty() || numb2.isEmpty() || fromSys.isEmpty() || toSys.isEmpty()){
                    Toast.makeText(MathActivity.this, "Вы не ввели все данные", Toast.LENGTH_SHORT).show();
                    result.setText("");
                }
                else{
                    fromDecimalNumber content = ControlMath.calculate(new ControlMath.DataPath(numb1, numb2, fromSys, toSys), "divide");
                    if(content == null){
                        Toast.makeText(MathActivity.this, "Данные введены неправильно.", Toast.LENGTH_SHORT).show();
                        result.setText("");
                    }
                    else{
                        String Result = "";
                        if(!content.getSign()){
                            Result += "- ";
                        }
                        if(content.getOriginalNumerator().equals(BigInteger.ZERO)){
                            Result += "0";
                        }
                        else{
                            Result += content.getInteger();
                        }
                        if(!(content.getOriginalDenominator().equals(BigInteger.ONE))){
                            Result += (" " + content.getFloat() + " / " + content.getDenominator());
                        }
                        result.setText(Result);
                    }
                }
            }
        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numb1 = num1.getText().toString();
                numb2 = num2.getText().toString();
                fromSys = fromsys.getText().toString();
                toSys = tosys.getText().toString();
                if(numb1.isEmpty() || numb2.isEmpty() || fromSys.isEmpty() || toSys.isEmpty()){
                    Toast.makeText(MathActivity.this, "Вы не ввели все данные", Toast.LENGTH_SHORT).show();
                    result.setText("");
                }
                else{
                    fromDecimalNumber content = ControlMath.calculate(new ControlMath.DataPath(numb1, numb2, fromSys, toSys), "pow");
                    if(content == null){
                        Toast.makeText(MathActivity.this, "Данные введены неправильно.", Toast.LENGTH_SHORT).show();
                        result.setText("");
                    }
                    else{
                        String Result = "";
                        if(!content.getSign()){
                            Result += "- ";
                        }
                        if(content.getOriginalNumerator().equals(BigInteger.ZERO)){
                            Result += "0";
                        }
                        else{
                            Result += content.getInteger();
                        }
                        if(!(content.getOriginalDenominator().equals(BigInteger.ONE))){
                            Result += (" " + content.getFloat() + " / " + content.getDenominator());
                        }
                        result.setText(Result);
                    }
                }
            }
        });
//        sqrt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                numb1 = num1.getText().toString();
//                numb2 = num2.getText().toString();
//                fromSys = fromsys.getText().toString();
//                toSys = tosys.getText().toString();
//                if(numb1.isEmpty() || numb2.isEmpty() || fromSys.isEmpty() || toSys.isEmpty()){
//                    Toast.makeText(MathActivity.this, "Вы не ввели все данные", Toast.LENGTH_SHORT).show();
//                    result.setText("");
//                }
//                else{
//                    fromDecimalNumber content = ControlMath.calculate(new ControlMath.DataPath(numb1, numb2, fromSys, toSys), "sqrt");
//                    if(content == null){
//                        Toast.makeText(MathActivity.this, "Произошла ошибка.", Toast.LENGTH_SHORT).show();
//                        result.setText("");
//                    }
//                    else{
//                        String Result = "";
//                        if(!content.getSign()){
//                            Result += "- ";
//                        }
//                        if(content.getOriginalNumerator().equals(BigInteger.ZERO)){
//                            Result += "0";
//                        }
//                        else{
//                            Result += content.getInteger();
//                        }
//                        if(!(content.getOriginalDenominator().equals(BigInteger.ONE))){
//                            Result += (" " + content.getFloat() + " / " + content.getDenominator());
//                        }
//                        result.setText(Result);
//                    }
//                }
//            }
//        });
//        log.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                numb1 = num1.getText().toString();
//                numb2 = num2.getText().toString();
//                fromSys = fromsys.getText().toString();
//                toSys = tosys.getText().toString();
//                if(numb1.isEmpty() || numb2.isEmpty() || fromSys.isEmpty() || toSys.isEmpty()){
//                    Toast.makeText(MathActivity.this, "Вы не ввели все данные", Toast.LENGTH_SHORT).show();
//                    result.setText("");
//                }
//                else{
//                    fromDecimalNumber content = ControlMath.calculate(new ControlMath.DataPath(numb1, numb2, fromSys, toSys), "log");
//                    if(content == null){
//                        Toast.makeText(MathActivity.this, "Произошла ошибка.", Toast.LENGTH_SHORT).show();
//                        result.setText("");
//                    }
//                    else{
//                        String Result = "";
//                        if(!content.getSign()){
//                            Result += "- ";
//                        }
//                        if(content.getOriginalNumerator().equals(BigInteger.ZERO)){
//                            Result += "0";
//                        }
//                        else{
//                            Result += content.getInteger();
//                        }
//                        if(!(content.getOriginalDenominator().equals(BigInteger.ONE))){
//                            Result += (" " + content.getFloat() + " / " + content.getDenominator());
//                        }
//                        result.setText(Result);
//                    }
//                }
//            }
//        });
    }
}