package pl.byd.wsg.promand.project4;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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

        EditText search = (EditText) view.findViewById(R.id.editText_job_office_search);
        search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                v.setText("different");
                return false;
            }
        });
         listView = (ListView)view.findViewById(R.id.listView_job_office);

        //Sample data for articles list
         listOfTitles = new ArrayList<String>();
        listOfArticles = new ArrayList<String>();
        listOfEmail = new ArrayList<String>();
        JsonParserJobs jsonParserJobs = new JsonParserJobs(this);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listOfTitles));
        listView.setOnItemClickListener(this);

    }
    ArrayList<String> listOfTitles;
    ArrayList<String> listOfArticles;
    ArrayList<String> listOfEmail;
    ListView listView ;
    public void updateList(String title,String article,String email)
    {
        listOfEmail.add(email);
        listOfArticles.add(article);
        listOfTitles.add(title);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listOfTitles));
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        JobOfficeDetails newDetail = new JobOfficeDetails(listOfArticles.get(position),tab);
        btnClick(newDetail);

    }
}
