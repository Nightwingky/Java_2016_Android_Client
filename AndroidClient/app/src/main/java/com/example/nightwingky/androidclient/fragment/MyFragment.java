package com.example.nightwingky.androidclient.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nightwingky.androidclient.R;

/**
 * Created by nightwingky on 16-12-29.
 */

public class MyFragment extends Fragment {

    private String context;
    private TextView mTextView;

    public MyFragment() {
    }

    public MyFragment(String context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);
        mTextView = (TextView)view.findViewById(R.id.txt_content);
        mTextView.setText(context);
        return view;
    }
}
