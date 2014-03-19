package pl.byd.wsg.promand.project4;

/**
 * Created by Marika on 17.03.14.
 */
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ProfileGeneralInfoFragment extends JustAFragment {
    public ProfileGeneralInfoFragment(ActionBar.Tab tab)
    {
        super(tab);
    }
    private MyCareerUserDao datasource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_general_info, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        datasource = new MyCareerUserDao(getActivity());
        datasource.open();

        if(datasource.getAllUsers().isEmpty())
        {
            MyCareerUser user = createAppUser();
            datasource.createUser(user);
        }

        final MyCareerUser myUser = datasource.getUser();

        final EditText firstName = (EditText)view.findViewById(R.id.editText_my_profile_name);
        final EditText lastName = (EditText)view.findViewById(R.id.editText_my_profile_surname);
        final EditText age = (EditText)view.findViewById(R.id.editText_my_profile_age);
        final EditText gender = (EditText)view.findViewById(R.id.editText_my_profile_gender);

        firstName.setText(myUser.getFirstName());
        lastName.setText(myUser.getLastName());
        age.setText(String.valueOf(myUser.getAge()));
        gender.setText(myUser.getGender());

        Button backBtn = (Button)view.findViewById(R.id.btn_back_profile_general);
        Button doneBtn = (Button)view.findViewById(R.id.btn_my_profile_done);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileMainViewFragment(tab));
            }
        });

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //btnClick(new ProfileMainViewFragment(tab));
                myUser.setFirstName(firstName.getText().toString());
                myUser.setLastName(lastName.getText().toString());
                myUser.setAge(Integer.parseInt(age.getText().toString()));
                myUser.setGender(gender.getText().toString());

                datasource.updateUser(myUser);
            }
        });
    }

    private MyCareerUser createAppUser(){
        MyCareerUser user = new MyCareerUser();
        user.setFirstName("first name");
        user.setLastName("last name");
        user.setAge(0);
        user.setGender("gender");
        user.setTrainings("");
        user.setEducation("");
        user.setInterests("");
        user.setStrongSides("");
        return user;
    }
}
