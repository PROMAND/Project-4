package pl.byd.wsg.promand.project4;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Paladin on 3/18/14.
 */
public class SeparateArticle extends SeparateArticleTemplate
{
    public SeparateArticle(String ourText,ActionBar.Tab tab)
    {
        super(ourText,tab);
    }
    private SeparateArticle badSolution = this;




    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        Button sendToFriend = (Button)view.findViewById(R.id.button);

        sendToFriend.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                btnClick(new SendToFriend(tab,ourText, badSolution));
            }
        });

    }


}
