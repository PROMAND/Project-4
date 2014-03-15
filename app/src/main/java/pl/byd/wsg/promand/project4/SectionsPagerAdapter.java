package pl.byd.wsg.promand.project4;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * A {@link android.support.v13.app.FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    Activity activity;
    public SectionsPagerAdapter(FragmentManager fm, Activity activity) {
        super(fm);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a ViewPagerPlaceholderFragment (defined as a static inner class below).
        return ViewPagerPlaceholderFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();

        switch (position) {
            case 0:
                return activity.getString(R.string.title_section1).toUpperCase(l);
            case 1:
                return activity.getString(R.string.title_section2).toUpperCase(l);
            case 2:
                return activity.getString(R.string.title_section3).toUpperCase(l);
            case 3:
                return activity.getString(R.string.title_section4).toUpperCase(l);
        }
        return null;
    }
}

