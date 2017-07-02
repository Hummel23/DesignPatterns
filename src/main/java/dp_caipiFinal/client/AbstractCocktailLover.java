package dp_caipiFinal.client;


import dp_caipiFinal.client.view.StepsOfCocktaillover;
import dp_caipiFinal.fassade.Barkeeper;
import dp_caipiFinal.subsystem.enums.Cocktail;

import static dp_caipiFinal.subsystem.enums.Cocktail.CAIPI;
import static dp_caipiFinal.subsystem.enums.Cocktail.DAIQUIRI;
import static dp_caipiFinal.subsystem.enums.Cocktail.MOJITO;

public abstract class AbstractCocktailLover {

    Barkeeper barkeeper;
    Cocktail orderedCocktail;

    public AbstractCocktailLover() {
        this.barkeeper = new Barkeeper();

    }

    public void orderCocktail(Cocktail cocktail){
        this.orderedCocktail = cocktail;
        barkeeper.prepareCocktail(cocktail);
        enjoyCocktail();
        StepsOfCocktaillover.orderedACocktail(cocktail);
    }

    private void enjoyCocktail(){
        if (orderedCocktail.equals(CAIPI)) {
            System.out.println(StepsOfCocktaillover.PROSTCAIPI);
        }
        if (orderedCocktail.equals(MOJITO)) {
            System.out.println(StepsOfCocktaillover.PROSTMOJITO);
        }
        if (orderedCocktail.equals(DAIQUIRI)) {
            System.out.println(StepsOfCocktaillover.PROSTDAIQUIRI);
        }
    }
}
