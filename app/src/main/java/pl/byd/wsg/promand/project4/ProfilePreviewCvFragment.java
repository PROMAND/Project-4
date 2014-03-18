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

/**
 * Created by Marika on 17.03.14.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ProfilePreviewCvFragment extends Fragment {

    public ProfilePreviewCvFragment(ActionBar.Tab tab)
    {
        this.tab = tab;
    }
    ActionBar.Tab tab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_cv_preview, container, false);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Button backBtn = (Button) view.findViewById(R.id.btn_back_profile_cv_preview);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileCvMainViewFragment(tab));
            }
        });

    }

    //Button click - to replace current fragment with new one
    public void btnClick(Fragment fragment)
    {
        Fragment fr = fragment;
        FragmentTransaction fto = getFragmentManager().beginTransaction();

        tab.setTabListener(new MyTabsListener(fr));

        fto.replace(R.id.fragment_container, fr);
        fto.addToBackStack(null);
        fto.commit();
    }
}