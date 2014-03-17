package pl.byd.wsg.promand.project4;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.widget.Toast;

/**
 * Created by Marika on 17.03.14.
 */
class MyTabsListener implements ActionBar.TabListener {
    public Fragment fragment;

    public MyTabsListener(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        //Toast.makeText(MainActivity.appContext, "Reselected!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.replace(R.id.fragment_container, fragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft.remove(fragment);
    }

}
