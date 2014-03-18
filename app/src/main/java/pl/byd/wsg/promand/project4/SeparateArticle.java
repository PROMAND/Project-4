package pl.byd.wsg.promand.project4;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Paladin on 3/18/14.
 */
public class SeparateArticle extends SeparateArticleTemplate
{
    public SeparateArticle(String ourText,ActionBar.Tab tab)
    {
        super(ourText,tab);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button sendToFriend = (Button)view.findViewById(R.id.button);

        sendToFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity pas = getActivity();
                new SendToFriend(pas);
            }
        });

    }


}
