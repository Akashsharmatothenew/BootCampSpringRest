package com.company;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.omg.CORBA.Object;

import java.util.LinkedList;
import java.util.Queue;

public interface Order1{
    Queue<Integer> orderQueue = new LinkedList<>();
    String orderstate = null;
    String notification = null;
    void Order();
    void getDetails();
}
class Customer implements Order1{
int payament;
String beverage;

Customer(int payament,String beverage ,Queue orderQueue){
    this.payament = payament;
    this.beverage = beverage;
}

    @Override
    public void Order() {

    }

    @Override
    public void getDetails() {

    }
}
class Cashier implements Order1{
    int cashid ;

    Cashier(){

    }

    @Override
    public void Order() {
      String  orderstate = "Order Processed";
      String  notification = "wait";

    }

    @Override
    public void getDetails() {

    }
}
class Barista implements Order1{

    @Override
    public void Order() {
        String OrderState = "Order Complete";
        String notification="Order Ready";
    }

    @Override
    public void getDetails() {

    }
}
class OrderFactory{
    Order1 getOrder(String OrderType){
        if(OrderType==null){
            return null;
        }
        else if(OrderType.equals("Custumer")){
            return Customer;
        }
        else if(OrderType.equals("Cashier")){
            return Cashier;
        }
        return null;
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
