package dp_caipiFinal.subsystem;

import dp_caipiFinal.subsystem.ingredients.*;
import dp_caipiFinal.subsystem.ingredients.AbstractCocktailIngredient;

public class Supermarkt {

    public AbstractCocktailIngredient buyIngredient(String ingredientName) {
        switch (ingredientName) {
            case "Cacacha":
                return new Cacacha();
            case "Crushed Ice":
                return new CrushedIce();
            case "Limette":
                return new Limetten();
            case "Rohrzucker":
                return new Rohrzucker();
            case "Strohhalme":
                return new Strohhalme();
            case "Erdbeere":
                return new Erdbeeren();
            case "Minze":
                return new Minze();
            case "Rum":
                return new Rum();
            case "Soda":
                return new Soda();
            default:
                return null;
        }

    }
}
