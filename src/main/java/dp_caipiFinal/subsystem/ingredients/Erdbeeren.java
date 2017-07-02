package dp_caipiFinal.subsystem.ingredients;

import dp_caipiFinal.subsystem.enums.IngredientName;
import dp_caipiFinal.subsystem.interfaces.Fruit;

import static dp_caipiFinal.subsystem.enums.IngredientName.Erdbeere;

public class Erdbeeren extends AbstractCocktailIngredient implements Fruit {

    public static IngredientName NAME = Erdbeere;

    //measured in pieces
    public Erdbeeren() {
        this.contentOfIngredient = 25;
    }

    @Override
    public String getNAME() {
        return NAME.name();
    }

    @Override
    public void washFruit() {

    }

    @Override
    public void cutInPieces() {

    }

}
