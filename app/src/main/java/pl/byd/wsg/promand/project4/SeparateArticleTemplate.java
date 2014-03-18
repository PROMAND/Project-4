package pl.byd.wsg.promand.project4;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Paladin on 3/18/14.
 */
public class SeparateArticleTemplate extends Fragment
{
    String ourText;
    public SeparateArticleTemplate(String ourText) {
        this.ourText = ourText;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.separate_article, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView textView = (TextView)view.findViewById(R.id.article);
        textView.setText(ourText);

        super.onViewCreated(view, savedInstanceState);
    }
}
