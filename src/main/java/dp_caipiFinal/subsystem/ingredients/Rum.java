package dp_caipiFinal.subsystem.ingredients;

import dp_caipiFinal.subsystem.enums.IngredientName;

import static dp_caipiFinal.subsystem.enums.IngredientName.Rum;

public class Rum extends AbstractCocktailIngredient {

    public IngredientName NAME = Rum;

    //measured in cl
    public Rum() {
        this.contentOfIngredient = 80;
    }

    public String getNAME() {
        return this.NAME.name();
    }
}
