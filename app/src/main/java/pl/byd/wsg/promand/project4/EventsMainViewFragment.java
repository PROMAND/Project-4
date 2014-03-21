package pl.byd.wsg.promand.project4;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

/**
 * Created by mesfint on 3/16/14.
 */
public class EventsMainViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Calendar today = Calendar.getInstance();
        Uri uriCalendar = Uri.parse("content://com.android.calendar/time/" + String.valueOf(today.getTimeInMillis()));
        Intent intentCalendar = new Intent(Intent.ACTION_VIEW,uriCalendar);
         //Use the native calendar app to view the date
          startActivity(intentCalendar);
        View view = inflater.inflate(R.layout.events_main_view, container, false);

        getResources().getStringArray(R.array.experiences);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

    }

}
