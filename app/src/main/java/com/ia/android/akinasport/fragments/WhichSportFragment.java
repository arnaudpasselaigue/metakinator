package com.ia.android.akinasport.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ia.android.akinasport.R;
import com.ia.android.akinasport.activity.FinalActivity;
import com.ia.android.akinasport.customviews.AkinasportTextView;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by Arnaud on 12/05/2016.
 */
public class WhichSportFragment extends Fragment
{
    private FinalActivity finalActivity;

    private AkinasportTextView textViewQuestion;
    private MaterialEditText editText;
    private Button buttonValidate;

    public static final WhichSportFragment newInstance(FinalActivity activity)
    {
        WhichSportFragment whichSportFragment = new WhichSportFragment(activity);

        return whichSportFragment;
    }

    public WhichSportFragment() {}

    public WhichSportFragment(FinalActivity a)
    {
        finalActivity = a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_which_sport, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        textViewQuestion = (AkinasportTextView)view.findViewById(R.id.textView);
        editText = (MaterialEditText)view.findViewById(R.id.editText);
        buttonValidate = (Button)view.findViewById(R.id.buttonValidate);
    }
}
