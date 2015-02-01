package project.talktodeaf.main;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cengalabs.flatui.views.FlatButton;

import project.talktodeaf.Model.Example;
import project.talktodeaf.Rest.ApiService;
import retrofit.RestAdapter;


public class MainActivity extends ActionBarActivity {
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;
    FlatButton btnAction,btnSpeak,btnGame,btnInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAction = (FlatButton)findViewById(R.id.btn_action);
        btnSpeak = (FlatButton)findViewById(R.id.btn_speak);
        btnGame = (FlatButton)findViewById(R.id.btn_game);
        btnInfo = (FlatButton)findViewById(R.id.btn_info);

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent action = new Intent(MainActivity.this, ActivityAction.class);
                startActivity(action);
            }
        });
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent speak = new Intent(MainActivity.this, ActivitySpeak.class);
                startActivity(speak);
            }
        });
        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(MainActivity.this, ActivityGame.class);
                startActivity(game);
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info = new Intent(MainActivity.this, ActivityInformation.class);
                startActivity(info);
            }
        });
        new HttpAsyncTask().execute();
    }
    public class HttpAsyncTask extends AsyncTask<Void, Void, Example> {
        @Override
        protected Example doInBackground(Void... params) {

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint("http://192.168.46.1:80")
                    .build();

            ApiService retrofit = restAdapter.create(ApiService.class);
            Example example = retrofit.getExample();

            return example;
        }

        @Override
        protected void onPostExecute(Example example) {

            Toast.makeText(getApplicationContext(),
                    "Name : " + example.getName_voc() + " URL : " + example.getDes_voc(),
                    Toast.LENGTH_LONG).show();
            super.onPostExecute(example);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "Press again to Exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }

}
