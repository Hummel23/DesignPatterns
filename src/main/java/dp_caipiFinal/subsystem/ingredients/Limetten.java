package dp_caipiFinal.subsystem.ingredients;

import dp_caipiFinal.subsystem.enums.IngredientName;
import dp_caipiFinal.subsystem.interfaces.Fruit;

import static dp_caipiFinal.subsystem.enums.IngredientName.Limette;

public class Limetten extends AbstractCocktailIngredient implements Fruit {

    public IngredientName NAME = Limette;

    //measured in pieces
    public Limetten() {
        this.contentOfIngredient = 8;
    }


    @Override
    public void washFruit() {

    }

    public void cutInPieces() {
    }

    @Override
    public String getNAME() {
        return this.NAME.name();
    }

}
