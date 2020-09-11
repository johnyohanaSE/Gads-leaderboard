package com.jombeja.gadsleaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIqFragment extends Fragment {

    private RecyclerView mIqrecyclerView;
    private RecyclerView.LayoutManager mIqLayoutManager;
    ArrayList<SkilliqData> mIqListItems = new ArrayList<>();
    private IqRecyclerAdapter mIqRecyclerAdapter;

    public SkillIqFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill_iq, container, false);
        mIqrecyclerView = view.findViewById(R.id.recycler_skill_iq);
        mIqrecyclerView.setHasFixedSize(true);
        mIqLayoutManager = new LinearLayoutManager(getActivity());
        mIqrecyclerView.setLayoutManager(mIqLayoutManager);

        SkillIqApi skillIqApi = ServiceBuilder.buildservice(SkillIqApi.class);
        Call<List<SkilliqData>> call = skillIqApi.skilliq();
        call.enqueue(new Callback<List<SkilliqData>>() {
            @Override
            public void onResponse(Call<List<SkilliqData>> call, Response<List<SkilliqData>> response) {
                mIqListItems = new ArrayList<>(response.body());
                mIqRecyclerAdapter = new IqRecyclerAdapter(mIqListItems, getActivity());
                mIqrecyclerView.setAdapter(mIqRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<SkilliqData>> call, Throwable t) {

            }
        });
        return view;
    }

}