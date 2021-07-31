package pl.acturis.pizzaapp.app;

import pl.acturis.pizzaapp.model.Pizzeria;
import pl.acturis.pizzaapp.service.PizzeriaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PizzeriaService pizzeriaService = new PizzeriaService(new Pizzeria(), new Scanner(System.in));

        pizzeriaService.start(pizzeriaService.getPizzeria(), pizzeriaService.getScanner());
    }
}
