package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tablayout.fragments.callfragment;
import com.example.tablayout.fragments.chatsfragment;
import com.example.tablayout.fragments.statusfragment;

public class MyviewpagerAdapter extends FragmentStateAdapter {
    public MyviewpagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new chatsfragment();
            case 1:
                return new statusfragment();
            case 2:
                return new callfragment();
            default:
                return new chatsfragment();


        }
    }

    @Override
    public int getItemCount() {

        return 3;
    }
}
