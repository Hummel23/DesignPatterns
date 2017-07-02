package dp_caipiFirstPart.client;


import dp_caipiFinal.subsystem.ingredients.*;
import dp_caipiFinal.subsystem.tools.Stoessel;

import static dp_caipiFinal.subsystem.enums.IngredientName.*;
import static dp_caipiFirstPart.client.view.StepsOfCocktaillover.*;

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

        this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha);
        boughtNewIngredients(Cacacha.name());
        this.limetten = (Limetten) supermarkt.buyIngredient(Limette);
        boughtNewIngredients(Limette.name());
        this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalm);
        boughtNewIngredients(Strohhalm.name());
        this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker);
        boughtNewIngredients(Rohrzucker.name());
        this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce);
        boughtNewIngredients(CrushedIce.name());
    }

    @Override
    public void prepareCocktail() throws IllegalStateException {
        super.prepareCocktail();

        //Limetten
        limetten.setPortionSize(1);
        if (limetten.isEnoughForCocktail() == false) {
            this.limetten = (Limetten) supermarkt.buyIngredient(Limette);
            boughtNewIngredients(Limette.name());
        }
        Limetten limetteForCaipi = (Limetten) limetten.getOnePortionForCocktail();
        ingredientMeasured(Limette.name());

        limetteForCaipi.washFruit();
        ingredientWashed(Limette.name());

        limetteForCaipi.cutInPieces();
        ingredientCut(Limette.name());

        cocktailglas.addIngredient(limetteForCaipi);
        addedIngredientToGlas(Limette.name());


        //crush
        stoessel.crush();
        crushedWithStoessel(Limette.name());


        //Rohrzucker
        rohrzucker.setPortionSize(20);
        if (rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker);
            boughtNewIngredients(Rohrzucker.name());
        }
        Rohrzucker rohrzuckerForCaipi = (Rohrzucker) rohrzucker.getOnePortionForCocktail();
        ingredientMeasured(Rohrzucker.name());

        cocktailglas.addIngredient(rohrzuckerForCaipi);
        addedIngredientToGlas(Rohrzucker.name());


        //Crushed Ice
        crushedIce.setPortionSize(2);
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce);
            boughtNewIngredients(CrushedIce.name());
        }
        CrushedIce crushedIceForCaipi = (CrushedIce) crushedIce.getOnePortionForCocktail();
        ingredientMeasured(CrushedIce.name());

        cocktailglas.addIngredient(crushedIceForCaipi);
        addedIngredientToGlas(CrushedIce.name());


        //crush
        stoessel.crush();
        crushedWithStoessel(CrushedIce.name());


        //Cacacha
        cacacha.setPortionSize(5);
        if (cacacha.isEnoughForCocktail() == false) {
            this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha);
            boughtNewIngredients(Cacacha.name());
        }
        Cacacha cacachaForCaipi = (Cacacha) cacacha.getOnePortionForCocktail();
        ingredientMeasured(Cacacha.name());

        cocktailglas.addIngredient(cacachaForCaipi);
        addedIngredientToGlas(Cacacha.name());


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


    @Override
    public void enjoyCocktail() {
        System.out.println(PROSTCAIPI);
    }

}
