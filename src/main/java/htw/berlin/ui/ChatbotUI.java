package htw.berlin.ui;

import htw.berlin.domain.Burger;
import htw.berlin.service.BurgerBuilder;

import java.util.*;

public class ChatbotUI {
    private final UserInputWrapper input;
    private final BurgerBuilder builder;
    private final InputParser parser;

    public ChatbotUI(UserInputWrapper uiw, BurgerBuilder bb, InputParser ip) {
        input = uiw;
        builder = bb;
        parser = ip;
    }

    public String launch() {
        String inputLine = input.ask("Willkommen beim Burgerbot! Was moechtest du gerne bestellen?");
        while (!(inputLine.equals("Bestellung abschliessen") || inputLine.equals("Auf Wiedersehen"))) {
            List<Integer> articles = articleIdsFromOrder(inputLine);
            if(articles.isEmpty()) {
                inputLine = input.ask("Entschuldigung, ich habe dich nicht verstanden. Waehle aus folgenden Zutaten: "
                        + Menu.printAllArticles());
            } else {
                builder.addIngredientsById(articles);
                Burger burger = builder.build();
                inputLine = input.ask("In Ordnung. Dein Burger mit " + burger.getIngredients() +
                        " kostet " + burger.calculatePrice() + " Euro. Willst du die Bestellung abschliessen?");
            }
        }
        return inputLine;
    }

    // nur public zum einfacheren Testen
    public List<Integer> articleIdsFromOrder(String inputLine) {
        Set<String> keywords = Menu.getAllArticles().keySet();
        // TODO (2) dann hier mit countKeywords Benutzung implementieren
        return Collections.emptyList();
    }
}
