package mywater.mywater.Authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import mywater.mywater.BaseActivity;
import mywater.mywater.HomeActivity;
import mywater.mywater.R;
import mywater.mywater.common.SecuredPreference;
import mywater.mywater.common.VolleyRequestQueue;
import mywater.mywater.common.VollyStringRequest;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        SecuredPreference.insertIntoPreference(this,"test","myvalue");
        Toast.makeText(this,SecuredPreference.getFromPreference(this,"test"),Toast.LENGTH_LONG).show();

        String url ="http://192.168.0.105:3000/users";
        VollyStringRequest stringRequest = new VollyStringRequest(Request.Method.POST
                , url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(LoginActivity.this,response,Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              }

        }){
            @Override
            public Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("User-Agent", "Nintendo Gameboy");
                params.put("Accept-Language", "fr");
                params.put("user[email]", "success2@gmail.com");
                params.put("user[password]", "succes123");
                params.put("user[password_confirmation]", "succes123");

                return params;
            }
        };
        // Get a RequestQueue
        VolleyRequestQueue.getInstance(this).addToRequestQueue(stringRequest);

    }

    public void onLogin(View v){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void signUp(View view) {
        Intent intent = new Intent(this,SignupData.class);
        startActivity(intent);
    }
}
