package pl.byd.wsg.promand.project4;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.StrictMode;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.oauth.LinkedInAccessToken;
import com.google.code.linkedinapi.schema.Person;

import java.util.EnumSet;

/**
 * Created by Paladin on 3/20/14.
 */
public class LinkedinConnection
{
    public static String LINKEDIN_CONSUMER_KEY = "75bvl5uwz25stv";
    public static String LINKEDIN_CONSUMER_SECRET = "5iDLzOlllSGIqq3s";
    public static String scopeParams = "r_fullprofile";

    public static String OAUTH_CALLBACK_SCHEME = "x-oauthflow-linkedin";
    public static String OAUTH_CALLBACK_HOST = "callback";
    public static String OAUTH_CALLBACK_URL = OAUTH_CALLBACK_SCHEME + "://" + OAUTH_CALLBACK_HOST;

    private final LinkedInApiClientFactory factory = LinkedInApiClientFactory
            .newInstance(LINKEDIN_CONSUMER_KEY,
                    LINKEDIN_CONSUMER_SECRET);

    private LinkedInAccessToken accessToken = null;
    private LinkedInApiClient client;
    private Activity activity;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public LinkedinConnection(Activity activity)
    {
        this.activity = activity;
        if( Build.VERSION.SDK_INT >= 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        linkedInLogin();
    }




    private void linkedInLogin()
    {
        ProgressDialog progressDialog = new ProgressDialog(
                activity);

        LinkedinDialog d = new LinkedinDialog(activity,
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
//                    MyCareerUser dataInput = new MyCareerUser();

                    DataFromLinkedin dataFromLinkedin = new DataFromLinkedin();

                    dataFromLinkedin.setFirstName(test.getFirstName().toString());
                    dataFromLinkedin.setLastName(test.getLastName().toString());
                    dataFromLinkedin.setInterests(test.getInterests().toString());
                    dataFromLinkedin.setEducation(test.getEducations().toString());
                    dataFromLinkedin.setDateOfBirth(test.getDateOfBirth().toString());
                    dataFromLinkedin.setCertifications(test.getCertifications().toString());
                    dataFromLinkedin.setIndusty(test.getIndustry());
                    dataFromLinkedin.setLanguages(test.getLanguages().toString());
                    dataFromLinkedin.setMainAddress(test.getMainAddress());
                    dataFromLinkedin.setSkills(test.getSkills().toString());
                    dataFromLinkedin.setSpecialities(test.getSpecialties().toString());

                    LinkedInDao linkedInDao = new LinkedInDao(activity);
                    linkedInDao.updateLinkedin(dataFromLinkedin);

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

