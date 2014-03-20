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
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mesfint on 3/16/14.
 */
public class ArticlesMainViewFragment extends JustAFragment implements ListView.OnItemClickListener{

    public ArticlesMainViewFragment(ActionBar.Tab tab) {
        super(tab);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.articles_main_view, container, false);
        Log.v("pl.byd.wsg.promand.project4", "View inflated");

        return view;
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.list_articles);
        SearchView searchView = (SearchView) view.findViewById(R.id.editText_articles_search);

        //Sample data for articles list
        listOfTitles = new ArrayList<String>();
        listOfArticles = new ArrayList<String>();

        new JsonParserArticles(this);


        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listOfTitles));
        listView.setOnItemClickListener(this);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null) {
                    ArrayList<Integer> results = search(newText);
                    resultList = new ArrayList<String>();
                    for (Integer i : results) {
                        resultList.add(listOfTitles.get(i.intValue()));
                        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, resultList));
                    }
                }
                return false;
            }
        });
    }
    private ArrayList<Integer> search(String searchQuiery) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i != listOfTitles.size(); i++) {

            if (listOfTitles.get(i).toLowerCase().contains(searchQuiery.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    ArrayList<String> listOfTitles;
    ArrayList<String> listOfArticles;
    ListView listView ;
    private ArrayList<String> resultList;
    public void updateList(String title,String article)
    {
        listOfArticles.add(article);
        listOfTitles.add(title);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listOfTitles));
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        super.btnClick(new SeparateArticle(listOfArticles.get(position), super.tab));
    }
}
