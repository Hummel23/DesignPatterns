package dp_caipiExample.subsystem.ingredients;

import dp_caipiExample.subsystem.ingredients.interfaces.CocktailIngredient;

public class Strohhalm implements CocktailIngredient {

    @Override
    public String getName() {
        return "Strohhalm";
    }

    @Override
    public boolean isEnoughForCocktail() {
        return true;
    }
}
