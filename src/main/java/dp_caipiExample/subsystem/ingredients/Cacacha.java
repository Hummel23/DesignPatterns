package dp_caipiExample.subsystem.ingredients;

import dp_caipiExample.subsystem.ingredients.interfaces.CocktailIngredient;

public class Cacacha implements CocktailIngredient {

    private int contentOfBottleInCL;

    public Cacacha() {
        this.contentOfBottleInCL = 80;
    }

    @Override
    public String getName() {
        return "Cacacha";
    }

    @Override
    public boolean isEnoughForCocktail() {
        return contentOfBottleInCL >= 5;
    }

    public Cacacha get5CL() {
        this.contentOfBottleInCL -= 5;
        return this;
    }
}
