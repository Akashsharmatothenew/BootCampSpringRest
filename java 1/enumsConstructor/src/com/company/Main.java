package com.company;


enum house{
    house1(10),house2(20),house3(15),house4(34),house5(18);
    int price;
    house(int p){
        price = p;
    }
    int getPrice(){
        return price;
    }
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("All House Details");
        for(house h:house.values())
            System.out.println( h +" Price "+ h.getPrice() + "  Lakh Rupeees");
    }
}
