package dp_caipiFinal.client;


import dp_caipiFinal.subsystem.ingredients.*;
import dp_caipiFinal.subsystem.tools.Stoessel;

import static dp_caipiFinal.client.view.StepsOfCocktaillover.*;

public class MojitoLover extends AbstractCocktailLover {
    
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
        this.limetten = (Limetten) supermarkt.buyIngredient(Limetten.NAME);
        boughtNewIngredients(Limetten.NAME);
        this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce.NAME);
        boughtNewIngredients(CrushedIce.NAME);
        this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker.NAME);
        boughtNewIngredients(Rohrzucker.NAME);
        this.minze = (Minze) supermarkt.buyIngredient(Minze.NAME);
        boughtNewIngredients(Minze.NAME);
        this.rum = (Rum) supermarkt.buyIngredient(Rum.NAME);
        boughtNewIngredients(Rum.NAME);
        this.soda = (Soda) supermarkt.buyIngredient(Soda.NAME);
        boughtNewIngredients(Soda.NAME);
        this.strohhalme= (Strohhalme) supermarkt.buyIngredient(Strohhalme.NAME);
        boughtNewIngredients(Strohhalme.NAME);
    }
    

    @Override
    public void prepareCocktail() {
        super.prepareCocktail();

        //Limetten
        limetten.setPortionSize(1);
        if (limetten.isEnoughForCocktail() == false) {
            this.limetten = (Limetten) supermarkt.buyIngredient(Limetten.NAME);
            boughtNewIngredients(Limetten.NAME);
        }
        Limetten limetteForMojito = (Limetten) limetten.getOnePortionForCocktail();
        ingredientMeasured(Limetten.NAME);

        limetteForMojito.washLimette();
        ingredientWashed(Limetten.NAME);

        limetteForMojito.cutInPieces();
        ingredientCut(Limetten.NAME);

        cocktailglas.addIngredient(limetteForMojito);
        addedIngredientToGlas(Limetten.NAME);

        //Rohrzucker
        rohrzucker.setPortionSize(20);
        if (rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker.NAME);
            boughtNewIngredients(Rohrzucker.NAME);
        }
        Rohrzucker rohrzuckerForMojito = (Rohrzucker) rohrzucker.getOnePortionForCocktail();
        ingredientMeasured(Rohrzucker.NAME);

        cocktailglas.addIngredient(rohrzuckerForMojito);
        addedIngredientToGlas(Rohrzucker.NAME);

        //Minze
        minze.setPortionSize(8);
        if (minze.isEnoughForCocktail() == false) {
            this.minze = (Minze) supermarkt.buyIngredient(Minze.NAME);
            boughtNewIngredients(Minze.NAME);
        }
        Minze minzeForMojito = (Minze) minze.getOnePortionForCocktail();
        ingredientMeasured(Minze.NAME);

        cocktailglas.addIngredient(minzeForMojito);
        addedIngredientToGlas(Minze.NAME);
        
        //crush
        stoessel.crush();
        crushedWithStoessel(Minze.NAME, Limetten.NAME);
        
        //crushed Ice
        crushedIce.setPortionSize(2);
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce.NAME);
            boughtNewIngredients(CrushedIce.NAME);
        }
        CrushedIce crushedIceForMojito = (CrushedIce) crushedIce.getOnePortionForCocktail();
        ingredientMeasured(CrushedIce.NAME);

        cocktailglas.addIngredient(crushedIceForMojito);
        addedIngredientToGlas(CrushedIce.NAME);

        //Rum
        rum.setPortionSize(5);
        if (rum.isEnoughForCocktail() == false) {
            this.rum = (Rum) supermarkt.buyIngredient(Rum.NAME);
            boughtNewIngredients(Rum.NAME);
        }
        Rum rumForCaipi = (Rum) rum.getOnePortionForCocktail();
        ingredientMeasured(Rum.NAME);

        cocktailglas.addIngredient(rumForCaipi);
        addedIngredientToGlas(Rum.NAME);

        //Soda
        soda.setPortionSize(150);
        if (soda.isEnoughForCocktail() == false) {
            this.soda = (Soda) supermarkt.buyIngredient(Soda.NAME);
            boughtNewIngredients(Soda.NAME);
        }
        Soda sodaForCaipi = (Soda) soda.getOnePortionForCocktail();
        ingredientMeasured(Soda.NAME);

        cocktailglas.addIngredient(sodaForCaipi);
        addedIngredientToGlas(Soda.NAME);

        //Strohalm
        strohhalme.setPortionSize(1);
        if (strohhalme.isEnoughForCocktail() == false) {
            this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalme.NAME);
            boughtNewIngredients(Strohhalme.NAME);
        }
        Strohhalme strohhalmeForCaipi = (Strohhalme) strohhalme.getOnePortionForCocktail();
        ingredientMeasured(Strohhalme.NAME);

        cocktailglas.addIngredient(strohhalmeForCaipi);
        addedIngredientToGlas(Strohhalme.NAME);

    }

    @Override
    public void enjoyCocktail() {
        System.out.println(PROSTMOJITO);
    }
}
