package project.talktodeaf.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.cengalabs.flatui.views.FlatButton;

import project.talktodeaf.Information.BookInfo;
import project.talktodeaf.Information.PlaceInfo;

/**
 * Created by wiwat on 1/30/2015.
 */
public class ActivityInformation extends ActionBarActivity {
    FlatButton btnbookinfo,btnplaceinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        btnbookinfo = (FlatButton)findViewById(R.id.btn_book);
        btnplaceinfo = (FlatButton)findViewById(R.id.btn_place);
        btnbookinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookinfo = new Intent(ActivityInformation.this, BookInfo.class);
                startActivity(bookinfo);
            }
        });
        btnplaceinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent placeinfo = new Intent(ActivityInformation.this, PlaceInfo.class);
                startActivity(placeinfo);
            }
        });

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



}
