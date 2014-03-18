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
 * Created by Paladin on 3/18/14.
 */
public class JustAFragment extends Fragment
{
    public JustAFragment(ActionBar.Tab tab)
    {
        this.tab = tab;
    }
    ActionBar.Tab tab;


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
