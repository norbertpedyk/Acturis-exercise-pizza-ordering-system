package pl.acturis.pizzaapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *      if the assignment wasn't purely in java I would make this class an @Entity and store the input information for variables
 *      'availablePizzas' and 'toppings' inside a database. At this point according to the assignment this is the closest I could think of.
 *      In general, I hope that I understood the assigment correctly, that we should only make this app for java console and without
 *      using components like Spring or Hibernate. I could very easily make this app more advanced by
 *      using database to store data and using Spring to automatically manage dependency injections. I could also design and implement
 *      REST API.
 */

public class Pizzeria {

    // if the assignment wasn't purely in java I would make this class an @Entity and store the input information for variables
    // 'availablePizzas' and 'toppings' inside a database. At this point according to the assignment this is the closest I could think of.
    // In general, I hope that I understood the assigment correctly, that we should only make this app for java console and without
    // using components like Spring or Hibernate. I could very easily make this app more advanced by
    // using database to store data and using Spring to automatically manage dependency injections. I could also design and implement
    // REST API.
    private final List<Pizza> availablePizzas = new ArrayList<>(Arrays.asList(
            new Pizza("Capriciosa", new ArrayList<>(Arrays.asList("mozzarella", "bacon", "corn")), 39, PizzaSize.MEDIUM),
            new Pizza("Calzone", new ArrayList<>(Arrays.asList("mozzarella", "ham", "peppers")), 35, PizzaSize.MEDIUM),
            new Pizza("Margherita", new ArrayList<>(Arrays.asList("mozzarella", "basil", "salami")), 39, PizzaSize.MEDIUM))
    );

    private final List<String> toppings = new ArrayList<>(Arrays.asList("rucola","basil","peppers","mushrooms",
            "jalapeno","salami","tuna","mozzarella","ham","onion","kebab","corn","pineapple","bacon","gouda"));

    private List<Order> orders = new ArrayList<>();


    public Pizzeria() {
    }

    public List<String> getToppings() {
        return toppings;
    }

    public List<Pizza> getAvailablePizzas() {
        return availablePizzas;
    }

    public List<Order> getOrders() {
        return orders;
    }


    public void addOrder(Order order) {
        orders.add(order);
    }
}
