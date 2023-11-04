package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.net.SocketKeepalive;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;

import com.google.android.material.tabs.TabLayout;

import javax.security.auth.callback.Callback;

public class MainActivity extends AppCompatActivity {
 TabLayout tabLayout;
 ViewPager2 viewPager2;
 MyviewpagerAdapter myviewpagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        myviewpagerAdapter = new MyviewpagerAdapter(this);
        viewPager2.setAdapter(myviewpagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

            }
        }
