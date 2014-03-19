package pl.byd.wsg.promand.project4;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mesfint on 3/16/14.
 */
public class JobOfficeMainViewFragment extends JustAFragment implements AdapterView.OnItemClickListener {

    public JobOfficeMainViewFragment(ActionBar.Tab tab) {
        super(tab);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.job_office_main_view, container, false);
        Log.v("pl.byd.wsg.promand.project4", "View inflated");

        return view;
    }


    public void onViewCreated(View view, Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);
        ListView listView = (ListView)view.findViewById(R.id.listView_job_office);

        //Sample data for articles list
        ArrayList<String> list = new ArrayList<String>();
        list.add("Administrator needed!");
        list.add("Job for prgogrammer");
        list.add("Looking for IT specialist");
        list.add("IT management offer");

        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list));
        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        JobOfficeDetails newDetail = new JobOfficeDetails(parent.getItemAtPosition(position).toString(),tab);
        btnClick(newDetail);

    }
}
