package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9 ;
    Button btnYd, btnPlusMinus;
    Button btnPlus, btnMinus, btnKobeity, btnBolu, btnProsent, btnNukte, btnTen, btnDel ;
    TextView tvSan, tv_Zapis;

    String BirinshiSan, EkinshiSan,  znak, zapisText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnNukte = findViewById(R.id.btnNukte);

        btnYd = findViewById(R.id.btnYd);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);


        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnKobeity = findViewById(R.id.btnKobeity);
        btnBolu = findViewById(R.id.btnBolu);
        btnProsent = findViewById(R.id.btnProsent);
        btnTen = findViewById(R.id.btnTen);
        btnDel = findViewById(R.id.btnDel);


        tvSan = findViewById(R.id.tv_san);
        tv_Zapis = findViewById(R.id.tv_zapis);

        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(View view){

                String aldingiSan = tvSan.getText().toString();
                String basilganSan = "";
                String songiRes = "";

                switch (view.getId()) {
                    case R.id.btn0:
                        basilganSan =  "0";
                        break;

                    case R.id.btn1:
                        basilganSan =  "1";
                        break;

                    case R.id.btn2:
                        basilganSan =  "2";
                        break;

                    case R.id.btn3:
                        basilganSan =  "3";
                        break;

                    case R.id.btn4:
                        basilganSan =  "4";
                        break;

                    case R.id.btn5:
                        basilganSan =  "5";
                        break;
                    case R.id.btn6:
                        basilganSan =  "6";
                        break;

                    case R.id.btn7:
                        basilganSan =  "7";
                        break;

                    case R.id.btn8:
                        basilganSan =  "8";
                        break;

                    case R.id.btn9:
                        basilganSan =  "9";
                        break;

                    case R.id.btnNukte:
                        basilganSan =  ".";
                        if (tvSan.getText().toString().contains(".")) {
                            basilganSan =  "";
                        } else {
                            basilganSan =  ".";
                        }
                        break;
                }
                if (!aldingiSan.equals("0")) songiRes = aldingiSan + basilganSan;
                else songiRes = basilganSan;

                tvSan.setText(songiRes);
            }
        };


        btn0.setOnClickListener(buttonSandar);
        btn1.setOnClickListener(buttonSandar);
        btn2.setOnClickListener(buttonSandar);
        btn3.setOnClickListener(buttonSandar);
        btn4.setOnClickListener(buttonSandar);
        btn5.setOnClickListener(buttonSandar);
        btn6.setOnClickListener(buttonSandar);
        btn7.setOnClickListener(buttonSandar);
        btn8.setOnClickListener(buttonSandar);
        btn9.setOnClickListener(buttonSandar);
        btnNukte.setOnClickListener(buttonSandar);

        View.OnClickListener buttonYdPlusMinus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch(view.getId()) {
                    case R.id.btnYd:

                        tvSan.setText("0");
                        break;
                    case R.id.btnDel:
                        String sanText = tvSan.getText().toString();
                        int san1 = Integer.parseInt (sanText);
                        System.out.println(san1);
                        int san2 = san1/10;
                        tvSan.setText(""+san2);
                        break;


                    case R.id.btnPlusMinus:
                        sanText = tvSan.getText().toString();
                        int san =Integer.parseInt(sanText);
                        if (san > 0)tvSan.setText("-"+sanText);
                        else{
                            san = san * (-1);
                            tvSan.setText(""+san);
                        }


                        break;
                }
            }
        };

        btnYd.setOnClickListener(buttonYdPlusMinus);
        btnPlusMinus.setOnClickListener(buttonYdPlusMinus);
        btnDel.setOnClickListener(buttonYdPlusMinus);

        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BirinshiSan = tvSan.getText().toString();
                switch (view.getId()){
                    case R.id.btnPlus:
                        znak = "+";
                        break;

                    case R.id.btnMinus:
                        znak = "-";
                        break;

                    case R.id.btnKobeity:
                        znak = "*";
                        break;

                    case R.id.btnBolu:
                        znak = "/";
                        break;

                    case R.id.btnProsent:
                        znak = "%";
                        break;

                    case R.id.btnNukte:
                        znak = ".";
                        break;

                }
                zapisText = BirinshiSan + znak;
                tv_Zapis.setText(zapisText);
                tvSan.setText("0");
            }
        };

        btnPlus.setOnClickListener(btnFunctions);
        btnMinus.setOnClickListener(btnFunctions);
        btnKobeity.setOnClickListener(btnFunctions);
        btnBolu.setOnClickListener(btnFunctions);
        btnProsent.setOnClickListener(btnFunctions);


        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvSan.getText().toString().contains(".")) {
                    EkinshiSan = tvSan.getText().toString();
                    double san1 = Double.parseDouble(BirinshiSan);
                    double san2 = Double.parseDouble(EkinshiSan);
                    double res = 0;

                    if (znak.equals("+")) {
                        res = san1 + san2;
                    } else if (znak.equals("-")) {
                        res = san1 - san2;
                    } else if (znak.equals("*")) {
                        res = san1 * san2;
                    }else if (znak.equals("/")) {
                        res = san1 / san2;
                    }else if (znak.equals("%")) {
                        res = san1 / 100;
                    }
                    zapisText = BirinshiSan + znak + EkinshiSan + " = " + res;

                    tv_Zapis.setText(zapisText);
                    tvSan.setText("" + res);


                } else {
                    EkinshiSan = tvSan.getText().toString();
                    int san1 = Integer.parseInt(BirinshiSan);
                    int san2 = Integer.parseInt(EkinshiSan);
                    int res = 0;

                    if (znak.equals("+")) {
                        res = san1 + san2;
                    } else if (znak.equals("-")) {
                        res = san1 - san2;
                    } else if (znak.equals("*")) {
                        res = san1 * san2;
                    }else if (znak.equals("/")) {
                        res = san1 / san2;
                    }else if (znak.equals("%")) {
                        res = san1 / 100;
                    }
                    zapisText = BirinshiSan + znak + EkinshiSan + " = " + res;

                    tv_Zapis.setText(zapisText);
                    tvSan.setText("" + res);
                }
            }
        });
    }
}