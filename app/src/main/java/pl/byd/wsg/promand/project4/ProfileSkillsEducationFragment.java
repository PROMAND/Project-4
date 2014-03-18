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
import android.widget.TextView;

/**
 * Created by Marika on 17.03.14.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ProfileSkillsEducationFragment extends JustAFragment {

    public ProfileSkillsEducationFragment(ActionBar.Tab tab)
    {
        super(tab);
    }
    private MyCareerUserDao datasource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_skills_education, container, false);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        datasource = new MyCareerUserDao(getActivity());
        datasource.open();

        MyCareerUser myUser = datasource.getUser();

        TextView textView = (TextView)view.findViewById(R.id.textView_education_area);
        Button backBtn = (Button) view.findViewById(R.id.btn_back_education);
        Button okBtn = (Button)view.findViewById(R.id.btn_education_ok);
        Button cancelBtn = (Button)view.findViewById(R.id.btn_education_cancel);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileSkillsMainViewFragment(tab));
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileSkillsMainViewFragment(tab));
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileSkillsMainViewFragment(tab));
            }
        });

        if(!myUser.getEducation().equalsIgnoreCase("")){
            textView.setText(myUser.getEducation());
        }
        else {
            textView.setHint("Here I will describe my education");
        }

    }

}