package mywater.mywater.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

/**
 * Created by tyrin on 17/10/17.
 */

public class SecuredPreference  {
    public static String encript(String input) {
        return Base64.encodeToString(input.getBytes(),Base64.DEFAULT);
    }

    public static String decript(String input) {
        return new String(Base64.decode(input,Base64.DEFAULT));
    }

    public static void insertIntoPreference(Context context, String key, String value) {
        SharedPreferences prefernces = context.getSharedPreferences("water_pref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefernces.edit();
        editor.putString(encript(key),encript(value));
        editor.apply();
    }

    public static String getFromPreference(Context context, String key) {
        SharedPreferences prefernces = context.getSharedPreferences("water_pref",Context.MODE_PRIVATE);
        String encriptedValue = prefernces.getString(encript(key),encript("0"));
        String decriptedValue=decript(encriptedValue);
        return decriptedValue;
    }
}
