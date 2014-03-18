package pl.byd.wsg.promand.project4;

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
    public SeparateArticle(String ourText)
    {
        super(ourText);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button sendToFriend = (Button)view.findViewById(R.id.button);

        sendToFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


}
