package dp_caipiFinal.subsystem.ingredients;

import dp_caipiFinal.subsystem.enums.IngredientName;

import static dp_caipiFinal.subsystem.enums.IngredientName.Strohhalm;

public class Strohhalme extends AbstractCocktailIngredient {

    public IngredientName NAME = Strohhalm;

    //measured in pieces
    public Strohhalme() {
        this.contentOfIngredient = 60;
    }

    @Override
    public String getNAME() {
        return this.NAME.name();
    }
}
