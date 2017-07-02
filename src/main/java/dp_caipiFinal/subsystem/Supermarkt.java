package dp_caipiFinal.subsystem;

import dp_caipiFinal.subsystem.enums.IngredientName;
import dp_caipiFinal.subsystem.ingredients.*;

public class Supermarkt {

    public AbstractCocktailIngredient buyIngredient(IngredientName ingredientName) {
        switch (ingredientName) {
            case Cacacha:
                return new Cacacha();
            case CrushedIce:
                return new CrushedIce();
            case Limette:
                return new Limetten();
            case Rohrzucker:
                return new Rohrzucker();
            case Strohhalm:
                return new Strohhalme();
            case Erdbeere:
                return new Erdbeeren();
            case Minze:
                return new Minze();
            case Rum:
                return new Rum();
            case Soda:
                return new Soda();
            case Limettensaft:
                return new Limettensaft();
            default:
                return null;
        }

    }
}
