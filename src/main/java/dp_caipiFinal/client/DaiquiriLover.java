package dp_caipiFinal.client;


import dp_caipiFinal.subsystem.enums.Cocktail;

import static dp_caipiFirstPart.client.view.StepsOfCocktaillover.PROSTDAIQUIRI;

public class DaiquiriLover extends AbstractCocktailLover {

    Cocktail favouriteCocktail = Cocktail.DAIQUIRI;

    @Override
    public void enjoyCocktail() {
        System.out.println(PROSTDAIQUIRI);
    }
}
