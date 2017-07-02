package dp_caipiFinal.subsystem.ingredients;


import dp_caipiFinal.subsystem.enums.IngredientName;

import static dp_caipiFinal.subsystem.enums.IngredientName.Cacacha;

public class Cacacha extends AbstractCocktailIngredient {

    public IngredientName NAME = Cacacha;

    //measured in cl
    public Cacacha() {
        this.contentOfIngredient = 80;
    }

    @Override
    public String getNAME() {
        return this.NAME.name();
    }


}
