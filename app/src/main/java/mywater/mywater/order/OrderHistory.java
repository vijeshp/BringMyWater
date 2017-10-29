package mywater.mywater.order;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mywater.mywater.R;

/**
 * Created by tyrin on 18/10/17.
 */

public class OrderHistory extends Fragment {
    private RecyclerView orderList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.order_history_fragment, container, false);
        orderList = (RecyclerView)rootview.findViewById(R.id.orderlist);
        OrderData orderData1 = new OrderData();
        orderData1.setMerchentId("herew");
        orderData1.setCount(1);
        OrderData orderData2 = new OrderData();
        orderData2.setMerchentId("dsfds");
        orderData2.setCount(1);
        List<OrderData> order = new ArrayList<>();
        order.add(orderData1);
        order.add(orderData2);
        OrderHistoryAdapter orderAdapter = new OrderHistoryAdapter(order);
        orderList.setAdapter(orderAdapter);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getActivity());
        orderList.setLayoutManager(lm);


        return rootview;

    }


    private class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.MyViewHolder>{


        private List<OrderData> orderData;

        public OrderHistoryAdapter(List<OrderData> orderData){
            this.orderData = orderData;
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View IteView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_row,parent,false);
            return new MyViewHolder(IteView);
            //return null;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            OrderData data = orderData.get(position);
            holder.MerchantName.setText(data.getMerchentId());
            holder.Count.setText(""+data.getCount());
        }



        @Override
        public int getItemCount() {
            return orderData.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{
            TextView MerchantName;
            TextView Count;


            public MyViewHolder(View itemView) {
                super(itemView);
                MerchantName = (TextView) itemView.findViewById(R.id.merchent_name);
                Count = (TextView)itemView.findViewById(R.id.count);

            }
        }
    }

}
