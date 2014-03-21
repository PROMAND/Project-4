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

        View view = inflater.inflate(R.layout.events_main_view, container, false);
        Log.v("pl.byd.wsg.promand.project4", "View inflated");


        getResources().getStringArray(R.array.experiences);
        return view;
    }
    static final int DATE_DIALOG_ID = 0;
    static final int PICK_DATE_REQUEST = 1;
    public void onViewCreated(View view, Bundle savedInstanceState){


               Calendar today = Calendar.getInstance();
               Uri uriCalendar = Uri.parse("content://com.android.calendar/time/" + String.valueOf(today.getTimeInMillis()));
               Intent intentCalendar = new Intent(Intent.ACTION_VIEW,uriCalendar);
                //Use the native calendar app to view the date

                //startActivity(intentCalendar);
//        DatePicker dp = (DatePicker)view.findViewById(R.id.datePicker1);
//        Intent intent = new Intent(view.getContext(),CalendarView.class);

        //intent.putExtra("date", dp.getYear()+"-"+dp.getMonth()+"-"+dp.getDayOfMonth());
        //startActivityForResult();
        super.onViewCreated(view, savedInstanceState);

    }

}
