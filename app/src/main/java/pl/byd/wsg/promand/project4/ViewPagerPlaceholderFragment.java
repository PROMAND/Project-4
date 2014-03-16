package pl.byd.wsg.promand.project4;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class ViewPagerPlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ViewPagerPlaceholderFragment newInstance(int sectionNumber) {
        ViewPagerPlaceholderFragment fragment = new ViewPagerPlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ViewPagerPlaceholderFragment() {
    }
    public ViewGroup some;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView;
        switch (getArguments().getInt(ARG_SECTION_NUMBER))
        {
            case 1:
                rootView = inflater.inflate(R.layout.profile_cv_main, container, false);
                break;
            case 2:
                rootView = inflater.inflate(R.layout.profile_cv_preview, container, false);
                break;
            case 3:
                rootView = inflater.inflate(R.layout.profile_general_info, container, false);
                break;
            case 4:
                rootView = inflater.inflate(R.layout.profile_main_view, container, false);

                Button generalInfoButton = (Button) rootView.findViewById(R.id.btn_my_profile_general);
                Button skillsBtn = (Button) rootView.findViewById(R.id.btn_my_profile_skills);
                Button personalInfoBtn = (Button) rootView.findViewById(R.id.btn_my_profile_personal);
                Button linkedinBtn = (Button) rootView.findViewById(R.id.btn_my_profile_linkedIn);
                Button cvBtn = (Button) rootView.findViewById(R.id.btn_my_profile_cv);

                generalInfoButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Fragment fr = new ProfileGeneralInfoFragment();
                        FragmentTransaction fto = getFragmentManager().beginTransaction();

                        fto.replace(R.id.content_frame, fr);
                        fto.addToBackStack(null);
                        fto.commit();
                    }
                });

                skillsBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Fragment fr = new ProfileSkillsFragment();
                        FragmentTransaction fto = getFragmentManager().beginTransaction();

                        fto.replace(R.id.content_frame, fr);
                        fto.addToBackStack(null);
                        fto.commit();
                    }
                });

                personalInfoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Fragment fr = new ProfilePersonalFragment();
                        FragmentTransaction fto = getFragmentManager().beginTransaction();

                        fto.replace(R.id.content_frame, fr);
                        fto.addToBackStack(null);
                        fto.commit();
                    }
                });

                linkedinBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Fragment fr = new ProfileLinkedinFragment();
                        FragmentTransaction fto = getFragmentManager().beginTransaction();

                        fto.replace(R.id.content_frame, fr);
                        fto.addToBackStack(null);
                        fto.commit();
                    }
                });

                cvBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Fragment fr = new ProfileCvFragment();
                        FragmentTransaction fto = getFragmentManager().beginTransaction();

                        fto.replace(R.id.content_frame, fr);
                        fto.addToBackStack(null);
                        fto.commit();
                    }
                });

                break;
            default:
                rootView = inflater.inflate(R.layout.profile_cv_main, container, false);
                break;
        }

        return rootView;
    }

}
