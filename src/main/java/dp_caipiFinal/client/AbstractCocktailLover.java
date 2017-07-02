package dp_caipiFinal.client;


import dp_caipiFinal.client.view.StepsOfCocktaillover;
import dp_caipiFinal.fassade.Barkeeper;
import dp_caipiFinal.fassade.Cocktail;

public abstract class AbstractCocktailLover {

    Barkeeper barkeeper;

    public AbstractCocktailLover() {
        this.barkeeper = new Barkeeper();

    }

    public void orderCocktail(Cocktail cocktail){
        barkeeper.prepareCocktail(cocktail);
        StepsOfCocktaillover.orderedACocktail(cocktail);
    }

    public void enjoyCocktail(){
        System.out.println("Prost!");
    }
}
