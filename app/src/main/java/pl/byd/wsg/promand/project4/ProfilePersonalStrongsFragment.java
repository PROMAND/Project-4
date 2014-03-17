package pl.byd.wsg.promand.project4;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Marika on 14.03.14.
 */
public class ProfilePersonalStrongsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile_personal_strong_sides, container, false);
        Log.v("pl.byd.wsg.promand.project4", "View inflated");
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Button backBtn = (Button)view.findViewById(R.id.btn_back_strong_sides);
        Button okBtn = (Button)view.findViewById(R.id.btn_strong_sides_ok);
        Button cancelBtn = (Button)view.findViewById(R.id.btn_strong_sides_cancel);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfilePersonalMainViewFragment());
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfilePersonalMainViewFragment());
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfilePersonalMainViewFragment());
            }
        });

        TextView textView = (TextView)view.findViewById(R.id.textView_strong_sides_area);
        textView.setHint("Here I will describe my personal strong sides");

    }

    //Button click - to replace current fragment with new one
    public void btnClick(Fragment fragment)
    {
        Fragment fr = fragment;
        FragmentTransaction fto = getFragmentManager().beginTransaction();

        fto.replace(R.id.fragment_container, fr);
        fto.addToBackStack(null);
        fto.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("pl.byd.wsg.promand.project4", "Fragment onStart()");

    }
}
