package mywater.mywater.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tyrin on 17/10/17.
 */

public class Utils {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork!=null && activeNetwork.isConnected();
    }

    public static String loadJsonStringFromAssets(Context context, String name) {
        String json = null;
        try {
            InputStream is =context.getAssets().open(name);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read();
            is.close();
            json = new String(buffer,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
