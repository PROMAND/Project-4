package pl.byd.wsg.promand.project4;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    public static Context appContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar gets initiated
        ActionBar actionbar = getActionBar();

        //Tell the ActionBar we want to use Tabs.
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //initiating both tabs and set text to it.
        ActionBar.Tab ProfileTab = actionbar.newTab().setText("Profile");
        ActionBar.Tab JobOfficeTab = actionbar.newTab().setText("Job Office");
        ActionBar.Tab ArticlesTab = actionbar.newTab().setText("Articles");
        ActionBar.Tab EventsTab = actionbar.newTab().setText("Events");

        //create the two fragments we want to use for display content
        Fragment ProfileMainViewFragment = new ProfileMainViewFragment(ProfileTab);
        Fragment JobOfficeMainViewFragment = new JobOfficeMainViewFragment(JobOfficeTab);
        Fragment ArticlesMainViewFragment = new ArticlesMainViewFragment(ArticlesTab);
        Fragment EventsMainViewFragment = new EventsMainViewFragment();

        //set the Tab listener. Now we can listen for clicks.
        ProfileTab.setTabListener(new MyTabsListener(ProfileMainViewFragment));
        JobOfficeTab.setTabListener(new MyTabsListener(JobOfficeMainViewFragment));
        ArticlesTab.setTabListener(new MyTabsListener(ArticlesMainViewFragment));
        EventsTab.setTabListener(new MyTabsListener(EventsMainViewFragment));

        //add the two tabs to the actionbar
        actionbar.addTab(ProfileTab);
        actionbar.addTab(JobOfficeTab);
        actionbar.addTab(ArticlesTab);
        actionbar.addTab(EventsTab);


    }
}
