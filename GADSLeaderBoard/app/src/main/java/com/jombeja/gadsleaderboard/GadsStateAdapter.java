package com.jombeja.gadsleaderboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class GadsStateAdapter extends FragmentStateAdapter {


    public GadsStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragmentLearning = new LearningFragment();
        Fragment fragmentskilliq = new SkillIqFragment();
        switch (position){
            case 0:
                return fragmentLearning;
            default:
                return fragmentskilliq;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
