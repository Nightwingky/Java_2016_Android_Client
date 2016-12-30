package com.example.nightwingky.androidclient;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.nightwingky.androidclient.fragment.MyFragment;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_topBar;
    private TextView tv_tabHome;
    private TextView tv_tabSearch;
    private TextView tv_tabShoppingcart;
    private TextView tv_tabSettings;

    private FrameLayout ly_content;

    private MyFragment f1, f2, f3, f4;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
    }

    private void bindView() {
        tv_topBar = (TextView) findViewById(R.id.text_top);
        tv_tabHome = (TextView) findViewById(R.id.txt_home);
        tv_tabSearch = (TextView) findViewById(R.id.txt_search);
        tv_tabShoppingcart = (TextView) findViewById(R.id.txt_shoppingcart);
        tv_tabSettings = (TextView) findViewById(R.id.txt_settings);
        ly_content = (FrameLayout) findViewById(R.id.fragment_container);

        tv_tabHome.setOnClickListener(this);
        tv_tabSearch.setOnClickListener(this);
        tv_tabShoppingcart.setOnClickListener(this);
        tv_tabSettings.setOnClickListener(this);
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if(f1 != null){
            transaction.hide(f1);
        }
        if(f2 != null){
            transaction.hide(f2);
        }
        if(f3 != null){
            transaction.hide(f3);
        }
        if(f4 != null){
            transaction.hide(f4);
        }
    }

    private void setUnselected() {
        tv_tabHome.setSelected(false);
        tv_tabSearch.setSelected(false);
        tv_tabShoppingcart.setSelected(false);
        tv_tabSettings.setSelected(false);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);

        switch (v.getId()) {
            case R.id.txt_home:
                setUnselected();
                tv_tabHome.setSelected(true);

                if(f1 == null) {
                    f1 = new MyFragment("home");
                    transaction.add(R.id.fragment_container, f1);
                } else {
                    transaction.show(f1);
                }
                break;
            case R.id.txt_search:
                setUnselected();
                tv_tabSearch.setSelected(true);

                if(f2 == null) {
                    f2 = new MyFragment("Search");
                    transaction.add(R.id.fragment_container, f2);
                } else {
                    transaction.show(f2);
                }
                break;
            case R.id.txt_shoppingcart:
                setUnselected();
                tv_tabShoppingcart.setSelected(true);

                if(f3 == null) {
                    f3 = new MyFragment("Shopping Cart");
                    transaction.add(R.id.fragment_container, f3);
                } else {
                    transaction.show(f3);
                }
                break;
            case R.id.txt_settings:
                setUnselected();
                tv_tabSettings.setSelected(true);

                if(f4 == null) {
                    f4 = new MyFragment("Settings");
                    transaction.add(R.id.fragment_container, f4);
                } else {
                    transaction.show(f4);
                }
                break;
        }

        transaction.commit();
    }


}
