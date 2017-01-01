package com.example.nightwingky.androidclient;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.nightwingky.androidclient.fragment.FragmentHome;
import com.example.nightwingky.androidclient.fragment.FragmentSearch;
import com.example.nightwingky.androidclient.fragment.FragmentShoppingCart;
import com.example.nightwingky.androidclient.fragment.MyFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_tabHome;
    private TextView tv_tabSearch;
    private TextView tv_tabShoppingcart;
    private TextView tv_tabSettings;

    private FrameLayout ly_content;

    private MyFragment f4;
    private FragmentHome fragmentHome;
    private FragmentSearch fragmentSearch;
    private FragmentShoppingCart fragmentShoppingCart;
    private FragmentManager fragmentManager;

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();

        transaction = getFragmentManager().beginTransaction();

        initHomeFragment();
        transaction.commit();
    }

    private void bindView() {
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

    private void initHomeFragment() {
        hideAllFragment(transaction);

        setUnselected();
        tv_tabHome.setSelected(true);

        fragmentHome = new FragmentHome();
        transaction.add(R.id.fragment_container, fragmentHome);

    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if(fragmentHome != null){
            transaction.hide(fragmentHome);
        }
        if(fragmentSearch != null){
            transaction.hide(fragmentSearch);
        }
        if(fragmentShoppingCart != null){
            transaction.hide(fragmentShoppingCart);
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
        transaction = getFragmentManager().beginTransaction();
        hideAllFragment(transaction);

        switch (v.getId()) {
            case R.id.txt_home:
                setUnselected();
                tv_tabHome.setSelected(true);

                if(fragmentHome == null) {
                    fragmentHome = new FragmentHome();
                    transaction.add(R.id.fragment_container, fragmentHome);
                } else {
                    transaction.show(fragmentHome);
                }
                break;
            case R.id.txt_search:
                setUnselected();
                tv_tabSearch.setSelected(true);

                if(fragmentSearch == null) {
                    fragmentSearch = new FragmentSearch();
                    transaction.add(R.id.fragment_container, fragmentSearch);
                } else {
                    transaction.show(fragmentSearch);
                }
                break;
            case R.id.txt_shoppingcart:
                setUnselected();
                tv_tabShoppingcart.setSelected(true);

                if(fragmentShoppingCart == null) {
                    fragmentShoppingCart = new FragmentShoppingCart();
                    transaction.add(R.id.fragment_container, fragmentShoppingCart);
                } else {
                    fragmentShoppingCart.invalidateListView();
                    transaction.show(fragmentShoppingCart);
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
