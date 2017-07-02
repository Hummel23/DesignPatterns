package dp_caipiFirstPart.client;

import dp_caipiFinal.subsystem.enums.Cocktail;
import dp_caipiFirstPart.client.view.StepsOfCocktaillover;
import dp_caipiFinal.subsystem.Supermarkt;
import dp_caipiFinal.subsystem.tools.Glas;

import static dp_caipiFinal.subsystem.enums.Cocktail.CAIPI;
import static dp_caipiFinal.subsystem.enums.Cocktail.DAIQUIRI;
import static dp_caipiFinal.subsystem.enums.Cocktail.MOJITO;

public abstract class AbstractCocktailLover {
    Supermarkt supermarkt;
    Glas cocktailglas;
    Cocktail orderedCocktail;

    public AbstractCocktailLover() {
        supermarkt = new Supermarkt();
        cocktailglas = new Glas();

    }

    public void prepareCocktail(Cocktail cocktail){

        this.orderedCocktail = cocktail;
        // Glas
        if (this.cocktailglas.isFull()) {
            this.cocktailglas = new Glas();
        }
        StepsOfCocktaillover.pickedNewGlas();
    }

    public void enjoyCocktail(){
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
