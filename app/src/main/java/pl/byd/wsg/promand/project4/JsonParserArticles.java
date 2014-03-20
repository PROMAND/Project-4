package pl.byd.wsg.promand.project4;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * Created by Paladin on 3/19/14.
 */
public class JsonParserArticles extends AsyncTask<String, Void, JSONResponseArticles>
{
    private Exception exception;
    private ArticlesMainViewFragment articlesMainViewFragment;
    public JsonParserArticles(ArticlesMainViewFragment articlesMainViewFragment)
    {
            this.articlesMainViewFragment = articlesMainViewFragment;
            final String url = "http://team-4.site11.com/index.php?api_key=4dbdb6281eda089ac926b65179ff4c29e417f6ec&action=getArticles";
            this.execute(url);
    }

    @Override
    protected JSONResponseArticles doInBackground(String... params) {
        try {
            InputStream source = null;

            // fetch the data from the URL
            HttpResponse reply = new DefaultHttpClient().execute(new HttpGet(params[0]));

            // determine the HTTP status code
            final int replyStatus = reply.getStatusLine().getStatusCode();

            // we got an error back from the server or maybe the connection is down
            if (replyStatus != HttpStatus.SC_OK) {
                exception = new Exception("HTTP");
                return null;
            }

            // if the HTTP request was successful
            // get the contents of the reply
            source = reply.getEntity().getContent();

            // read the JSON string that came as a reply
            Reader reader = new InputStreamReader(source);

            // our JSON helper parser instance reads the string
            // formatting it to our Java equivalent
            return new Gson().fromJson(reader, JSONResponseArticles.class);
        } catch (Exception e) {
            this.exception = e;
            return null;
        }    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Toast.makeText(Welcome.this, "Loading screen mb", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(JSONResponseArticles jsonResponse) {
       // Toast.makeText(Welcome.this, "Finished Async", Toast.LENGTH_SHORT).show();

        if (exception != null) {
            // dont set text
        }

        // creating a list of all Geonames found
        parsedResults = jsonResponse.data;

        // for each geoname let's toast the name
        for (JSONGArticles result : parsedResults) {
            //Toast.makeText(Welcome.this, result.DESCRIPTION, Toast.LENGTH_SHORT).show();
            articlesMainViewFragment.updateList(result.NAME,result.DESCRIPTION); // bad solution map should be implemented
        }

        // then finally print out how many geonames we got
        //target.setText("Found " + parsedResults.size() + " results")
    }
    private List<JSONGArticles> parsedResults;
    public List<JSONGArticles> getResults()
    {
        return parsedResults;
    }
}
