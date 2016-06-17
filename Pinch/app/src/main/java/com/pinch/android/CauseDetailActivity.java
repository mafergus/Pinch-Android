package com.pinch.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.pinch.android.model.Cause;
import com.squareup.picasso.Picasso;

/**
 * Created by matthewferguson on 6/16/16.
 */

public class CauseDetailActivity extends AppCompatActivity {

    private ImageView leadingImage;
    private TextView title;
    private ImageView charityImage;
    private TextView charityName;
    private TextView daysRemaining;
    private TextView missionsCount;
    private TextView moneyRaised;

    private Button donateButton;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CausePagerAdapter causePagerAdapter;

    private Cause cause;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cause_detail);

        this.leadingImage = (ImageView)findViewById(R.id.leadingImage);
        this.title = (TextView)findViewById(R.id.title);
        this.charityImage = (ImageView)findViewById(R.id.charityImage);
        this.charityName = (TextView)findViewById(R.id.charityName);
        this.daysRemaining = (TextView)findViewById(R.id.remaining);
        this.missionsCount = (TextView)findViewById(R.id.missions);
        this.moneyRaised = (TextView)findViewById(R.id.raised);
        this.donateButton = (Button)findViewById(R.id.donateButton);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        causePagerAdapter = new CausePagerAdapter();
        viewPager.setAdapter(causePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            Bundle bundle = intent.getExtras();
            String causeJson = bundle.getString("cause");
            cause = new GsonBuilder().create().fromJson(causeJson, Cause.class);
            populate();
        }
    }

    private void populate() {
        Picasso.with(this).load(cause.leadingImage).into(this.leadingImage);
        this.title.setText(cause.title);
        Picasso.with(this).load(cause.charityImage).into(this.charityImage);
        this.charityName.setText(cause.charityName);
        this.daysRemaining.setText("6");
        this.missionsCount.setText("" + 1);
        this.moneyRaised.setText("" + cause.progressAmount);
    }

    public static class CausePagerAdapter extends PagerAdapter {

//        private List<String> titles = new ArrayList<String>();

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }
    }
}
