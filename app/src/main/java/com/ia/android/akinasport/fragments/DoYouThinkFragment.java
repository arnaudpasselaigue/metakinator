package com.ia.android.akinasport.fragments;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ia.android.akinasport.R;
import com.ia.android.akinasport.activity.FinalActivity;
import com.ia.android.akinasport.customlisteners.OnEntitiesListener;
import com.ia.android.akinasport.customviews.AkinasportTextView;
import com.ia.android.akinasport.services.PsEntities;
import com.ia.android.akinasport.utils.GlobalVariables;

/**
 * Created by Arnaud on 26/05/2016.
 */
public class DoYouThinkFragment extends Fragment
{
    private FinalActivity finalActivity;

    private String entity;
    private String oldEntity;

    private AkinasportTextView textView;

    private Button btnYes;
    private Button btnNo;

    public static final DoYouThinkFragment newInstance(FinalActivity activity, String entity, String oldEntity)
    {
        DoYouThinkFragment fragment = new DoYouThinkFragment(activity, entity, oldEntity);

        return fragment;
    }

    public DoYouThinkFragment() {}

    public DoYouThinkFragment(FinalActivity a, String entity, String oldEntity)
    {
        this.finalActivity = a;
        this.entity = entity;
        this.oldEntity = oldEntity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doyouthink, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = (AkinasportTextView)view.findViewById(R.id.textViewDoYouThink);
        btnYes = (Button)view.findViewById(R.id.buttonYes);
        btnNo = (Button)view.findViewById(R.id.buttonNo);

        btnYes.setOnClickListener(btnYesListener);
        btnNo.setOnClickListener(btnNoListener);

        textView.setText("Cela ne s'écrirais pas " + entity + " par hasard ?");
    }

    public View.OnClickListener btnYesListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), entity + " a bien été mis à jour avec la base de conaissance. Merci de votre participation.", Toast.LENGTH_SHORT).show();

            finalActivity.getPagerAdapter().addFragmentAtLast(ReplayFragment.newInstance(finalActivity));
            finalActivity.getViewPager().setCurrentItem(finalActivity.getPagerAdapter().getCount());
        }
    };

    public View.OnClickListener btnNoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            PsEntities psEntities = new PsEntities();
            psEntities.sendEntity(GlobalVariables.getsInstance().getDaneelForLearning(), oldEntity, entitiesListener);

            finalActivity.getPagerAdapter().addFragmentAtLast(ReplayFragment.newInstance(finalActivity));
            finalActivity.getViewPager().setCurrentItem(finalActivity.getPagerAdapter().getCount());
        }
    };

    public OnEntitiesListener entitiesListener = new OnEntitiesListener() {
        @Override
        public void OnResponse(String entity) {}

        @Override
        public void OnResponse(boolean success) {
            Toast.makeText(getContext(), entity + " a bien été ajouté à la base de conaissance. Merci de votre participation.", Toast.LENGTH_SHORT).show();

            finalActivity.getPagerAdapter().addFragmentAtLast(ReplayFragment.newInstance(finalActivity));
            finalActivity.getViewPager().setCurrentItem(finalActivity.getPagerAdapter().getCount());
        }
    };
}
