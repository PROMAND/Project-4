package pl.byd.wsg.promand.project4;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Marika on 14.03.14.
 */
public class ProfilePersonalIntrestsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile_personal_interests, container, false);
        Log.v("pl.byd.wsg.promand.project4", "View inflated");
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Button backBtn = (Button)view.findViewById(R.id.btn_back_interests);
        Button okBtn = (Button)view.findViewById(R.id.btn_interests_ok);
        Button cancelBtn = (Button)view.findViewById(R.id.btn_interests_cancel);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfilePersonalFragment());
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfilePersonalFragment());
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfilePersonalFragment());
            }
        });

        TextView textView = (TextView)view.findViewById(R.id.textView_interests_area);
        textView.setHint("Here I will describe my personal intrests");

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
