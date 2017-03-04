package by.black_pearl.userapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioButton;
import android.widget.TextView;

import by.black_pearl.userapp.R;

public class UserDetailActivity extends AppCompatActivity {

    public static String INCOME = "income";
    public static String CITY = "city";
    public static String SEX = "sex";
    public static String AGE = "age";
    public static String LAST_NAME = "lastName";
    public static String FIRST_NAME = "firstName";
    public static String ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((TextView) findViewById(R.id.content_user_firstName)).setText(getIntent().getStringExtra(FIRST_NAME));
        ((TextView) findViewById(R.id.content_user_lastName)).setText(getIntent().getStringExtra(LAST_NAME));
        ((TextView) findViewById(R.id.content_user_age)).setText(String.valueOf(getIntent().getIntExtra(AGE, 0)));
        ((TextView) findViewById(R.id.content_user_city)).setText(getIntent().getStringExtra(CITY));
        ((TextView) findViewById(R.id.content_user_incomeIn)).setText(String.valueOf(getIntent().getIntExtra(INCOME, 0)));
        if(getIntent().getStringExtra(SEX).equals("male")) {
            ((RadioButton) findViewById(R.id.content_user_radioButtonMale)).setChecked(true);
        }
        else {
            ((RadioButton) findViewById(R.id.content_user_radioButtonFemale)).setChecked(true);
        }
        findViewById(R.id.content_user_radioButtonMale).setEnabled(false);
        findViewById(R.id.content_user_radioButtonFemale).setEnabled(false);
    }

}
