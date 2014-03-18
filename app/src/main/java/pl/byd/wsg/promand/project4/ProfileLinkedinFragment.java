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
public class ProfileLinkedinFragment extends JustAFragment {

    public ProfileLinkedinFragment(ActionBar.Tab tab)
    {
        super(tab);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_linked_in, container, false);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Button linkedInBackBtn = (Button) view.findViewById(R.id.btn_back_linked_in);

        linkedInBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileMainViewFragment(tab));
            }
        });

    }

}