package dp_caipiFinal.subsystem.ingredients;

import dp_caipiFinal.subsystem.enums.IngredientName;

import static dp_caipiFinal.subsystem.enums.IngredientName.Soda;

public class Soda extends AbstractCocktailIngredient {

    public IngredientName NAME = Soda;

    //measured in ml
    public Soda() {
        this.contentOfIngredient = 2000;
    }

    @Override
    public String getNAME() {
        return this.NAME.name();
    }
}
