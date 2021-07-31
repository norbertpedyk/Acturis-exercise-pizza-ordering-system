package pl.acturis.pizzaapp.service;

import pl.acturis.pizzaapp.model.Order;
import pl.acturis.pizzaapp.model.Pizza;
import pl.acturis.pizzaapp.model.PizzaSize;
import pl.acturis.pizzaapp.model.Pizzeria;

import java.util.Scanner;

public class PizzeriaService {

    private final Pizzeria pizzeria;
    private final Scanner scanner;

    public PizzeriaService(Pizzeria pizzeria, Scanner scanner) {
        this.pizzeria = pizzeria;
        this.scanner = scanner;
    }

    public Pizzeria getPizzeria() {
        return pizzeria;
    }

    public Scanner getScanner() {
        return scanner;
    }

    private void addPizza(Pizzeria pizzeria, Scanner scanner, Order order) {
        do {
            System.out.println("provide name of your pizza");
            String pizzaName = scanner.next();

            Pizza chosenPizza = pizzeria.getAvailablePizzas().stream()
                    .filter(pizza -> pizza.getName().equals(pizzaName))
                    .findFirst().orElse(null);

            if (chosenPizza != null) {
                order.addPizza(new Pizza(chosenPizza.getName(), chosenPizza.getToppingsList(), chosenPizza.getPrice(), chosenPizza.getPizzaSize()));
                break;
            } else {
                System.out.println("Wrong name, please try again");
            }
        } while (true);
    }


    private void changePizzaSize(Scanner scanner, Order order) {
        do {
            System.out.println("Would you like to change size? (Y for 'yes'/any other button for 'no')");
            String next = scanner.next();
            if (next.equalsIgnoreCase("y")) {
                System.out.println("Choose new pizza size: Small, Medium, Large - small size is 5PLN less and large size is 5PLN more");
                String next1 = scanner.next();
                if (next1.equalsIgnoreCase("Small")) {
                    order.getPizzas().get(order.getPizzas().size() - 1).setPizzaSize(PizzaSize.SMALL);
                    order.getPizzas().get(order.getPizzas().size() - 1).setPrice(order.getPizzas().get(order.getPizzas().size() - 1).getPrice() - 5);
                    break;
                } else if (next1.equalsIgnoreCase("Medium")) {
                    order.getPizzas().get(order.getPizzas().size() - 1).setPizzaSize(PizzaSize.MEDIUM);
                    break;
                } else if (next1.equalsIgnoreCase("Large")) {
                    order.getPizzas().get(order.getPizzas().size() - 1).setPizzaSize(PizzaSize.LARGE);
                    order.getPizzas().get(order.getPizzas().size() - 1).setPrice(order.getPizzas().get(order.getPizzas().size() - 1).getPrice() + 5);
                    break;
                } else {
                    System.out.println("Unknown value provided, please try again");
                }
            } else {
                break;
            }
        } while (true);
    }

    private void changePizzaToppings(Pizzeria pizzeria, Scanner scanner, Order order) {
        do {
            System.out.println("Would you like to replace toppings? (Y for 'yes'/any other button for 'no')");
            String next = scanner.next();
            if (next.equalsIgnoreCase("y")) {
                System.out.println(order.getPizzas().get(order.getPizzas().size() - 1).getToppingsList());
                System.out.println("Name of the topping you want to replace: ");
                String next1 = scanner.next();
                if (order.getPizzas().get(order.getPizzas().size() - 1).getToppingsList().contains(next1)) {
                    int index = order.getPizzas().get(order.getPizzas().size() - 1).getToppingsList().indexOf(next1);
                    System.out.println("Choose new topping from the list: " + pizzeria.getToppings());
                    String next2 = scanner.next();
                    if (pizzeria.getToppings().contains(next2)) {
                        order.getPizzas().get(order.getPizzas().size() - 1).getToppingsList().set(index, next2);
                        System.out.println("Replacement completed!");
                    } else {
                        System.out.println("does not match toppings from the list, try again!");
                    }
                } else {
                    System.out.println("does not match current toppings, try again!");
                }
            } else {
                break;
            }
        } while (true);
    }

    private void addPizzaToppings(Pizzeria pizzeria, Scanner scanner, Order order) {
        do {
            System.out.println("Would you like to add additional pizza toppings? (Y for 'yes'/any other button for 'no') - each new topping is 1PLN more");
            if (scanner.next().equalsIgnoreCase("y")) {
                System.out.println("Choose topping you would like to add: " + pizzeria.getToppings());
                String next = scanner.next();
                if (pizzeria.getToppings().contains(next)) {
                    order.getPizzas().get(order.getPizzas().size() - 1).getToppingsList().add(next);
                    order.getPizzas().get(order.getPizzas().size() - 1).setPrice(order.getPizzas().get(order.getPizzas().size() - 1).getPrice() + 1);
                    System.out.println("Topping was added");
                } else {
                    System.out.println("Wrong value, please try again!");
                }

            } else {
                break;
            }
        } while (true);
    }

    /**
     * I've made all methods in PizzeriaService private except method start(), getters and setters.
     * Private keyword prevent me from testing the methods, and it doesn't make sense to test method start() at this point.
     *
     */

    public void start(Pizzeria pizzeria, Scanner scanner) {
        Order order = new Order();
        System.out.println("Provide your name: ");
        order.setUserName(scanner.next());

        System.out.println("Start your order, choose your first pizza: ");
        for (Pizza pizzaType : pizzeria.getAvailablePizzas()) {
            System.out.println(pizzaType);
        }
        do {
            addPizza(pizzeria, scanner, order);
            changePizzaSize(scanner, order);
            changePizzaToppings(pizzeria, scanner, order);
            addPizzaToppings(pizzeria, scanner, order);
            System.out.println("Would you like to add another pizza to your order? (Y for 'yes'/any other button for 'no')");
        } while (scanner.next().equalsIgnoreCase("y"));
        order.sumTotalPrice();
        pizzeria.addOrder(order);
        System.out.println("Your order : " + order);
        System.out.println("Thank you for choosing our pizzeria!");
    }
}
