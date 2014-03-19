package pl.byd.wsg.promand.project4;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.schema.Person;

import java.util.EnumSet;

/**
 * Created by Marika on 17.03.14.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ProfileLinkedinFragment extends JustAFragment {

    final LinkedInApiClientFactory factory = LinkedInApiClientFactory
            .newInstance(Config.LINKEDIN_CONSUMER_KEY,
                    Config.LINKEDIN_CONSUMER_SECRET);

    LinkedInAccessToken accessToken = null;
    LinkedInApiClient client;

    public ProfileLinkedinFragment(ActionBar.Tab tab)
    {
        super(tab);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_linked_in, container, false);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        Button linkedInBackBtn = (Button) view.findViewById(R.id.btn_back_linked_in);

        Button connect = (Button)view.findViewById(R.id.btn_linked_in_done);

        if( Build.VERSION.SDK_INT >= 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkedInLogin();
            }
        });

        linkedInBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnClick(new ProfileMainViewFragment(tab));
            }
        });

    }

    private void linkedInLogin()
    {
        ProgressDialog progressDialog = new ProgressDialog(
                getActivity());

        LinkedinDialog d = new LinkedinDialog(getActivity(),
                progressDialog);
        d.show();
        d.setVerifierListener(new LinkedinDialog.OnVerifyListener() {


            @Override
            public void onVerify(String verifier) {
                try {
                    accessToken = LinkedinDialog.oAuthService
                            .getOAuthAccessToken(LinkedinDialog.liToken,
                                    verifier);
                    LinkedinDialog.factory.createLinkedInApiClient(accessToken);
                    client = factory.createLinkedInApiClient(accessToken);
                    Person test = client.getProfileForCurrentUser(EnumSet.allOf(ProfileField.class));
                    test.getEducations();

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.show();
    }
}