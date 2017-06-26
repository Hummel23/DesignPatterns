package dp_caipiExample.subsystem.ingredients;

import dp_caipiExample.subsystem.ingredients.interfaces.CocktailIngredient;

public class Limette implements CocktailIngredient {

    public void washWithWarmWater() {
    }

    public void cutInPieces() {
    }

    @Override
    public String getName() {
        return "Limette";
    }

    @Override
    public boolean isEnoughForCocktail() {
        return true;
    }
}
