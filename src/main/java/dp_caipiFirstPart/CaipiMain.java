package dp_caipiFirstPart;

import dp_caipiFinal.subsystem.enums.Cocktail;
import dp_caipiFirstPart.client.CaipiLover;
import dp_caipiFirstPart.client.DaiquiriLover;
import dp_caipiFirstPart.client.MojitoLover;

public class CaipiMain {

    public static void main(String[] args) {
        Cocktail[] cocktails = Cocktail.values();


        DaiquiriLover daiquiriLover = new DaiquiriLover();
        for (Cocktail cocktail : cocktails) {
            daiquiriLover.prepareCocktail(cocktail);
        }

        MojitoLover mojitoLover = new MojitoLover();
        for (Cocktail cocktail : cocktails) {
            mojitoLover.prepareCocktail(cocktail);
        }

        CaipiLover caipiLover = new CaipiLover();
        for (Cocktail cocktail : cocktails) {
            caipiLover.prepareCocktail(cocktail);
        }
    }
}
