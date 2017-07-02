package dp_caipiFinal.client;


import dp_caipiFinal.subsystem.enums.Cocktail;

import static dp_caipiFinal.client.view.StepsOfCocktaillover.PROSTCAIPI;

public class CaipiLover extends AbstractCocktailLover {

    Cocktail favouriteCocktail = Cocktail.CAIPI;

    @Override
    public void enjoyCocktail() {
        System.out.println(PROSTCAIPI);
    }

}
