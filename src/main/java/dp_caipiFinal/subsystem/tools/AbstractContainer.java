package dp_caipiFinal.subsystem.tools;


import dp_caipiFinal.subsystem.ingredients.AbstractCocktailIngredient;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractContainer {

    List<AbstractCocktailIngredient> ingredients = new ArrayList<>();

    public void addIngredient(AbstractCocktailIngredient cocktailIngredient) {
        ingredients.add(cocktailIngredient);
    }

    public List<AbstractCocktailIngredient> getIngredients() {
        return this.ingredients;
    }
}
