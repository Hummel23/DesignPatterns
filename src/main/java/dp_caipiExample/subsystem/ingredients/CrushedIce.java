package dp_caipiExample.subsystem.ingredients;

import dp_caipiExample.subsystem.ingredients.interfaces.CocktailIngredient;

public class CrushedIce implements CocktailIngredient {

    private int portionsOfCrushedIce;

    public CrushedIce() {
        this.portionsOfCrushedIce = 20;
    }

    @Override
    public String getName() {
        return "Crushed Ice";
    }

    @Override
    public boolean isEnoughForCocktail() {
        return portionsOfCrushedIce >= 0;
    }

    public CrushedIce getPortion() {
        this.portionsOfCrushedIce -= 1;
        return this;
    }
}
