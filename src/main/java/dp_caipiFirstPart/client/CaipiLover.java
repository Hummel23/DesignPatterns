package dp_caipiFirstPart.client;


import dp_caipiFirstPart.client.view.StepsOfCocktaillover;
import dp_caipiFinal.subsystem.enums.Cocktail;
import dp_caipiFinal.subsystem.ingredients.*;
import dp_caipiFinal.subsystem.tools.Stoessel;

import static dp_caipiFinal.subsystem.enums.Cocktail.CAIPI;
import static dp_caipiFinal.subsystem.enums.IngredientName.*;

public class CaipiLover extends AbstractCocktailLover {

    private Cocktail favouriteCocktail = CAIPI;

    private Cacacha cacacha;
    private Limetten limetten;
    private Strohhalme strohhalme;
    private Rohrzucker rohrzucker;
    private Stoessel stoessel;
    private CrushedIce crushedIce;


    public CaipiLover() {
        super();
        this.stoessel = new Stoessel();

        this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha);
        StepsOfCocktaillover.boughtNewIngredients(Cacacha.name());
        this.limetten = (Limetten) supermarkt.buyIngredient(Limette);
        StepsOfCocktaillover.boughtNewIngredients(Limette.name());
        this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalm);
        StepsOfCocktaillover.boughtNewIngredients(Strohhalm.name());
        this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker);
        StepsOfCocktaillover.boughtNewIngredients(Rohrzucker.name());
        this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce);
        StepsOfCocktaillover.boughtNewIngredients(CrushedIce.name());
    }

    @Override
    public void prepareCocktail(Cocktail cocktail){

        //every Cocktaillover only knows the recipe of the favourite Cocktail
        if (cocktail.equals(favouriteCocktail)) {
            super.prepareCocktail(cocktail);
            prepareCaipi();
            enjoyCocktail();
        } else {
            System.out.println(StepsOfCocktaillover.notAbleToPrepareThisCocktail(cocktail));
        }
    }

    private void prepareCaipi() {
        //Limetten
        limetten.setPortionSize(1);
        if (limetten.isEnoughForCocktail() == false) {
            this.limetten = (Limetten) supermarkt.buyIngredient(Limette);
            StepsOfCocktaillover.boughtNewIngredients(Limette.name());
        }
        Limetten limetteForCaipi = (Limetten) limetten.getOnePortionForCocktail();
        StepsOfCocktaillover.ingredientMeasured(Limette.name());

        limetteForCaipi.washFruit();
        StepsOfCocktaillover.ingredientWashed(Limette.name());

        limetteForCaipi.cutInPieces();
        StepsOfCocktaillover.ingredientCut(Limette.name());

        cocktailglas.addIngredient(limetteForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(Limette.name());


        //crush
        stoessel.crush();
        StepsOfCocktaillover.crushedWithStoessel(Limette.name());


        //Rohrzucker
        rohrzucker.setPortionSize(30);
        if (rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker);
            StepsOfCocktaillover.boughtNewIngredients(Rohrzucker.name());
        }
        Rohrzucker rohrzuckerForCaipi = (Rohrzucker) rohrzucker.getOnePortionForCocktail();
        StepsOfCocktaillover.ingredientMeasured(Rohrzucker.name());

        cocktailglas.addIngredient(rohrzuckerForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(Rohrzucker.name());


        //Crushed Ice
        crushedIce.setPortionSize(2);
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce);
            StepsOfCocktaillover.boughtNewIngredients(CrushedIce.name());
        }
        CrushedIce crushedIceForCaipi = (CrushedIce) crushedIce.getOnePortionForCocktail();
        StepsOfCocktaillover.ingredientMeasured(CrushedIce.name());

        cocktailglas.addIngredient(crushedIceForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(CrushedIce.name());


        //crush
        stoessel.crush();
        StepsOfCocktaillover.crushedWithStoessel(CrushedIce.name());


        //Cacacha
        cacacha.setPortionSize(5);
        if (cacacha.isEnoughForCocktail() == false) {
            this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha);
            StepsOfCocktaillover.boughtNewIngredients(Cacacha.name());
        }
        Cacacha cacachaForCaipi = (Cacacha) cacacha.getOnePortionForCocktail();
        StepsOfCocktaillover.ingredientMeasured(Cacacha.name());

        cocktailglas.addIngredient(cacachaForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(Cacacha.name());


        //Strohalm
        strohhalme.setPortionSize(1);
        if (strohhalme.isEnoughForCocktail() == false) {
            this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalm);
            StepsOfCocktaillover.boughtNewIngredients(Strohhalm.name());
        }
        Strohhalme strohhalmeForCaipi = (Strohhalme) strohhalme.getOnePortionForCocktail();
        StepsOfCocktaillover.ingredientMeasured(Strohhalm.name());

        cocktailglas.addIngredient(strohhalmeForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(Strohhalm.name());
    }

}
