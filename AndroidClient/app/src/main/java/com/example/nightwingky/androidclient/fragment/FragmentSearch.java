package com.example.nightwingky.androidclient.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nightwingky.androidclient.R;

/**
 * Created by nightwingky on 16-12-29.
 */

public class FragmentSearch extends Fragment {

    private SearchView mSearchView;

    public FragmentSearch() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_layout, container, false);
        mSearchView = (SearchView) view.findViewById(R.id.search_view);

        return view;
    }
}
