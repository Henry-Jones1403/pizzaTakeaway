package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, Double> pizzaPrice() {
        Map<String, Double> pizzaPrice = new HashMap<>();
        pizzaPrice.put("small", 7.99);
        pizzaPrice.put("medium", 10.99);
        pizzaPrice.put("large", 13.99);
        return pizzaPrice;
    }

    public static void main(String[] args) {
        String size = "";
        double price = 0.00;
        Map<String, Double> pizzaPrice = pizzaPrice();
        ArrayList<String> allToppings = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("What size would you like? ");
            size = input.next();
            price = pizzaPrice.get(size);
            System.out.println(price);
        }catch (NullPointerException e){
            System.out.println("That is not a size " + e);
            input.next();

        }

        String toppings = "";
        while (!toppings.equals("end")) {
            System.out.println("What toppings would you like to add");
            toppings = input.next();
            if(!toppings.equals("end")){
                allToppings.add(toppings);
            }

        }
        System.out.println("You chose a " + size + " and have these toppings: ");
        for (int i = 0; i < allToppings.size(); i++) {
            System.out.println(allToppings.get(i));
        }
        System.out.println("This will cost you £" + (price+(1.25 * allToppings.size())));
    }
}
