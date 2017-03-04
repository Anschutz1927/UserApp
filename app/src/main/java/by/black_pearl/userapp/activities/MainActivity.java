package by.black_pearl.userapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import by.black_pearl.userapp.R;
import by.black_pearl.userapp.RetrofitManager;
import by.black_pearl.userapp.UserData;
import by.black_pearl.userapp.adapters.RecyclerViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String URL = "https://floating-dusk-14900.herokuapp.com/";
    private static final String LOG_TAG = "__UserApp:MA__";
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivityForResult(
                        new Intent(MainActivity.this, UserActivity.class)
                                .putExtra(UserActivity.REQUEST_CODE, UserActivity.ADD_USER_REQUEST_CODE),
                        UserActivity.ADD_USER_REQUEST_CODE
                );
            }
        });
        this.mRecyclerView = (RecyclerView) findViewById(R.id.content_main_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerViewAdapter = new RecyclerViewAdapter(this);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        Retrofit retrofit = RetrofitManager.getRetrofit(URL);
        RetrofitManager.ServerApiInterface api = retrofit.create(RetrofitManager.ServerApiInterface.class);
        Call<List<UserData>> call = api.getUsersData();
        enqueue(call);
    }

    private void enqueue(Call<List<UserData>> call1) {
        call1.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                mRecyclerViewAdapter.changeData(response.body());
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                Log.i(LOG_TAG, "download fail!");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
