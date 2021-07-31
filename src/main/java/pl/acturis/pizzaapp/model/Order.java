package pl.acturis.pizzaapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {

    private List<Pizza> pizzas = new ArrayList<>();

    private AtomicInteger totalPrice;

    private String userName;


    public Order() {
    }

    public Order(List<Pizza> pizzas, String userName) {
        this.pizzas = pizzas;
        this.userName = userName;
    }



    public List<Pizza> getPizzas() {
        return pizzas;
    }


    public AtomicInteger getTotalPrice() {
        return totalPrice;
    }

    public void sumTotalPrice() {
        AtomicInteger totalPrice = new AtomicInteger();
        pizzas.stream()
                .map(Pizza::getPrice)
                .forEach(integer -> totalPrice.set(totalPrice.get() + integer));
        this.totalPrice = totalPrice;


    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "pizzas=" + pizzas +
                ", totalPrice=" + totalPrice +
                ", userName='" + userName + '\'' +
                '}';
    }
}
