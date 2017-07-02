package dp_caipiFinal;

import dp_caipiFinal.client.CaipiLover;
import dp_caipiFinal.client.DaiquiriLover;
import dp_caipiFinal.client.MojitoLover;
import dp_caipiFinal.subsystem.enums.Cocktail;

public class CaipiMain {

    public static void main(String[] args) {

        CaipiLover caipiLover = new CaipiLover();

        MojitoLover mojitoLover = new MojitoLover();

        DaiquiriLover daiquiriLover = new DaiquiriLover();

        Cocktail[] cocktails = Cocktail.values();
        for (Cocktail cocktail : cocktails) {
            caipiLover.orderCocktail(cocktail);
            mojitoLover.orderCocktail(cocktail);
            daiquiriLover.orderCocktail(cocktail);
        }
    }
}

