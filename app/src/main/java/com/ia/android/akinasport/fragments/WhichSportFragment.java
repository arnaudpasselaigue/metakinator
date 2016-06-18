package com.ia.android.akinasport.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.gsm.GsmCellLocation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.ia.android.akinasport.R;
import com.ia.android.akinasport.activity.FinalActivity;
import com.ia.android.akinasport.customlisteners.OnEntitiesListener;
import com.ia.android.akinasport.customviews.AkinasportTextView;
import com.ia.android.akinasport.services.PsEntities;
import com.ia.android.akinasport.utils.GlobalVariables;
import com.pnikosis.materialishprogress.ProgressWheel;
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

    private ProgressWheel progressWheel;

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
        buttonValidate.setOnClickListener(validateBtnListener);

        progressWheel = (ProgressWheel)view.findViewById(R.id.progressWheel);
        progressWheel.setBarColor(R.color.whiteColor);
    }

    public View.OnClickListener validateBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            if (editText.getText() != null && !editText.getText().toString().equals(""))
            {
                PsEntities psEntities = new PsEntities();

                psEntities.getIfEntityAlreadyExist(editText.getText().toString(), entitiesListener);
            }
            else
            {
                YoYo.with(Techniques.Shake).duration(500).playOn(editText);
                editText.setError("Veuillez rentrer un " + GlobalVariables.getsInstance().getKlassName() + ".");
            }
        }
    };

    public OnEntitiesListener entitiesListener = new OnEntitiesListener() {
        @Override
        public void OnResponse(String entity) {
            if (entity != null)
            {
                finalActivity.getPagerAdapter().addFragmentAtLast(DoYouThinkFragment.newInstance(finalActivity, entity, editText.getText().toString()));
                finalActivity.getViewPager().setCurrentItem(finalActivity.getPagerAdapter().getCount());
            }
            else
                editText.setError("Veuillez rentrer un " + GlobalVariables.getsInstance().getKlassName() + " valide.");
        }

        @Override
        public void OnResponse(boolean success) {

        }
    };
}
