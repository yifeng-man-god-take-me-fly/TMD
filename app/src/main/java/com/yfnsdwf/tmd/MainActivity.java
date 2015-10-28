package com.yfnsdwf.tmd;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton mAddTaskFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar)findViewById(R.id.main_toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_profile_white_24dp);

        mAddTaskFab = (FloatingActionButton)findViewById(R.id.add_task_fab);
        mAddTaskFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
                startActivityForResult(intent, NewTaskActivity.REQ_NEW_TASK);
            }
        });

        setSupportActionBar(mToolbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case NewTaskActivity.REQ_NEW_TASK:
                // TODO
                switch (requestCode) {
                    case NewTaskActivity.RES_OK:
                        Bundle extras = data.getExtras();
                        String nam = extras.getString(NewTaskActivity.KEY_TASK_NAME);
                        String des = extras.getString(NewTaskActivity.KEY_TASK_DESCRIPTION);
                        Toast.makeText(this, nam + " ; " + des, Toast.LENGTH_LONG).show();
                        break;
                    case NewTaskActivity.RES_CANCEL:
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MyProfileActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
