package com.company;
import java.util.*;

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
        String[] toppings = {"ham", "cheese", "tomato", "pepperoni", "sausage", "mushroom", "onion", "olives", "garlic", "anchovies"};
        ArrayList<String> allToppings = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean accepted = false;
        while(!accepted){
        try{
            System.out.println("What size would you like? ");
            size = input.next();
            price = pizzaPrice.get(size);
            System.out.println(price);
            accepted = true;
        }catch (NullPointerException e){
            System.out.println("That is not a size " + e);
        }catch (Exception e){
            System.out.println("Sorry there was an error, try again " + e);

        }}
        int counter = 0;
        String userToppings = "";
        System.out.print("At any point type 'end' to finish and pay. These are our toppings: ");
        for (String topping : toppings) {
            System.out.print(topping + ", ");
        }
        System.out.println();
        while (!userToppings.equals("end")) {
            boolean found = false;

            if(counter<2) {
                System.out.println("What free topping would you like to add");
            }else{
                System.out.println("What topping would you like to add");
            }
            userToppings = input.next();
            if(!userToppings.equals("end")){
                for (String topping : toppings) {
                    if (userToppings.equals(topping)) {
                        allToppings.add(userToppings);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("Try again, that isn't an option.");
                }


            }counter++;
        }
        System.out.println("You chose a " + size + " and have these toppings: ");
        for (String allTopping : allToppings) {
            System.out.println(allTopping);
        }
        price = price + (1.25 * (allToppings.size()-2));
        System.out.println("This will cost you £" + price);
    }
}
