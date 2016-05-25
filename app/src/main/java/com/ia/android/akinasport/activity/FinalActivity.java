package com.ia.android.akinasport.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.ia.android.akinasport.R;
import com.ia.android.akinasport.customadapter.AkinasportPagerAdapter;
import com.ia.android.akinasport.customviews.AkinasportTextView;
import com.ia.android.akinasport.customviews.AkinasportTextViewBig;
import com.ia.android.akinasport.fragments.KnowOrDontKnowFragment;

import java.util.ArrayList;

/**
 * Created by Arnaud on 28/04/2016.
 */
public class FinalActivity extends ParentActivity
{
    private AkinasportTextView questionsWinnerTextView;

    private ViewPager viewPager;
    private AkinasportPagerAdapter pagerAdapter;
    private ArrayList<Fragment> listFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        setCustomActionBar();

        questionsWinnerTextView = (AkinasportTextView) findViewById(R.id.textViewWinnerQuestion);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        String winner;
        Bundle extras = getIntent().getExtras();

        if (extras != null)
            winner = "Vous pensez à " +  extras.getString("WinnerEntity") + ".";
        else
            winner = "Un problème est survenue.";

        questionsWinnerTextView.setText(winner + " ?");
        YoYo.with(Techniques.Landing).duration(1500).playOn(questionsWinnerTextView);

        initFragmentsAndViewPager();
    }

    public void initFragmentsAndViewPager()
    {
        listFragments.add(KnowOrDontKnowFragment.newInstance(this));

        pagerAdapter = new AkinasportPagerAdapter(getSupportFragmentManager(), listFragments);
        pagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(pagerAdapter);
        viewPager.setSaveEnabled(false);
        viewPager.setCurrentItem(pagerAdapter.getCount());
    }

    public ArrayList<Fragment> getListFragments() {return listFragments;}
    public void setListFragments(ArrayList<Fragment> listFragments) {this.listFragments = listFragments;}

    public ViewPager getViewPager() {return viewPager;}
    public void setViewPager(ViewPager viewPager) {this.viewPager = viewPager;}

    public AkinasportPagerAdapter getPagerAdapter() {return pagerAdapter;}
    public void setPagerAdapter(AkinasportPagerAdapter pagerAdapter) {this.pagerAdapter = pagerAdapter;}
}
