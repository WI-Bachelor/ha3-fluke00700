package htw.berlin.domain;

import java.util.List;

public interface Burger {
    double calculatePrice();
    double calculateCalories();
    List<String> getIngredients();
}
