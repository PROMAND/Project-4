package pl.byd.wsg.promand.project4;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Marika on 17.03.14.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ProfileMainViewFragment extends JustAFragment {

    public ProfileMainViewFragment(ActionBar.Tab tab)
    {
        super(tab);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_main_view, container, false);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Button generalInfoBtn = (Button) view.findViewById(R.id.btn_my_profile_general);
        Button linkedInBtn = (Button) view.findViewById(R.id.btn_my_profile_linkedIn);
        Button cvBtn = (Button) view.findViewById(R.id.btn_my_profile_cv);
        Button skillsBtn = (Button) view.findViewById(R.id.btn_my_profile_skills);
        Button personalBtn = (Button) view.findViewById(R.id.btn_my_profile_personal);

        //for send to your freind functions



        generalInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileGeneralInfoFragment(tab));
            }
        });

        linkedInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileLinkedinFragment(tab));
            }
        });

        cvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileCvMainViewFragment(tab));
            }
        });

        skillsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileSkillsMainViewFragment(tab));
            }
        });

        personalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfilePersonalMainViewFragment(tab));
            }
        });
    }

}