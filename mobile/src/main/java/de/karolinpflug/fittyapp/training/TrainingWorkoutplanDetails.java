/*package de.karolinpflug.fittyapp.training;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class TrainingWorkoutplanDetails extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        if (savedInstanceState == null){
            TrainingDetailsFragment details = new TrainingDetailsFragment();

            details.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
    }
}
*/
