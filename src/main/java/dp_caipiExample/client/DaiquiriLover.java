package dp_caipiExample.client;


import dp_caipiExample.client.view.StepsOfCocktaillover;
import dp_caipiFinal.subsystem.enums.Cocktail;

import static dp_caipiFinal.subsystem.enums.Cocktail.DAIQUIRI;

public class DaiquiriLover extends AbstractCocktailLover {

    private Cocktail favouriteCocktail = DAIQUIRI;

    public DaiquiriLover() {
        super();
    }


    @Override
    public void prepareCocktail(Cocktail cocktail) {
        if (cocktail.equals(favouriteCocktail)) {
            super.prepareCocktail(cocktail);
            prepareDaiquiri();
            enjoyCocktail();
        } else {
            System.out.println(StepsOfCocktaillover.notAbleToPrepareThisCocktail(cocktail));
        }
    }

    private void prepareDaiquiri() {

    }
}
