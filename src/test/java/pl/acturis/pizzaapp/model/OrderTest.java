package pl.acturis.pizzaapp.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class OrderTest {

    @Test
    @DisplayName("the method sumTotalPrice() should add prices of the pizzas added to the order. Checking correctness of operations on stream inside method body ")
    void shouldSumPriceOfOrderedPizzas() {
        //given
        Order order = new Order(new ArrayList<>(Arrays.asList(
                new Pizza("Capriciosa", new ArrayList<>(Arrays.asList("mozzarella", "bacon", "corn")), 39, PizzaSize.MEDIUM),
                new Pizza("Calzone", new ArrayList<>(Arrays.asList("mozzarella", "ham", "peppers")), 35, PizzaSize.MEDIUM),
                new Pizza("Margherita", new ArrayList<>(Arrays.asList("mozzarella", "basil", "salami")), 39, PizzaSize.MEDIUM))), "Example");

        //when
        order.sumTotalPrice();

        //then
        Assertions.assertEquals(113,order.getTotalPrice().get());
    }

}