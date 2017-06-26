package dp_caipiExample.subsystem.ingredients;

import dp_caipiExample.subsystem.ingredients.interfaces.CocktailIngredient;

public class Rohrzucker implements CocktailIngredient{

    private int contentOfPackageInGramm;

    public Rohrzucker() {
        this.contentOfPackageInGramm = 500;
    }

    @Override
    public String getName() {
        return "Rohrzucker";
    }

    @Override
    public boolean isEnoughForCocktail() {
        return contentOfPackageInGramm >= 60;
    }

    public Rohrzucker getTL(int numberOfTL) {
        this.contentOfPackageInGramm -= (numberOfTL * 20);
        return this;
    }

}
