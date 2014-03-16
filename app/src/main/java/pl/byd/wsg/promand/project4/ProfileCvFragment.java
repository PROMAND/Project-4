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
public class ProfileCvFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile_cv_main, container, false);
        Log.v("pl.byd.wsg.promand.project4", "View inflated");
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Button back = (Button)view.findViewById(R.id.btn_back_profile_cv_main);
        Button preview = (Button)view.findViewById(R.id.btn_cv_main_preview);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileFragment());
            }
        });

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileCvPreviewFragment());
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