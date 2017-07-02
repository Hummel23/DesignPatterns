package dp_caipiFinal.subsystem.ingredients;

import dp_caipiFinal.subsystem.enums.IngredientName;

import static dp_caipiFinal.subsystem.enums.IngredientName.Minze;


public class Minze extends AbstractCocktailIngredient {

    public IngredientName NAME = Minze;

    //measured in leaves
    public Minze() {
        this.contentOfIngredient = 30;
    }

    @Override
    public String getNAME() {
        return this.NAME.name();

    }
}
