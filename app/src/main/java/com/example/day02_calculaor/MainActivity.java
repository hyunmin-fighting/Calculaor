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


                //"C" 텍스트표시 리셋
                case R.id.btn_10:
                    ResetDisplay();
                    break;
                //"=" 계산
                case R.id.btn_11:
                    cal();
                    break;
                //"+" 더하기
                case R.id.btn_12:
                    chkOp(1);
                    break;
                //"-" 빼기
                case R.id.btn_13:
                    chkOp(2);
                    break;
                //"X" 곱하기
                case R.id.btn_14:
                    chkOp(3);
                    break;
                //"/" 나누기
                case R.id.btn_15:
                    chkOp(4);
                    break;
            }
        }

        // 숫자 버튼을 눌렀을때 호출되는 메서드(매개변수는 눌러진 버튼 숫자 정보)
        void chkNum(String num){
            // 입력턴 변경 시 editText값을 0으로 초기화
            if(isFirstData != checkData){
                editText.setText("0");
                checkData = isFirstData;
            }
            // 문자열 길이가 1이고 입력되있는 문자열이 0일경우 새로운 문자열로 대체
            if(editText.length() == 1 && editText.getText().toString().equals("0")){
                editText.setText(num);
            }
            // 기타사항은 기존문자열에 새로운 문자열 추가
            else{
                editText.append(num);
            }
            isCompleteCal = false;
        }

        // 연산 버튼을 눌렀을때 호출되는 메서드(매개변수는 연산정보, 1:+, 2:-. 3:X, 4:/)
        void chkOp(int num){

            // 최초 시작시 연산버튼 클릭해도 무반응
            if(isFirstData == true && editText.length() == 1 && editText.getText().toString().equals("0")){
            }
            // 계산 완료 후 연산버튼 클릭해도 무반응
            else if(isCompleteCal){
            }
            // 두번째값 입력 후 또 다시 연산버튼 클릭해도 계산
            else if(isFirstData == false){
                //cal();
            }
            // 첫번째값 입력 후 특정연산버튼 클릭시 수행
            else{

                num1 = Integer.parseInt(editText.getText().toString());
                operation = num;
                isFirstData = false;
            }
        }

        // "=" 버튼 눌렀을때 호출되는 메서드(계산 메서드)
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
                editText.setText("(계산값) " + Double.toString(result));
                num1 = 0;
                num2 = 0;
                result = 0;
                isFirstData = true;
                operation = 0;
                isCompleteCal = true;
            }
        }

        // 텍스트 표시 리셋 메서드
        void ResetDisplay(){
            //최초 시작시 리셋키 안먹음
            String chkData = editText.getText().toString();
            if(chkData.equals("0") && chkData.length() == 1){
                //결과값이 출력됬을때 리셋키 안먹음
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