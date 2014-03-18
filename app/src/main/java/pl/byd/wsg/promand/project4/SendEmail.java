package pl.byd.wsg.promand.project4;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by Paladin on 3/18/14.
 */
public class SendEmail
{
    public SendEmail(Activity activity,String message)
    {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
}
