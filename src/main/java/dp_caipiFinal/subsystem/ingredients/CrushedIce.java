package dp_caipiFinal.subsystem.ingredients;


import dp_caipiFinal.subsystem.enums.IngredientName;

import static dp_caipiFinal.subsystem.enums.IngredientName.CrushedIce;

public class CrushedIce extends AbstractCocktailIngredient {

    public static IngredientName NAME = CrushedIce;

    //measured in one handful
    public CrushedIce() {
        this.contentOfIngredient = 40;
    }

    @Override
    public String getNAME() {
        return NAME.name();
    }
}
