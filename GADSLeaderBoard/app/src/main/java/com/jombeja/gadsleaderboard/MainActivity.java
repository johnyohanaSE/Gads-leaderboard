package com.jombeja.gadsleaderboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {


    private ViewPager2 mViewPager2;
    private TabLayout mTabLayout;
    private TabLayoutMediator mTabLayoutMediator;
    private Toolbar mToolbar;
    private TextView mTitle;
    private Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar_main);
        mViewPager2 = findViewById(R.id.viewpager);
        mTitle = findViewById(R.id.text_toolbar_label);
        mViewPager2.setAdapter(new GadsStateAdapter(this));
        mTabLayout = findViewById(R.id.tabs);
        mTabLayoutMediator = new TabLayoutMediator(
                mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:{
                        tab.setText("LEARNING LEADERS");
                        break;
                    }
                    case 1:{
                        tab.setText("SKILL IQ LEADERS");
                        break;
                    }
                }
            }
        });
        mTabLayoutMediator.attach();
        switchTosubmit();
    }

    private void switchTosubmit() {
        mSubmit = findViewById(R.id.btn_submit_activity);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSwitch = new Intent(MainActivity.this, SubmitActivity.class);
                startActivity(intentSwitch);
            }
        });

    }

}