package pl.byd.wsg.promand.project4;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by mesfint on 3/16/14.
 */
public class ArticleListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(
          //      inflater.getContext(),android.R.layout.simple_list_item_1,list));




        View view = inflater.inflate(R.layout.articles_main_view, container, false);
        Log.v("pl.byd.wsg.promand.project4", "View inflated");

        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){

        super.onViewCreated(view, savedInstanceState);

       // Button okBtn = (Button)view.findViewById(R.id.list_item);


        ListView listView = (ListView)view.findViewById(R.id.list_item);
        //Sample data for experiences list



        ArrayList<String> list = new ArrayList<String>();



        list.add("programming");
        list.add("cooking");
        list.add("fishing");
        list.add("sleeping");

        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list));


    }
    //Button click - to replace current fragment with new one

}
