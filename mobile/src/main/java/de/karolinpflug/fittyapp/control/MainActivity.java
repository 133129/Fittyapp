package de.karolinpflug.fittyapp.control;

import android.content.Intent;
import android.os.Bundle;

import butterknife.OnClick;
import de.karolinpflug.fittyapp.R;
import de.karolinpflug.fittyapp.editworkout.EditWorkout;
import de.karolinpflug.fittyapp.profil.Profil;
import de.karolinpflug.fittyapp.training.TrainingStartPage;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * load MainActivity layout
     * @return
     */
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.buttonTraining) void switchToTrainigActivity(){
        Intent myIntent = new Intent(this, TrainingStartPage.class);
        startActivity(myIntent);
    }

    @OnClick(R.id.buttonEditworkout) void switchToEditWorkoutActivity() {
        Intent myIntent = new Intent(this, EditWorkout.class);
        startActivity(myIntent);
    }

    @OnClick(R.id.buttonProfil) void switchToProfil() {
        Intent myIntent = new Intent(this, Profil.class);
        startActivity(myIntent);
    }


}
