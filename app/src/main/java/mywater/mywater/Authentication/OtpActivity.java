package mywater.mywater.Authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import mywater.mywater.BaseActivity;
import mywater.mywater.HomeActivity;
import mywater.mywater.R;
import mywater.mywater.common.AddressScreen;

public class OtpActivity extends BaseActivity {
    int PLACE_PICKER_REQUEST = 1;
    int ADDRESS_ENTRY_REQUEST = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
    }

    public void validateOtp(View view) {

        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int request,int response,Intent data){
        if(request == PLACE_PICKER_REQUEST) {
           if(response == RESULT_OK){
               Place place = PlacePicker.getPlace(data,this);
               Toast.makeText(this,place.getName()+"lat lang"+place.getLatLng(),Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(this, AddressScreen.class);
               startActivityForResult(intent,ADDRESS_ENTRY_REQUEST);
           }
        } else {
            if(response == RESULT_OK){
                Intent homeActivity = new Intent(this, HomeActivity.class);
                startActivity(homeActivity);
            }
        }

    }
}
