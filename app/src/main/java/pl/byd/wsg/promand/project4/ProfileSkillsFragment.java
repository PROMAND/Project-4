package pl.byd.wsg.promand.project4;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Marika on 14.03.14.
 */
public class ProfileSkillsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile_skills, container, false);
        Log.v("pl.byd.wsg.promand.project4", "View inflated");
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Button back = (Button)view.findViewById(R.id.btn_back_profile_skills);
        Button experience = (Button)view.findViewById(R.id.btn_skills_experience);
        Button trainings = (Button)view.findViewById(R.id.btn_skills_training);
        Button education = (Button)view.findViewById(R.id.btn_skills_education);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileFragment());
            }
        });

        experience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileSkillsExperienceFragment());
            }
        });

        trainings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileSkillsTrainingFragment());
            }
        });

        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileSkillsEducationFragment());
            }
        });
    }

    //Button click - to replace current fragment with new one
    public void btnClick(Fragment fragment)
    {
        Fragment fr = fragment;
        FragmentTransaction fto = getFragmentManager().beginTransaction();

        fto.replace(R.id.content_frame, fr);
        fto.addToBackStack(null);
        fto.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("pl.byd.wsg.promand.project4", "Fragment onStart()");

    }
}
