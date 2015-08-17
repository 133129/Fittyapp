package de.karolinpflug.fittyapp.training;

import android.os.Bundle;
import android.view.MenuItem;

import de.karolinpflug.fittyapp.R;
import de.karolinpflug.fittyapp.control.BaseActivity;


public class TrainingStartPage extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

   @Override
    protected int getLayoutResourceId() {
        return R.layout.layout_trainingstartpage;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();//stop Activity
                return true;
            default:
                return false;
        }
    }
}
