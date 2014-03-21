package pl.byd.wsg.promand.project4;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.BreakIterator;

import static android.os.Message.*;

/**
 * Created by Paladin on 3/18/14.
 */
public class SendToFriend extends JustAFragment implements AdapterView.OnClickListener{

    private View root;

    String artic;
    public SendToFriend(ActionBar.Tab tab, String article) {
        super(tab);
        this.artic=article;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.send_to_friend_view, container, false);
        return root;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       final EditText toWhom = (EditText)view.findViewById(R.id.editTextTo);
         EditText message = (EditText)view.findViewById(R.id.editTextMessage);
        message.setText(artic);
        ImageButton emailSend  = (ImageButton) view.findViewById(R.id.emailSend);

        emailSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText subject = (EditText) root.findViewById(R.id.editTextSub);
                EditText message = (EditText) root.findViewById(R.id.editTextMessage);
                Intent email = new Intent(Intent.ACTION_SEND);

                try {
                    String to = toWhom.getText().toString();
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});

                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(),"Please Provide email address",Toast.LENGTH_SHORT).show();
                }

            try {
                String subj = subject.getText().toString();
                email.putExtra(Intent.EXTRA_SUBJECT, subj);
            }
            catch (Exception e)
            {}

            try {
                String mess = message.getText().toString();
                email.putExtra(Intent.EXTRA_TEXT, mess);
            }catch (Exception e){
                }



                //need this to prompts email client only
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }

     @Override
    public void onClick(View v) {



    }
}
