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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Marika on 17.03.14.
 */
public class ProfileSkillsTrainingFragment extends JustAFragment {
    public ProfileSkillsTrainingFragment(ActionBar.Tab tab)
    {
        super(tab);
    }
    private MyCareerUserDao datasource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_skills_trainings, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        datasource = new MyCareerUserDao(getActivity());
        datasource.open();

        final MyCareerUser myUser = datasource.getUser();

        final TextView textView = (TextView)view.findViewById(R.id.textView_trainings_area);
        ImageButton okBtn = (ImageButton) view.findViewById(R.id.btn_trainings_ok);
        ImageButton cancelBtn = (ImageButton) view.findViewById(R.id.btn_trainings_cancel);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myUser.setTrainings(textView.getText().toString());
                datasource.updateUser(myUser);
                Toast.makeText(getActivity(), "Profile updated!",
                        Toast.LENGTH_SHORT).show();
               // btnClick(new ProfileSkillsMainViewFragment(tab));
                getFragmentManager().popBackStack();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //btnClick(new ProfileSkillsMainViewFragment(tab));
                getFragmentManager().popBackStack();
            }
        });
        textView.setHint("Here I will describe my trainings");
        try {
            textView.setText(myUser.getTrainings());
        }
       catch (Exception e) {
       }


    }

}