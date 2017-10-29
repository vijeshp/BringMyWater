package mywater.mywater.Authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import mywater.mywater.BaseActivity;
import mywater.mywater.R;
import mywater.mywater.common.Utils;
import mywater.mywater.common.VolleyRequestQueue;
import mywater.mywater.common.VollyJsonRequest;
import mywater.mywater.common.VollyStringRequest;
import mywater.mywater.common.Constants;

public class SignupData extends BaseActivity {
    String name,phone,password;
    EditText tName,tPhone,tPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_data);
        tName = (EditText)findViewById(R.id.signup_name);
        tPhone = (EditText)findViewById(R.id.edittextphonesignup);
        tPassword = (EditText)findViewById(R.id.passwordsignup);
    }

    public void signUpUser(View view) throws JSONException {

        if(!Utils.isNetworkAvailable(SignupData.this)) {
            Toast.makeText(SignupData.this, "Network issue", Toast.LENGTH_LONG).show();
           // return;
        }
       // mokeRegisterresponse();

        //requestSignUpData();
        Intent otpvalidation = new Intent(SignupData.this,OtpActivity.class);
        startActivity(otpvalidation);
    }


    private void requestSignUpData() throws JSONException {
        JSONObject jsonBody = new JSONObject();
        JSONObject test = new JSONObject();
        test.put("mobile_numer","9036409051");
        jsonBody.put("user",test);
        VollyJsonRequest stringRequest = new VollyJsonRequest (Request.Method.POST
                , Constants.REGISTER_USER_URL,jsonBody,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(SignupData.this,response.toString(),Toast.LENGTH_LONG).show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SignupData.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }

        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  headers = new HashMap<String, String>();
                headers.put("content-type", "application/json");
                headers.put("cache-control", "no-cache");
                return headers;
            }


        };
        stringRequest.setShouldCache(false);
        // Get a RequestQueue
        VolleyRequestQueue.getInstance(this).addToRequestQueue(stringRequest);
    }

    private void mokeRegisterresponse() {
        String json = null;
        try {
          JSONObject obj = new JSONObject(Utils.loadJsonStringFromAssets(SignupData.this,"registration.json"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
