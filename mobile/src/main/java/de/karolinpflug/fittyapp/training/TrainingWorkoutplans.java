package de.karolinpflug.fittyapp.training;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.karolinpflug.fittyapp.R;
import de.karolinpflug.fittyapp.database.AppDB;
import de.karolinpflug.fittyapp.database.DatabaseHandler;

public class TrainingWorkoutplans extends Fragment {

    boolean mDuelPane;
    int mCurCheckPosition = 0;

    DatabaseHandler mDatabaseHandler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //set the layout
        View view = inflater.inflate(R.layout.training_traingplan, container, false);
        return view;
    }
    //RecyclerView


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*
        ArrayAdapter <String> connectArrayToListView = new
                ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,
                WorkoutplansDetails.NAMES);

        setListAdapter(connectArrayToListView);

        View detailsFrame = getActivity().findViewById(R.id.details);
        // Set mDuelPane based on whether you are in the horizontal layout
        // Check if the detailsFrame exists and if it is visible
        mDuelPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if(savedInstanceState != null){
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if(mDuelPane){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurCheckPosition);
        }
        */
        mDatabaseHandler = DatabaseHandler.getInstance(getActivity());
        Cursor workoutPlans = mDatabaseHandler.workoutPlanTableCursor("");
        if(workoutPlans != null && workoutPlans.moveToFirst()) {
            for(int i = 0; i < workoutPlans.getCount(); i++) {
                String planName = DatabaseHandler.getCursorStringField(workoutPlans, AppDB.WORKOUT_PLAN_NAME);
                Log.w("Workoutplans", planName);
                workoutPlans.moveToNext();
            }
            workoutPlans.close();
        }
    }

    /*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }
    */

    /*
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }
    */

    /*
    void showDetails(int index){
        mCurCheckPosition = index;

        if (mDuelPane){
            getListView().setItemChecked(index, true);
            TrainingDetailsFragment details = (TrainingDetailsFragment)
                    getFragmentManager().findFragmentById(R.id.details);
            if (details == null || details.getShownIndex() != index){
                details = TrainingDetailsFragment.newInstance(index);

                FragmentTransaction ft = getFragmentManager().beginTransaction();

                ft.replace(R.id.details, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            } else{
                Intent intent = new Intent();
                intent.setClass(getActivity(), TrainingWorkoutplanDetails.class);
                intent.putExtra("index", index);
                startActivity(intent);
            }
        }
    }
    */
}
