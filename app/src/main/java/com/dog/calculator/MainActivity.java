package com.dog.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity implements View.OnClickListener{

    private EditText mEdtNumber;
    private TextView mTvResult;

    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtn7;
    private Button mBtn8;
    private Button mBtn9;
    private Button mBtn0;

    private Button mBtnCong;
    private Button mBtnTru;
    private Button mBtnNhan;
    private Button mBtnChia;

    private Button mBtnCham;
    private Button mBtnBang;
    private Button mBtnC;
    private Button mBtnAc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
        setEventClickViews();
    }

    public void initWidget() {
        mBtn1 = (Button) findViewById(R.id.btn_1);
        mBtn2 = (Button) findViewById(R.id.btn_2);
        mBtn3 = (Button) findViewById(R.id.btn_3);
        mBtn4 = (Button) findViewById(R.id.btn_4);
        mBtn5 = (Button) findViewById(R.id.btn_5);
        mBtn6 = (Button) findViewById(R.id.btn_6);
        mBtn7 = (Button) findViewById(R.id.btn_7);
        mBtn8 = (Button) findViewById(R.id.btn_8);
        mBtn9 = (Button) findViewById(R.id.btn_9);
        mBtn0 = (Button) findViewById(R.id.btn_0);

        mBtnCong = (Button) findViewById(R.id.btn_cong);
        mBtnTru = (Button) findViewById(R.id.btn_tru);
        mBtnNhan = (Button) findViewById(R.id.btn_nhan);
        mBtnChia = (Button) findViewById(R.id.btn_chia);

        mBtnCham = (Button) findViewById(R.id.btn_cham);
        mBtnBang = (Button) findViewById(R.id.btn_bang);
        mBtnC = (Button) findViewById(R.id.btn_c);
        mBtnAc = (Button) findViewById(R.id.btn_ac);
    }

    public void setEventClickViews() {
        mEdtNumber = (EditText) findViewById(R.id.edt_input);
        mTvResult = (TextView) findViewById(R.id.tv_result);

        mBtn1.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);
        mBtn5.setOnClickListener(this);
        mBtn6.setOnClickListener(this);
        mBtn7.setOnClickListener(this);
        mBtn8.setOnClickListener(this);
        mBtn9.setOnClickListener(this);
        mBtn0.setOnClickListener(this);

        mBtnCong.setOnClickListener(this);
        mBtnTru.setOnClickListener(this);
        mBtnNhan.setOnClickListener(this);
        mBtnChia.setOnClickListener(this);

        mBtnCham.setOnClickListener(this);
        mBtnBang.setOnClickListener(this);
        mBtnC.setOnClickListener(this);
        mBtnAc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                mEdtNumber.append("0");
                break;
            case R.id.btn_1:
                mEdtNumber.append("1");
                break;
            case R.id.btn_2:
                mEdtNumber.append("2");
                break;
            case R.id.btn_3:
                mEdtNumber.append("3");
                break;
            case R.id.btn_4:
                mEdtNumber.append("4");
                break;
            case R.id.btn_5:
                mEdtNumber.append("5");
                break;
            case R.id.btn_6:
                mEdtNumber.append("6");
                break;
            case R.id.btn_7:
                mEdtNumber.append("7");
                break;
            case R.id.btn_8:
                mEdtNumber.append("8");
                break;
            case R.id.btn_9:
                mEdtNumber.append("9");
                break;

            case R.id.btn_cong:
                mEdtNumber.append("+");
                break;
            case R.id.btn_tru:
                mEdtNumber.append("-");
                break;
            case R.id.btn_nhan:
                mEdtNumber.append("*");
                break;
            case R.id.btn_chia:
                mEdtNumber.append("/");
                break;

            case R.id.btn_cham:
                mEdtNumber.append(".");
                break;
            case R.id.btn_ac:
                mEdtNumber.setText("");
                mTvResult.setText("");
                break;
            case R.id.btn_c:
                BaseInputConnection textFieldInputConnection = new BaseInputConnection(mEdtNumber, true);
                textFieldInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btn_bang:
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addOperation(mEdtNumber.getText().toString());
                addNumber(mEdtNumber.getText().toString());

                if (arrOperation.size() >= arrNumber.size() || arrOperation.size() < 1) {
                    mTvResult.setText("Lỗi định dạng");
                } else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);
                                } else {
                                    result += arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);
                                } else {
                                    result -= arrNumber.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);
                                } else {
                                    result *= arrNumber.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);
                                } else {
                                    result /= arrNumber.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                        mTvResult.setText(df.format(result) + "");
                    }
                }
        }
    }

    public ArrayList<String> arrOperation;
    public ArrayList<Double> arrNumber;

    public int addOperation(String input) {
        arrOperation = new ArrayList<>();
        char[] cArray = input.toCharArray();

        for (int i=0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }

    public void addNumber(String stringInput) {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()) {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
