package de.karolinpflug.fittyapp.control;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.karolinpflug.fittyapp.R;


public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";

    @Bind(R.id.toolbar) protected Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
    }

    protected abstract int getLayoutResourceId();


}
