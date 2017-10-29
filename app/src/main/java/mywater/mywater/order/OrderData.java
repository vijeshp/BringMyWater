package mywater.mywater.order;

/**
 * Created by tyrin on 18/10/17.
 */

public class OrderData {


    private int count = 0;
    private int status = 0;
    private String merchentId = "";
    private long orderDate =0;
    private long deliverDate =0;
    private String deliverAddress ="";




    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMerchentId() {
        return merchentId;
    }

    public void setMerchentId(String merchentId) {
        this.merchentId = merchentId;
    }

    public long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(long orderDate) {
        this.orderDate = orderDate;
    }

    public long getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(long deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }


}
