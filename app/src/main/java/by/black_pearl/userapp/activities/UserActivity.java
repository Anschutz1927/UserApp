package by.black_pearl.userapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import by.black_pearl.userapp.R;

public class UserActivity extends AppCompatActivity {

    public static final String REQUEST_CODE = "requestCode";
    public static final int NONE_REQUEST_CODE = 0;
    public static final int ADD_USER_REQUEST_CODE = 1;
    public static final int EDIT_USER_REQUEST_CODE = 2;
    private int mCurrentRequestCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mCurrentRequestCode = getIntent().getIntExtra(REQUEST_CODE, 1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        switch (mCurrentRequestCode) {
            case NONE_REQUEST_CODE:
                toolbar.setTitle("App err");
                break;
            case ADD_USER_REQUEST_CODE:
                toolbar.setTitle("Add user");
                break;
            case EDIT_USER_REQUEST_CODE:
                toolbar.setTitle("Edit user");
                break;
        }
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setEnabled(false);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
