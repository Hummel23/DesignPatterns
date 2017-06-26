package dp_caipiExample.subsystem.tools;


import dp_caipiExample.subsystem.ingredients.interfaces.CocktailIngredient;

import java.util.ArrayList;
import java.util.List;

public class Glas {

    private List<CocktailIngredient> ingredients = new ArrayList<>();

    public void addIngredient(CocktailIngredient cocktailIngredient) {
        ingredients.add(cocktailIngredient);
    }

    public boolean isFull() {
        return ingredients.size()>0;
    }
}
