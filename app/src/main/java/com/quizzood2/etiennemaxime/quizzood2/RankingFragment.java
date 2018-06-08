package com.quizzood2.etiennemaxime.quizzood2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RankingFragment extends Fragment {

    View myFragment;


    public static RankingFragment newInstance() {
        RankingFragment rankingFragment = new RankingFragment();
        return rankingFragment;
    }

    @Override
    public void onCreate(@android.support.annotation.Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @android.support.annotation.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @android.support.annotation.Nullable ViewGroup container, @android.support.annotation.Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_ranking, container, false);
        return myFragment;
    }

}