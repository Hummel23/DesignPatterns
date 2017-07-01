package dp_caipiFinal.client;


import dp_caipiFinal.subsystem.ingredients.*;
import dp_caipiFinal.subsystem.tools.Stoessel;

import static dp_caipiFinal.client.view.StepsOfCocktaillover.*;

public class CaipiLover extends AbstractCocktailLover {

    private Cacacha cacacha;
    private Limetten limetten;
    private Strohhalme strohhalme;
    private Rohrzucker rohrzucker;
    private Stoessel stoessel;
    private CrushedIce crushedIce;


    public CaipiLover() {
        super();
        this.stoessel = new Stoessel();

        this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha.NAME);
        boughtNewIngredients(Cacacha.NAME);
        this.limetten = (Limetten) supermarkt.buyIngredient(Limetten.NAME);
        boughtNewIngredients(Limetten.NAME);
        this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalme.NAME);
        boughtNewIngredients(Strohhalme.NAME);
        this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker.NAME);
        boughtNewIngredients(Rohrzucker.NAME);
        this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce.NAME);
        boughtNewIngredients(CrushedIce.NAME);
    }

    @Override
    public void prepareCocktail() throws IllegalStateException {
        super.prepareCocktail();

        //Limetten
        limetten.setPortionSize(1);
        if (limetten.isEnoughForCocktail() == false) {
            this.limetten = (Limetten) supermarkt.buyIngredient(Limetten.NAME);
            boughtNewIngredients(Limetten.NAME);
        }
        Limetten limetteForCaipi = (Limetten) limetten.getOnePortionForCocktail();
        ingredientMeasured(Limetten.NAME);

        limetteForCaipi.washLimette();
        ingredientWashed(Limetten.NAME);

        limetteForCaipi.cutInPieces();
        ingredientCut(Limetten.NAME);

        cocktailglas.addIngredient(limetteForCaipi);
        addedIngredientToGlas(Limetten.NAME);


        //crush
        stoessel.crush();
        crushedWithStoessel(Limetten.NAME);


        //Rohrzucker
        rohrzucker.setPortionSize(20);
        if (rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker.NAME);
            boughtNewIngredients(Rohrzucker.NAME);
        }
        Rohrzucker rohrzuckerForCaipi = (Rohrzucker) rohrzucker.getOnePortionForCocktail();
        ingredientMeasured(Rohrzucker.NAME);

        cocktailglas.addIngredient(rohrzuckerForCaipi);
        addedIngredientToGlas(Rohrzucker.NAME);


        //Crushed Ice
        crushedIce.setPortionSize(2);
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce.NAME);
            boughtNewIngredients(CrushedIce.NAME);
        }
        CrushedIce crushedIceForCaipi = (CrushedIce) crushedIce.getOnePortionForCocktail();
        ingredientMeasured(CrushedIce.NAME);

        cocktailglas.addIngredient(crushedIceForCaipi);
        addedIngredientToGlas(CrushedIce.NAME);


        //crush
        stoessel.crush();
        crushedWithStoessel(CrushedIce.NAME);


        //Cacacha
        cacacha.setPortionSize(5);
        if (cacacha.isEnoughForCocktail() == false) {
            this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha.NAME);
            boughtNewIngredients(Cacacha.NAME);
        }
        Cacacha cacachaForCaipi = (Cacacha) cacacha.getOnePortionForCocktail();
        ingredientMeasured(Cacacha.NAME);

        cocktailglas.addIngredient(cacachaForCaipi);
        addedIngredientToGlas(Cacacha.NAME);


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
        System.out.println(PROSTCAIPI);
    }

}
