package dp_caipiFirstPart.client;

import dp_caipiFirstPart.client.view.StepsOfCocktaillover;
import dp_caipiFirstPart.subsystem.Supermarkt;
import dp_caipiFirstPart.subsystem.tools.Glas;

public abstract class AbstractCocktailLover {
    Supermarkt supermarkt;
    Glas cocktailglas;

    public AbstractCocktailLover() {
        supermarkt = new Supermarkt();
        cocktailglas = new Glas();

    }

    public void prepareCocktail(){

        // Glas
        if (this.cocktailglas.isFull()) {
            this.cocktailglas = new Glas();
        }
        StepsOfCocktaillover.pickedNewGlas();
    }

    public void enjoyCocktail(){
        System.out.println("Prost!");
    }
}
