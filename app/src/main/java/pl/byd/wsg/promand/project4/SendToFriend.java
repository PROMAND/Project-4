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
import android.widget.Toast;

import java.text.BreakIterator;

import static android.os.Message.*;

/**
 * Created by Paladin on 3/18/14.
 */
public class SendToFriend extends JustAFragment implements AdapterView.OnClickListener{

    private SeparateArticle prieviousArticle;
    private View root;


    String artic;
    public SendToFriend(ActionBar.Tab tab, String article, SeparateArticle prieviousArticle) {
        super(tab);
        this.artic=article;
        this.prieviousArticle = prieviousArticle;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.send_to_friend_view, container, false);
        return root;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText to = (EditText)view.findViewById(R.id.editTextTo);
        EditText subject = (EditText)view.findViewById(R.id.editTextSub);
         EditText message = (EditText)view.findViewById(R.id.editTextMessage);
        message.setText(artic);
        Button back = (Button)view.findViewById(R.id.btn_back_send_to_friend);
        Button attachment = (Button)view.findViewById(R.id.btn_attach_send_to_friend);
        Button emailSend  = (Button)view.findViewById(R.id.emailSend);
        final EditText textToFriend = (EditText)view.findViewById(R.id.editTextMessage);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(prieviousArticle);
            }
        });

        attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Attachment(getActivity());
            }
        });

        emailSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText subject = (EditText) root.findViewById(R.id.editTextSub);
                EditText message = (EditText) root.findViewById(R.id.editTextMessage);



                String to = "mesfin2006@gmail.com";
                String subj = subject.getText().toString();
                String mess = message.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);

                email.setType("message/rfc822");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subj);
                email.putExtra(Intent.EXTRA_TEXT, mess);

                //need this to prompts email client only


                startActivity(Intent.createChooser(email, "Choose an Email client :"));


            }
        });
    }

     @Override
    public void onClick(View v) {



    }
}
