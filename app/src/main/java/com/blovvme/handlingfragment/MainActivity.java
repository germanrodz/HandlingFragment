package com.blovvme.handlingfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnFragmentInteractionListener{

    private static final String RED_FRAGMENT_TAG = "RedFragment";
    private static final String YELLOW_FRAGMENT_TAG = "YellowFragment";
    private static final String BLUE_FRAGMENT_TAG = "BlueFragment";
    Button btnAddFragment,btnAddYellow,btnSendToMain,removeAll;
    Button btnremoveBlue,btnremoveYellow,btnremoveRed;
    FrameLayout flFrag1;
    TextView tvFromBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddYellow = (Button)findViewById(R.id.btnAddYellow);
        btnAddFragment = (Button)findViewById(R.id.btnAddFragment);
        flFrag1 = (FrameLayout)findViewById(R.id.flFrag1);
        tvFromBlue = (TextView)findViewById(R.id.tvFromBlue);
        btnSendToMain = (Button)findViewById(R.id.btnSendToMain);
        btnremoveBlue = (Button)findViewById(R.id.btnremoveBlue);
        btnremoveRed = (Button)findViewById(R.id.btnremoveRed);
        btnremoveYellow = (Button)findViewById(R.id.btnremoveYellow);


    }

    //Button addFragment
    public void addFragment(View view) {

        switch (view.getId()) {

            case R.id.btnAddFragment:
                RedFragment redFragment = new RedFragment();
                getSupportFragmentManager().beginTransaction()
                    .add(R.id.flFrag1, redFragment, RED_FRAGMENT_TAG)
                    .addToBackStack(RED_FRAGMENT_TAG).commit();
                break;
            case R.id.btnAddYellow:
                YellowFragment yellowFragment = YellowFragment.newInstance("John","Doe");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFrag1,yellowFragment,YELLOW_FRAGMENT_TAG)
                        .addToBackStack(YELLOW_FRAGMENT_TAG)
                        //.popStackImmediate();
                        .commit();
                break;
            case R.id.btnAddBlue:
                BlueFragment blueFragment = BlueFragment.newInstance("John","Doe");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flFrag1,blueFragment,BLUE_FRAGMENT_TAG)
                        .addToBackStack(YELLOW_FRAGMENT_TAG)
                        //.popStackImmediate();
                        .commit();
                break;


        }

    }



    @Override
    public void onFragmentInteraction(String string) {
        tvFromBlue.setText(string);
    }

    public void removeFragment(View view) {
        switch (view.getId()){

            case R.id.btnremoveRed:
                Fragment fragmentRed = getSupportFragmentManager().findFragmentByTag(RED_FRAGMENT_TAG);
                if (fragmentRed != null) {
                    getSupportFragmentManager().beginTransaction()
                            .remove(fragmentRed)
                            .commit();
                }
                break;
            case R.id.btnremoveYellow:
                    Fragment fragmentYellow = getSupportFragmentManager().findFragmentByTag(YELLOW_FRAGMENT_TAG);
                    if (fragmentYellow != null) {
                        getSupportFragmentManager().beginTransaction()
                                .remove(fragmentYellow)
                                .commit();
                    }
                break;
            case R.id.btnremoveBlue:
                Fragment fragmentBlue= getSupportFragmentManager().findFragmentByTag(BLUE_FRAGMENT_TAG);
                if (fragmentBlue != null) {
                    getSupportFragmentManager().beginTransaction()
                            .remove(fragmentBlue)
                            .commit();
                }
                break;
        }
    }
}//////last
