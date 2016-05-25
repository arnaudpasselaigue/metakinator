package com.ia.android.akinasport.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ia.android.akinasport.R;
import com.ia.android.akinasport.activity.FinalActivity;

/**
 * Created by Arnaud on 12/05/2016.
 */
public class KnowOrDontKnowFragment extends Fragment
{
    private FinalActivity finalActivity;

    private Button buttonYes;
    private Button buttonNo;

    public static final KnowOrDontKnowFragment newInstance(FinalActivity activity)
    {
        KnowOrDontKnowFragment fragment = new KnowOrDontKnowFragment(activity);

        return fragment;
    }

    public KnowOrDontKnowFragment() {}

    public KnowOrDontKnowFragment(FinalActivity a)
    {
        finalActivity = a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_know_or_dont_know, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        buttonYes = (Button)view.findViewById(R.id.buttonYes);
        buttonNo = (Button)view.findViewById(R.id.buttonNo);

        buttonYes.setOnClickListener(buttonYesListener);
        buttonNo.setOnClickListener(buttonNoListener);
    }

    public View.OnClickListener buttonYesListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finalActivity.getPagerAdapter().addFragmentAtLast(ReplayFragment.newInstance(finalActivity));
            finalActivity.getViewPager().setCurrentItem(finalActivity.getPagerAdapter().getCount());
        }
    };

    public View.OnClickListener buttonNoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finalActivity.getPagerAdapter().addFragmentAtLast(WhichSportFragment.newInstance(finalActivity));
            finalActivity.getViewPager().setCurrentItem(finalActivity.getPagerAdapter().getCount());
        }
    };
}
