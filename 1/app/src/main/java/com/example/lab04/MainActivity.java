package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CheckBox[] chk = new CheckBox[4];
        EditText[] num = new EditText[4];
        EditText[] price = new EditText[4];

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void calc(View v)
        {
            chk [0] = findViewById(R.id.AppleChk);
            chk [1] = findViewById(R.id.StrawChk);
            chk [2] = findViewById(R.id.BlueChk);
            chk [3] = findViewById(R.id.PotatoChk);

            num[0] = findViewById(R.id.AppleNum);
            num[1] = findViewById(R.id.StrawNum);
            num[2] = findViewById(R.id.BlueNum);
            num[3] = findViewById(R.id.PotatoNum);

            price[0] = findViewById(R.id.ApplePrice);
            price[1] = findViewById(R.id.StrawPrice);
            price[2] = findViewById(R.id.BluePrice);
            price[3] = findViewById(R.id.PotatoPrice);

            float sum = 0.0f;
            String text = new String();

            for(int i = 0; i < 4; i++)
            {
                if(chk[i].isChecked())
                {
                    int q;
                    try {
                        q = Integer.parseInt(num[i].getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Error: пустое поле", Toast.LENGTH_LONG).show();
                        return;
                    }

                    float p;
                    try {
                        p = Float.parseFloat(price[i].getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(this, "Error: пустое поле", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (q <= 0) {
                        Toast.makeText(this, "Error: пустое поле", Toast.LENGTH_LONG).show();
                        return;
                    }

                    if (p <= 0) {
                        Toast.makeText(this, "Error: пустое поле", Toast.LENGTH_LONG).show();
                        return;
                    }

                    float val = q * p;
                    sum += val;
                    String strval = String.format("%.2f", val);
                    String itemTotal = String.format("Цена %s (%d шт.): %s Руб.\n", chk[i].getText().toString(), q, strval);
                    text += itemTotal;
                }
            }
            String result = String.valueOf(sum);
            text += "Итоговая сумма равна: " + result + " Руб.";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();

        }
    }
}