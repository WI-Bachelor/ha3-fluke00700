package htw.berlin.domain;

import java.util.Arrays;
import java.util.List;

public class FakeBurger implements Burger {

    @Override
    public double calculatePrice() {
        return 0.99;
    }

    @Override
    public double calculateCalories() {
        return 0;
    }

    @Override
    public List<String> getIngredients() {
        return Arrays.asList("Kaese", "Kaese", "Kaese");
    }
}