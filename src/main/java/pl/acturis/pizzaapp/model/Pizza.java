package pl.acturis.pizzaapp.model;


import java.util.List;

public class Pizza {

    private final String name;

    private List<String> toppingsList;

    private Integer price;

    private PizzaSize pizzaSize;

    public Pizza(String name, List<String> toppingsList, Integer price, PizzaSize pizzaSize) {
        this.name = name;
        this.toppingsList = toppingsList;
        this.price = price;
        this.pizzaSize = pizzaSize;
    }

    public String getName() {
        return name;
    }

    public List<String> getToppingsList() {
        return toppingsList;
    }

    public void setToppingsList(List<String> toppingsList) {
        this.toppingsList = toppingsList;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", toppingsList=" + toppingsList +
                ", price=" + price +
                ", pizzaSize=" + pizzaSize +
                '}';
    }
}
