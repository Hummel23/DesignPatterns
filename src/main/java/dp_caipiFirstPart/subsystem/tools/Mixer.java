package dp_caipiFirstPart.subsystem.tools;


import dp_caipiFirstPart.subsystem.ingredients.AbstractCocktailIngredient;

import java.util.ArrayList;
import java.util.List;

public class Mixer {

    private List<AbstractCocktailIngredient> ingredients = new ArrayList<>();

    public void addIngredient(AbstractCocktailIngredient cocktailIngredient) {
        ingredients.add(cocktailIngredient);
    }

    public void mixIngredients() {

    }

    public List<AbstractCocktailIngredient> getIngredients() {
        return ingredients;
    }
}
