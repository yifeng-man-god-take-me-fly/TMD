package com.yfnsdwf.tmd;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class NewTaskActivity extends AppCompatActivity {
    public static final int REQ_NEW_TASK = 0;

    public static final int RES_OK = 0;
    public static final int RES_CANCEL = 1;

    public static final String KEY_TASK_NAME = "TASK_NAME";
    public static final String KEY_TASK_DESCRIPTION = "TASK_DESCRIPTION";

    private Toolbar mToolbar;
    private EditText mTaskNameEditText;
    private EditText mTaskDescriptionEditText;

    private void doneAddTask() {
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putString(KEY_TASK_NAME, mTaskNameEditText.getText().toString());
        extras.putString(KEY_TASK_DESCRIPTION, mTaskDescriptionEditText.getText().toString());
        intent.putExtras(extras);
        setResult(RES_OK, intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        mToolbar = (Toolbar)findViewById(R.id.new_task_toolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_done_white_24dp);

        mTaskNameEditText = (EditText)findViewById(R.id.task_name_edit_text);

        mTaskDescriptionEditText = (EditText)findViewById(R.id.task_description_edit_text);

        mToolbar.setTitle(R.string.title_activity_new_task);

        setSupportActionBar(mToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                doneAddTask();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
