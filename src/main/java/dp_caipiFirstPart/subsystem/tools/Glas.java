package dp_caipiFirstPart.subsystem.tools;


import dp_caipiFirstPart.subsystem.ingredients.AbstractCocktailIngredient;

import java.util.ArrayList;
import java.util.List;

public class Glas {

    private List<AbstractCocktailIngredient> ingredients = new ArrayList<>();

    public void addIngredient(AbstractCocktailIngredient cocktailIngredient) {
        ingredients.add(cocktailIngredient);
    }

    public boolean isFull() {
        return ingredients.size()>0;
    }
}
