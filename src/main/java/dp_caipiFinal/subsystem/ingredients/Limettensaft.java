package dp_caipiFinal.subsystem.ingredients;

import dp_caipiFinal.subsystem.enums.IngredientName;

import static dp_caipiFinal.subsystem.enums.IngredientName.Limettensaft;

public class Limettensaft extends AbstractCocktailIngredient {

    public IngredientName NAME = Limettensaft;

    //measured in cl
    public Limettensaft() {
        this.contentOfIngredient = 100;
    }

    @Override
    public String getNAME() {
        return this.NAME.name();
    }
}
