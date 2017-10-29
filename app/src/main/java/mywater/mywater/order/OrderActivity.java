package mywater.mywater.order;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import mywater.mywater.BaseActivity;
import mywater.mywater.R;

public class OrderActivity extends BaseActivity implements OrderFragment.OnFragmentInteractionListener {
    //LocationManager loationManager;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    OrderFragment orderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initview();


    }

    private void initview(){
       /*Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);*/
        orderFragment = OrderFragment.newInstance();
       showFragment(OrderFragment.newInstance());
    }



    private void showFragment(Fragment fragment){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.orderPlaceHolderActivity,fragment);
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    private void getLocation(){
        //loationManager = new LocationManager();

    }

}
