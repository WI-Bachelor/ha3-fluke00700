package htw.berlin.service;

import htw.berlin.domain.Burger;
import htw.berlin.domain.FakeBurger;

import java.util.Arrays;
import java.util.List;

public class FakeBurgerBuilder implements BurgerBuilder {

    @Override
    public boolean addIngredientsById(List<Integer> ids) {
        return true;
    }

    @Override
    public Burger build() {
        return new FakeBurger();
    }
}
