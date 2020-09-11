package com.jombeja.gadsleaderboard;

import android.content.Context;
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
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LearningFragment extends Fragment {

    private RecyclerView mLearningrecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<LearningData> mListItems = new ArrayList<>();
    private LearningRecyclerAdapter mLearningRecyclerAdapter;

    public LearningFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learning, container, false);
        mLearningrecyclerView = view.findViewById(R.id.recycler_learning);
        mLearningrecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLearningrecyclerView.setLayoutManager(mLayoutManager);

        LearningApi learningApi = ServiceBuilder.buildservice(LearningApi.class);
        Call<List<LearningData>> call = learningApi.getHours();
        call.enqueue(new Callback<List<LearningData>>() {
            @Override
            public void onResponse(Call<List<LearningData>> call, Response<List<LearningData>> response) {
                mListItems = new ArrayList<>(response.body());
                mLearningRecyclerAdapter = new LearningRecyclerAdapter(mListItems, getActivity());
                mLearningrecyclerView.setAdapter(mLearningRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<LearningData>> call, Throwable t) {

            }
        });
        return view;
    }
}