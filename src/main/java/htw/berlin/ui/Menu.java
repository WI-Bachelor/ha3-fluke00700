package htw.berlin.ui;

import java.util.HashMap;
import java.util.Map;

// Eine statische Datenbank-Klasse
public class Menu {
    private Menu() {}

    public static Map<String, Integer> buns = Map.of(
            "Burger", 100,
            "Ciabatta", 200);
    public static Map<String, Integer> patties  = Map.of(
            "Rindfleisch", 300,
            "Falafel", 400);
    public static Map<String, Integer> salads = Map.of(
            "Eisbergsalat",500,
            "Rucolasalat", 600);
    public static Map<String, Integer> veggies = Map.of(
            "Tomate", 700,
            "Gurke", 800);
    public static Map<String, Integer> sauces = Map.of(
            "Ketchup", 900,
            "Mayo", 100);

    public static Map<String, Integer> getAllArticles() {
        Map<String, Integer> articles = new HashMap<>();
        articles.putAll(buns);
        articles.putAll(patties);
        articles.putAll(salads);
        articles.putAll(veggies);
        articles.putAll(sauces);
        return articles;
    }

    public static String printAllArticles() {
        return String.join(" ", getAllArticles().keySet());
    }
}
