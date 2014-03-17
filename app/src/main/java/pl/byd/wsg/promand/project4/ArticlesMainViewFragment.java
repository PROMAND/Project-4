package pl.byd.wsg.promand.project4;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mesfint on 3/16/14.
 */
public class ArticlesMainViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.articles_main_view, container, false);
        Log.v("pl.byd.wsg.promand.project4", "View inflated");

        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        ListView listView = (ListView) view.findViewById(R.id.list_articles);

        //Sample data for articles list
        ArrayList<String> list = new ArrayList<String>();
        list.add("How to create CV");
        list.add("How to prepare for interview");
        list.add("How to dress");
        list.add("How to apply for a job");

        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                //displayDetailsPlacesFragment(position);


                String item = ((TextView) view).getText().toString();

                //Toast.makeText(getActivity(), item, Toast.LENGTH_LONG).show();


            }
        });

    }
}
