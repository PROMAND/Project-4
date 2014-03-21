package pl.byd.wsg.promand.project4;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by mesfint on 3/18/14.
 */
public class JobOfficeDetails extends SeparateArticle {
    private SeparateArticle prieviousArticle = this;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public JobOfficeDetails(String ourText,ActionBar.Tab tab) {super(ourText,tab);
    }
   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.job_office_details, container, false);

    }*/

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // TextView textView = (TextView)view.findViewById(R.id.jobDetail);
        //textView.setText(ourText);
        ImageButton sendToFreind = (ImageButton) view.findViewById(R.id.button);

        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_BACK)
                {
                    getFragmentManager().popBackStack();
                }
                return false;
            }
        });
        sendToFreind.setOnClickListener(new View.OnClickListener() {



            @Override

            public void onClick(View v) {
                btnClick(new SendToFriend(tab,ourText));
            }

        });{

        }
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
