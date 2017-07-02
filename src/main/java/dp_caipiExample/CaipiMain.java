package dp_caipiExample;

import dp_caipiExample.client.CaipiLover;

import static dp_caipiFinal.subsystem.enums.Cocktail.CAIPI;
import static dp_caipiFinal.subsystem.enums.Cocktail.DAIQUIRI;
import static dp_caipiFinal.subsystem.enums.Cocktail.MOJITO;

public class CaipiMain {

    public static void main(String[] args) {

        CaipiLover caipiLover = new CaipiLover();

        caipiLover.prepareCocktail(CAIPI);
        caipiLover.prepareCocktail(MOJITO);
        caipiLover.prepareCocktail(DAIQUIRI);
    }
}
