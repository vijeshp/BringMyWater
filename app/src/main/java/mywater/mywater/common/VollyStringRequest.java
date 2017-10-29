package mywater.mywater.common;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

/**
 * Created by tyrin on 16/10/17.
 */

public class VollyStringRequest extends StringRequest{
    public VollyStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public VollyStringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

}
