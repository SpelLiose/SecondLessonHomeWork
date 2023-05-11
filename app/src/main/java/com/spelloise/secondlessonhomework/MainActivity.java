package com.spelloise.secondlessonhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private float account = 1000;
    private float grant = 2_500;
    private float priceTelescope = 14_000;
    private int percentBank = 5;
    private float[] accountList = new float[120];
    private TextView countOut;
    private TextView manyMonthOut;

    public int numberOfMonths() {
        int count = 0;
        while (account < priceTelescope) {
            account = account + grant + (float) account * percentBank / (12 * 100);
            accountList[count] = account;
            count++;
        }
        return count;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countOut = findViewById(R.id.countOut);
        manyMonthOut = findViewById(R.id.manyMonthOut);

        countOut.setText("На телескоп будет копится еще " + numberOfMonths() + " месяцев");

        String listAccount = "";
        for (float list : accountList) {
            if (list > 0) {
                listAccount = listAccount + Float.toString(list) + " монет ";
            }
        }
        manyMonthOut.setText("Выписка по счету: " + listAccount);
    }
}