package pl.byd.wsg.promand.project4;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Marika on 14.03.14.
 */
public class ProfileSkillsExperiencesFragment extends Fragment {

    MyCustomAdapter dataAdapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_skills_experiences, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //Buttons
        Button backBtn = (Button) view.findViewById(R.id.btn_back_experience);
        Button cancelBtn = (Button)view.findViewById(R.id.btn_experience_cancel);

        //Button onClick methods
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileSkillsMainViewFragment());
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileSkillsMainViewFragment());
            }
        });

        //OK button method
        checkButtonClick(view);

        // Generate data for experiences list
        displayListView(view);
    }

    //Button click - to replace current fragment with new one
    public void btnClick(Fragment fragment)
    {
        Fragment fr = fragment;
        FragmentTransaction fto = getFragmentManager().beginTransaction();

        fto.replace(R.id.fragment_container, fr);
        fto.addToBackStack(null);
        fto.commit();
    }

    //Example from http://developerandro.blogspot.com/2013/09/listview-with-checkbox-android-example.html
    private void displayListView(View view) {
        // Array list of experiences
        ArrayList<ExperienceClass> experienceList = new ArrayList<ExperienceClass>();

        //Fill the list
        ExperienceClass _states = new ExperienceClass(1, "programming", false);
        experienceList.add(_states);
        _states = new ExperienceClass(2, "skiing", true);
        experienceList.add(_states);
        _states = new ExperienceClass(3, "cooking", false);
        experienceList.add(_states);
        _states = new ExperienceClass(4, "fishing", true);
        experienceList.add(_states);
        _states = new ExperienceClass(5, "sleeping", true);
        experienceList.add(_states);

        // create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this.getActivity(), R.layout.profile_skills_experience_item, experienceList);
        ListView listView = (ListView)view.findViewById(R.id.listView_experiences);

        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

        // Set onClick listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                //ExperienceClass experienceClass = (ExperienceClass) parent.getItemAtPosition(position);
            }
        });
    }

    private class MyCustomAdapter extends ArrayAdapter<ExperienceClass> {

        private ArrayList<ExperienceClass> experienceList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<ExperienceClass> experienceList) {

            super(context, textViewResourceId, experienceList);
            this.experienceList = new ArrayList<ExperienceClass>();
            this.experienceList.addAll(experienceList);
        }

        private class ViewHolder {
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.profile_skills_experience_item, null);
                holder = new ViewHolder();
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox_experience_item);

                convertView.setTag(holder);
                holder.name.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        ExperienceClass _experience = (ExperienceClass) cb.getTag();
                        _experience.setSelected(cb.isChecked());
                    }
                });
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            ExperienceClass experience = experienceList.get(position);
            holder.name.setText(experience.getName());
            holder.name.setChecked(experience.isSelected());
            holder.name.setTag(experience);

            return convertView;
        }
    }

    //OK button shows selected items
    private void checkButtonClick(View view) {
        Button okBtn = (Button)view.findViewById(R.id.btn_experience_ok);
        okBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                StringBuffer responseText = new StringBuffer();
                responseText.append("Selected Experiences are...\n");
                ArrayList<ExperienceClass> experienceList = dataAdapter.experienceList;

                for (int i = 0; i < experienceList.size(); i++) {
                    ExperienceClass experience = experienceList.get(i);
                    if (experience.isSelected()) {
                        responseText.append("\n" + experience.getName());
                    }
                }
                Toast.makeText(getActivity(), responseText,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
