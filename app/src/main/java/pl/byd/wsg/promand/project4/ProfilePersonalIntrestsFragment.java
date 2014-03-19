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
public class ProfilePersonalIntrestsFragment extends JustAFragment {

    public ProfilePersonalIntrestsFragment(ActionBar.Tab tab)
    {
        super(tab);
    }
    private MyCareerUserDao datasource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_personal_interests, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        datasource = new MyCareerUserDao(getActivity());
        datasource.open();

        final MyCareerUser myUser = datasource.getUser();

        final TextView textView = (TextView)view.findViewById(R.id.textView_interests_area);
        Button backBtn = (Button)view.findViewById(R.id.btn_back_interests);
        Button okBtn = (Button)view.findViewById(R.id.btn_interests_ok);
        Button cancelBtn = (Button)view.findViewById(R.id.btn_interests_cancel);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfilePersonalMainViewFragment(tab));
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //btnClick(new ProfilePersonalMainViewFragment(tab));
                myUser.setInterests(textView.getText().toString());
                datasource.updateUser(myUser);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfilePersonalMainViewFragment(tab));
            }
        });

        if(!myUser.getInterests().equalsIgnoreCase("")){
            textView.setText(myUser.getInterests());
        }
        else {
            textView.setHint("Here I will describe my personal intrests");
        }

    }

}