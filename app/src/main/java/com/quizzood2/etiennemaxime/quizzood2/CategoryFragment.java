package com.quizzood2.etiennemaxime.quizzood2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;


public class CategoryFragment extends Fragment {

    View myFragment;


    public static CategoryFragment newInstance() {
        CategoryFragment categoryFragment = new CategoryFragment();
        return categoryFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @android.support.annotation.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @android.support.annotation.Nullable ViewGroup container, @android.support.annotation.Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_category, container, false);
        return myFragment;
    }

}
