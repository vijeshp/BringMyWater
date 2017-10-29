package mywater.mywater.order;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import mywater.mywater.R;

public class OrderFragment extends Fragment {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Spinner spinner_address,spinner_watertype,spinner_water_count,spinner_street,spinner_shope;
    Button ordernow;
    private OnFragmentInteractionListener mListener;

    public OrderFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static OrderFragment newInstance() {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = inflater.inflate(R.layout.fragment_order, container, false);
        ordernow = (Button)rootview.findViewById(R.id.order_nw);
        spinner_address = (Spinner)rootview.findViewById(R.id.spinner_delivery_address);

        spinner_watertype = (Spinner)rootview.findViewById(R.id.spinner_water_type);

        spinner_water_count = (Spinner)rootview.findViewById(R.id.spinner_water_no);

        spinner_street = (Spinner)rootview.findViewById(R.id.spinner_street);

        spinner_shope = (Spinner)rootview.findViewById(R.id.spinner_shop);

        ArrayAdapter<CharSequence> address = ArrayAdapter.createFromResource(getActivity(),R.array.address, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> water_type = ArrayAdapter.createFromResource(getActivity(),R.array.water_type, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> water_count = ArrayAdapter.createFromResource(getActivity(),R.array.water_count, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> water_street = ArrayAdapter.createFromResource(getActivity(),R.array.Streets_available, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> water_shope1 = ArrayAdapter.createFromResource(getActivity(),R.array.shops_1, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> water_shope2 = ArrayAdapter.createFromResource(getActivity(),R.array.shops_2, android.R.layout.simple_spinner_item);

        address.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        water_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        water_count.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        water_street.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        water_shope1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        water_shope2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_address.setAdapter(address);
        spinner_watertype.setAdapter(water_type);
        spinner_water_count.setAdapter(water_count);
        spinner_street.setAdapter(water_street);
        spinner_shope.setAdapter(water_shope1);



        ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToPreference();
            }
        });
        initview();
        return rootview;
    }

    private void initview()
    {

        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String saved_name = sharedPref.getString("name","");
        String saved_phone = sharedPref.getString("phone","");
        String saved_address = sharedPref.getString("address","");

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



    public void writeToPreference(){
//        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
//        editor = sharedPref.edit();
//        editor.putString("name", name.getText().toString());
//        editor.putString("phone", phone.getText().toString());
//        editor.putString("address", address.getText().toString());
//        editor.commit();
    }
}
