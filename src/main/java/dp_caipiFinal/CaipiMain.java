package dp_caipiFinal;

import dp_caipiFinal.client.CaipiLover;
import dp_caipiFinal.client.DaiquiriLover;
import dp_caipiFinal.client.MojitoLover;

public class CaipiMain {

    public static void main(String[] args) {

        CaipiLover caipiLover = new CaipiLover();

        for (int i = 0; i < 10; i++) {
                caipiLover.prepareCocktail();
                caipiLover.enjoyCocktail();
        }

        MojitoLover mojitoLover = new MojitoLover();

        for (int i = 0; i < 10; i++) {
            mojitoLover.prepareCocktail();
            mojitoLover.enjoyCocktail();
        }

        DaiquiriLover daiquiriLover = new DaiquiriLover();

        for (int i = 0; i < 5; i++) {
            daiquiriLover.prepareCocktail();
            daiquiriLover.enjoyCocktail();
        }
    }
}
