package dp_caipiFinal;

import dp_caipiFinal.client.CaipiLover;
import dp_caipiFinal.client.DaiquiriLover;
import dp_caipiFinal.client.MojitoLover;
import dp_caipiFinal.fassade.Cocktail;

public class CaipiMain {

    public static void main(String[] args) {

        CaipiLover caipiLover = new CaipiLover();

        MojitoLover mojitoLover = new MojitoLover();

        DaiquiriLover daiquiriLover = new DaiquiriLover();

        Cocktail[] cocktails = Cocktail.values();
        for (Cocktail cocktail : cocktails) {
            caipiLover.orderCocktail(cocktail);
            caipiLover.enjoyCocktail();

            mojitoLover.orderCocktail(cocktail);
            mojitoLover.enjoyCocktail();

            daiquiriLover.orderCocktail(cocktail);
            daiquiriLover.enjoyCocktail();
        }

    }
}
