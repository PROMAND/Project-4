package pl.byd.wsg.promand.project4;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Paladin on 3/18/14.
 */
public class SendToFriend extends JustAFragment{

    private SeparateArticle prieviousArticle;
    public SendToFriend(ActionBar.Tab tab,SeparateArticle article) {
        super(tab);
        this.prieviousArticle = article;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.send_to_friend_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button back = (Button)view.findViewById(R.id.btn_back_send_to_friend);
        Button attachment = (Button)view.findViewById(R.id.btn_attach_send_to_friend);
        Button send  = (Button)view.findViewById(R.id.btn_send_send_to_friend);
        final EditText textToFriend = (EditText)view.findViewById(R.id.txtView_send_to_friend);

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

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SendEmail(getActivity(),textToFriend.getText().toString());

            }
        });
    }
}
