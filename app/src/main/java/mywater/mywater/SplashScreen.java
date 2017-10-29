package mywater.mywater;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import mywater.mywater.order.OrderActivity;

public class SplashScreen extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, OrderActivity.class);
                startActivity(i);
                finish();
            }
        }, 1000);
    }
}
