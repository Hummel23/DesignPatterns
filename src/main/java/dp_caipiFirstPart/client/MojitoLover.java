package dp_caipiFirstPart.client;


import dp_caipiFinal.subsystem.enums.Cocktail;
import dp_caipiFinal.subsystem.ingredients.*;
import dp_caipiFinal.subsystem.tools.Stoessel;
import dp_caipiFirstPart.client.view.StepsOfCocktaillover;

import static dp_caipiFinal.subsystem.enums.Cocktail.MOJITO;
import static dp_caipiFinal.subsystem.enums.IngredientName.*;
import static dp_caipiFirstPart.client.view.StepsOfCocktaillover.*;

public class MojitoLover extends AbstractCocktailLover {

    Cocktail favouriteCocktail = MOJITO;

    Limetten limetten;
    Rohrzucker rohrzucker;
    Minze minze;
    CrushedIce crushedIce;
    Rum rum;
    Soda soda;
    Stoessel stoessel;
    Strohhalme strohhalme;

    public MojitoLover() {
        super();

        this.stoessel = new Stoessel();
        this.limetten = (Limetten) supermarkt.buyIngredient(Limette);
        boughtNewIngredients(Limette.name());
        this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce);
        boughtNewIngredients(CrushedIce.name());
        this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker);
        boughtNewIngredients(Rohrzucker.name());
        this.minze = (Minze) supermarkt.buyIngredient(Minze);
        boughtNewIngredients(Minze.name());
        this.rum = (Rum) supermarkt.buyIngredient(Rum);
        boughtNewIngredients(Rum.name());
        this.soda = (Soda) supermarkt.buyIngredient(Soda);
        boughtNewIngredients(Soda.name());
        this.strohhalme= (Strohhalme) supermarkt.buyIngredient(Strohhalm);
        boughtNewIngredients(Strohhalm.name());
    }
    

    @Override
    public void prepareCocktail(Cocktail cocktail) {
        if (cocktail.equals(favouriteCocktail)) {
            super.prepareCocktail(cocktail);
            prepareMojito();
            enjoyCocktail();
        } else{
            System.out.println(StepsOfCocktaillover.notAbleToPrepareThisCocktail(cocktail));
        }
    }

    private void prepareMojito() {
        //Limetten
        limetten.setPortionSize(1);
        if (limetten.isEnoughForCocktail() == false) {
            this.limetten = (Limetten) supermarkt.buyIngredient(Limette);
            boughtNewIngredients(Limette.name());
        }
        Limetten limetteForMojito = (Limetten) limetten.getOnePortionForCocktail();
        ingredientMeasured(Limette.name());

        limetteForMojito.washFruit();
        ingredientWashed(Limette.name());

        limetteForMojito.cutInPieces();
        ingredientCut(Limette.name());

        cocktailglas.addIngredient(limetteForMojito);
        addedIngredientToGlas(Limette.name());

        //Rohrzucker
        rohrzucker.setPortionSize(20);
        if (rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker);
            boughtNewIngredients(Rohrzucker.name());
        }
        Rohrzucker rohrzuckerForMojito = (Rohrzucker) rohrzucker.getOnePortionForCocktail();
        ingredientMeasured(Rohrzucker.name());

        cocktailglas.addIngredient(rohrzuckerForMojito);
        addedIngredientToGlas(Rohrzucker.name());

        //Minze
        minze.setPortionSize(8);
        if (minze.isEnoughForCocktail() == false) {
            this.minze = (Minze) supermarkt.buyIngredient(Minze);
            boughtNewIngredients(Minze.name());
        }
        Minze minzeForMojito = (Minze) minze.getOnePortionForCocktail();
        ingredientMeasured(Minze.name());

        cocktailglas.addIngredient(minzeForMojito);
        addedIngredientToGlas(Minze.name());

        //crush
        stoessel.crush();
        crushedWithStoessel(Minze.name(), Limette.name());

        //crushed Ice
        crushedIce.setPortionSize(2);
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce);
            boughtNewIngredients(CrushedIce.name());
        }
        CrushedIce crushedIceForMojito = (CrushedIce) crushedIce.getOnePortionForCocktail();
        ingredientMeasured(CrushedIce.name());

        cocktailglas.addIngredient(crushedIceForMojito);
        addedIngredientToGlas(CrushedIce.name());

        //Rum
        rum.setPortionSize(5);
        if (rum.isEnoughForCocktail() == false) {
            this.rum = (Rum) supermarkt.buyIngredient(Rum);
            boughtNewIngredients(Rum.name());
        }
        Rum rumForCaipi = (Rum) rum.getOnePortionForCocktail();
        ingredientMeasured(Rum.name());

        cocktailglas.addIngredient(rumForCaipi);
        addedIngredientToGlas(Rum.name());

        //Soda
        soda.setPortionSize(150);
        if (soda.isEnoughForCocktail() == false) {
            this.soda = (Soda) supermarkt.buyIngredient(Soda);
            boughtNewIngredients(Soda.name());
        }
        Soda sodaForCaipi = (Soda) soda.getOnePortionForCocktail();
        ingredientMeasured(Soda.name());

        cocktailglas.addIngredient(sodaForCaipi);
        addedIngredientToGlas(Soda.name());

        //Strohalm
        strohhalme.setPortionSize(1);
        if (strohhalme.isEnoughForCocktail() == false) {
            this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalm);
            boughtNewIngredients(Strohhalm.name());
        }
        Strohhalme strohhalmeForCaipi = (Strohhalme) strohhalme.getOnePortionForCocktail();
        ingredientMeasured(Strohhalm.name());

        cocktailglas.addIngredient(strohhalmeForCaipi);
        addedIngredientToGlas(Strohhalm.name());
    }
}
