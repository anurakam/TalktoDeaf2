package project.talktodeaf.main;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import project.talktodeaf.ui.GameWordPagerAdapter;

public class ActivityWordGame extends ActionBarActivity {

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_word_game);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new GameWordPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

    }
}