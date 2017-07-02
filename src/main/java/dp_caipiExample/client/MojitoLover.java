package dp_caipiExample.client;


import dp_caipiExample.client.view.StepsOfCocktaillover;
import dp_caipiFinal.subsystem.enums.Cocktail;

import static dp_caipiFinal.subsystem.enums.Cocktail.MOJITO;

public class MojitoLover extends AbstractCocktailLover {

    private Cocktail favouriteCocktail = MOJITO;

    public MojitoLover() {
        super();
    }

    @Override
    public void prepareCocktail(Cocktail cocktail) {
        if (cocktail.equals(favouriteCocktail)) {
            super.prepareCocktail(cocktail);
            prepareMojito();
            enjoyCocktail();
        } else {
            System.out.println(StepsOfCocktaillover.notAbleToPrepareThisCocktail(cocktail));
        }
    }

    private void prepareMojito() {
    }
}
