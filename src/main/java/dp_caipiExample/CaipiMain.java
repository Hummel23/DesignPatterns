package dp_caipiExample;

import dp_caipiExample.client.CaipiLover;

public class CaipiMain {

    public static void main(String[] args) {

        CaipiLover caipiLover = new CaipiLover();

        for (int i = 0; i < 10; i++) {
                caipiLover.prepareCocktail();
                caipiLover.enjoyCocktail();
        }
    }
}
