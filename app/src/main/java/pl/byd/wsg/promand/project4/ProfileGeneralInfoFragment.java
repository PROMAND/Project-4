package pl.byd.wsg.promand.project4;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Marika on 14.03.14.
 */
public class ProfileGeneralInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        View view = inflater.inflate(R.layout.profile_main_view, container, false);
        View view = inflater.inflate(R.layout.send_to_office_view, container, false);
        Log.v("pl.byd.wsg.promand.project4", "View inflated");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("pl.byd.wsg.promand.project4", "Fragment onStart()");

    }
}
