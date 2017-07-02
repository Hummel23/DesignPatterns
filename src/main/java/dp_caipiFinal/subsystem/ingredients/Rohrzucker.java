package dp_caipiFinal.subsystem.ingredients;


import dp_caipiFinal.subsystem.enums.IngredientName;

import static dp_caipiFinal.subsystem.enums.IngredientName.Rohrzucker;

public class Rohrzucker extends AbstractCocktailIngredient {

    public IngredientName NAME = Rohrzucker;

    //measured in grams
    public Rohrzucker() {
        this.contentOfIngredient = 500;
    }

    @Override
    public String getNAME() {
        return this.NAME.name();
    }
}
