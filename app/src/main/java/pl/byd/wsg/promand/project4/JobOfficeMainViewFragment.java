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
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

       final SearchView search = (SearchView) view.findViewById(R.id.editText_job_office_search);
        listView = (ListView)view.findViewById(R.id.listView_job_office);

        //Sample data for articles list
        listOfTitles = new ArrayList<String>();
        listOfArticles = new ArrayList<String>();
        listOfEmail = new ArrayList<String>();
        JsonParserJobs jsonParserJobs = new JsonParserJobs(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (search.getQuery().toString() != null) {
                    ArrayList<Integer> results = search(search.getQuery().toString());
                    resultList = new ArrayList<String>();
                    for (Integer i : results) {
                        resultList.add(listOfTitles.get(i));
                        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, resultList));
                    }


                    //  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>()
                }
                return false;
            }
        });

    }
    private ArrayList<String> listOfTitles;
    private ArrayList<String> listOfArticles;
    private ArrayList<String> listOfEmail;
    private ListView listView ;
    private ArrayList<String> resultList;

    private ArrayList<Integer> search(String searchQuiery) {

//        ArrayList<String> data = new ArrayList<String>();
       // ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
       ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i != listOfTitles.size(); i++) {

            Pattern pattern = Pattern.compile(searchQuiery.toLowerCase());
            Matcher matcher = pattern.matcher(listOfTitles.get(i).toLowerCase());
            boolean matches = matcher.matches();

            if (matches) {
                result.add(i);
            }
        }
        return result;
    }

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
