package dp_caipiFinal.client;


import dp_caipiFinal.fassade.Cocktail;

import static dp_caipiFinal.client.view.StepsOfCocktaillover.PROSTMOJITO;

public class MojitoLover extends AbstractCocktailLover {
    

    Cocktail favouriteCocktail = Cocktail.MOJITO;

    @Override
    public void enjoyCocktail() {
        System.out.println(PROSTMOJITO);
    }
}
