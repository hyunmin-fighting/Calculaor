package com.example.day02_calculaor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText2;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8,
            btn9, btn10, btn11, btn12, btn13, btn14, btn15;


    int num1;
    int num2;
    int operation;

    double result;

    boolean isFirstData;
    boolean checkData;
    boolean isCompleteCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.et_1);
        editText2 = (EditText)findViewById(R.id.et_2);
        btn0 = (Button)findViewById(R.id.btn_0);
        btn1 = (Button)findViewById(R.id.btn_1);
        btn2 = (Button)findViewById(R.id.btn_2);
        btn3 = (Button)findViewById(R.id.btn_3);
        btn4 = (Button)findViewById(R.id.btn_4);
        btn5 = (Button)findViewById(R.id.btn_5);
        btn6 = (Button)findViewById(R.id.btn_6);
        btn7 = (Button)findViewById(R.id.btn_7);
        btn8 = (Button)findViewById(R.id.btn_8);
        btn9 = (Button)findViewById(R.id.btn_9);
        btn10 = (Button)findViewById(R.id.btn_10);
        btn11 = (Button)findViewById(R.id.btn_11);
        btn12 = (Button)findViewById(R.id.btn_12);
        btn13 = (Button)findViewById(R.id.btn_13);
        btn14 = (Button)findViewById(R.id.btn_14);
        btn15 = (Button)findViewById(R.id.btn_15);

        Listener listener = new Listener();
        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
        btn10.setOnClickListener(listener);
        btn11.setOnClickListener(listener);
        btn12.setOnClickListener(listener);
        btn13.setOnClickListener(listener);
        btn14.setOnClickListener(listener);
        btn15.setOnClickListener(listener);

        isFirstData = true;
        isCompleteCal = false;
    }

    class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_0:
                    if(isFirstData == true){
                        if(editText.length() > 1 && !editText.getText().toString().equals("0")){
                            editText.append("0");
                        }
                    } else chkNum("0");
                    break;

                case R.id.btn_1:
                    chkNum("1");
                    break;
                case R.id.btn_2:
                    chkNum("2");
                    break;
                case R.id.btn_3:
                    chkNum("3");
                    break;
                case R.id.btn_4:
                    chkNum("4");
                    break;
                case R.id.btn_5:
                    chkNum("5");
                    break;
                case R.id.btn_6:
                    chkNum("6");
                    break;
                case R.id.btn_7:
                    chkNum("7");
                    break;
                case R.id.btn_8:
                    chkNum("8");
                    break;
                case R.id.btn_9:
                    chkNum("9");
                    break;


                //"C" ??????????????? ??????
                case R.id.btn_10:
                    ResetDisplay();
                    break;
                //"=" ??????
                case R.id.btn_11:
                    cal();
                    break;
                //"+" ?????????
                case R.id.btn_12:
                    chkOp(1);
                    break;
                //"-" ??????
                case R.id.btn_13:
                    chkOp(2);
                    break;
                //"X" ?????????
                case R.id.btn_14:
                    chkOp(3);
                    break;
                //"/" ?????????
                case R.id.btn_15:
                    chkOp(4);
                    break;
            }
        }

        // ?????? ????????? ???????????? ???????????? ?????????(??????????????? ????????? ?????? ?????? ??????)
        void chkNum(String num){
            // ????????? ?????? ??? editText?????? 0?????? ?????????
            if(isFirstData != checkData){
                editText.setText("0");
                checkData = isFirstData;
            }
            // ????????? ????????? 1?????? ??????????????? ???????????? 0????????? ????????? ???????????? ??????
            if(editText.length() == 1 && editText.getText().toString().equals("0")){
                editText.setText(num);
            }
            // ??????????????? ?????????????????? ????????? ????????? ??????
            else{
                editText.append(num);
            }
            isCompleteCal = false;
        }

        // ?????? ????????? ???????????? ???????????? ?????????(??????????????? ????????????, 1:+, 2:-. 3:X, 4:/)
        void chkOp(int num){

            // ?????? ????????? ???????????? ???????????? ?????????
            if(isFirstData == true && editText.length() == 1 && editText.getText().toString().equals("0")){
            }
            // ?????? ?????? ??? ???????????? ???????????? ?????????
            else if(isCompleteCal){
            }
            // ???????????? ?????? ??? ??? ?????? ???????????? ???????????? ??????
            else if(isFirstData == false){
                //cal();
            }
            // ???????????? ?????? ??? ?????????????????? ????????? ??????
            else{

                num1 = Integer.parseInt(editText.getText().toString());
                operation = num;
                isFirstData = false;
            }
        }

        // "=" ?????? ???????????? ???????????? ?????????(?????? ?????????)
        void cal(){
            if(!isFirstData){
                if(operation == 1){
                    num2 = Integer.parseInt(editText.getText().toString());
                    result = (double)num1 + (double)num2;
                } else if(operation == 2){
                    num2 = Integer.parseInt(editText.getText().toString());
                    result = (double)num1 - (double)num2;
                } else if(operation == 3){
                    num2 = Integer.parseInt(editText.getText().toString());
                    result = (double)num1 * (double)num2;
                } else if(operation == 4){
                    num2 = Integer.parseInt(editText.getText().toString());
                    result = (double)num1 / (double)num2;
                }
                editText.setText("(?????????) " + Double.toString(result));
                num1 = 0;
                num2 = 0;
                result = 0;
                isFirstData = true;
                operation = 0;
                isCompleteCal = true;
            }
        }

        // ????????? ?????? ?????? ?????????
        void ResetDisplay(){
            //?????? ????????? ????????? ?????????
            String chkData = editText.getText().toString();
            if(chkData.equals("0") && chkData.length() == 1){
                //???????????? ??????????????? ????????? ?????????
            }else if(isCompleteCal){
            }else {
                String tempData = editText.getText().toString();
                if(tempData.length() > 0) {
                    editText.setText(tempData.substring(0, tempData.length() - 1));
                }
            }
        }

    }
}