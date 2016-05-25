package com.ia.android.akinasport.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ia.android.akinasport.R;
import com.ia.android.akinasport.activity.ChoiceActivity;
import com.ia.android.akinasport.activity.FinalActivity;
import com.ia.android.akinasport.activity.MainActivity;

/**
 * Created by Arnaud on 12/05/2016.
 */
public class ReplayFragment extends Fragment
{
    private FinalActivity finalActivity;

    private Button buttonReplay;
    private Button buttonSwitchTheme;

    public static final ReplayFragment newInstance(FinalActivity a)
    {
        ReplayFragment replayFragment = new ReplayFragment(a);

        return replayFragment;
    }

    public ReplayFragment() {
    }

    public ReplayFragment(FinalActivity a)
    {
        finalActivity = a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_replay, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonReplay = (Button)view.findViewById(R.id.buttonReplay);
        buttonSwitchTheme = (Button)view.findViewById(R.id.buttonSwitchTheme);

        buttonReplay.setOnClickListener(buttonReplayListener);
        buttonSwitchTheme.setOnClickListener(buttonSwitchThemeListener);
    }

    public View.OnClickListener buttonReplayListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent main = new Intent(finalActivity, MainActivity.class);
            main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            finalActivity.finish();
            startActivity(main);
        }
    };

    public View.OnClickListener buttonSwitchThemeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent choice = new Intent(finalActivity, ChoiceActivity.class);
            choice.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            finalActivity.finish();
            startActivity(choice);
        }
    };
}