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
public class ProfilePreviewCvFragment extends Fragment {

    public ProfilePreviewCvFragment(ActionBar.Tab tab)
    {
        this.tab = tab;
    }
    ActionBar.Tab tab;
    private MyCareerUserDao datasource;
    private LinkedInReaderDao datasourceLinkedin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_cv_preview, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        datasourceLinkedin = new LinkedInReaderDao(getActivity());
        datasourceLinkedin.open();

        int count = datasourceLinkedin.getCount();

        TextView textView = (TextView)view.findViewById(R.id.textView_cv_preview);
        if(count > 0)
        {
            LinkedInReader linkedin = datasourceLinkedin.getLinkedinReader();
            textView.setText(linkedin.toString());
        }
        else {
            datasource = new MyCareerUserDao(getActivity());
            datasource.open();

            MyCareerUser myUser = datasource.getUser();
            textView.setText(myUser.toString());
        }
    }

    //Button click - to replace current fragment with new one
//    public void btnClick(Fragment fragment)
//    {
//        Fragment fr = fragment;
//        FragmentTransaction fto = getFragmentManager().beginTransaction();
//
//        tab.setTabListener(new MyTabsListener(fr));
//
//        fto.replace(R.id.fragment_container, fr);
//        fto.addToBackStack(null);
//        fto.commit();
//    }
}