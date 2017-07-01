package dp_caipiExample.client;

import dp_caipiExample.client.interfaces.CocktailLover;
import dp_caipiExample.subsystem.Supermarkt;
import dp_caipiExample.subsystem.tools.Glas;
import dp_caipiExample.subsystem.tools.Stoessel;
import dp_caipiExample.client.view.StepsOfCocktaillover;
import dp_caipiExample.subsystem.ingredients.*;

public class CaipiLover implements CocktailLover {

    private Supermarkt supermarkt;
    private Cacacha cacacha;
    private Limetten limetten;
    private Strohhalme strohhalme;
    private Rohrzucker rohrzucker;
    private Stoessel stoessel;
    private CrushedIce crushedIce;
    private Glas cocktailglas;


    public CaipiLover() {
        this.supermarkt = new Supermarkt();
        this.stoessel = new Stoessel();
        this.cocktailglas = new Glas();
        
        this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha.NAME);
        StepsOfCocktaillover.boughtNewIngredients(Cacacha.NAME);
        this.limetten = (Limetten) supermarkt.buyIngredient(Limetten.NAME);
        StepsOfCocktaillover.boughtNewIngredients(Limetten.NAME);
        this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalme.NAME);
        StepsOfCocktaillover.boughtNewIngredients(Strohhalme.NAME);
        this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker.NAME);
        StepsOfCocktaillover.boughtNewIngredients(Rohrzucker.NAME);
        this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce.NAME);
        StepsOfCocktaillover.boughtNewIngredients(CrushedIce.NAME);
    }

    @Override
    public void prepareCocktail() throws IllegalStateException {

        // Glas
        if (this.cocktailglas.isFull()) {
            this.cocktailglas = new Glas();
        }
        StepsOfCocktaillover.pickedNewGlas();


        //Limetten
        limetten.setPortionSize(1);
        if (limetten.isEnoughForCocktail() == false) {
            this.limetten = (Limetten) supermarkt.buyIngredient(Limetten.NAME);
            StepsOfCocktaillover.boughtNewIngredients(Limetten.NAME);
        }
        Limetten limetteForCaipi = (Limetten) limetten.getOnePortionForCocktail();
        StepsOfCocktaillover.ingredientMeasured(Limetten.NAME);

        limetteForCaipi.washLimette();
        StepsOfCocktaillover.ingredientWashed(Limetten.NAME);

        limetteForCaipi.cutInPieces();
        StepsOfCocktaillover.ingredientCut(Limetten.NAME);

        cocktailglas.addIngredient(limetteForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(Limetten.NAME);


        //crush
        stoessel.crush();
        StepsOfCocktaillover.crushedWithStoessel(Limetten.NAME);


        //Rohrzucker
        rohrzucker.setPortionSize(30);
        if (rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker.NAME);
            StepsOfCocktaillover.boughtNewIngredients(Rohrzucker.NAME);
        }
        Rohrzucker rohrzuckerForCaipi = (Rohrzucker) rohrzucker.getOnePortionForCocktail();
        StepsOfCocktaillover.ingredientMeasured(Rohrzucker.NAME);

        cocktailglas.addIngredient(rohrzuckerForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(Rohrzucker.NAME);


        //Crushed Ice
        crushedIce.setPortionSize(2);
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce.NAME);
            StepsOfCocktaillover.boughtNewIngredients(CrushedIce.NAME);
        }
        CrushedIce crushedIceForCaipi = (CrushedIce) crushedIce.getOnePortionForCocktail();
        StepsOfCocktaillover.ingredientMeasured(CrushedIce.NAME);

        cocktailglas.addIngredient(crushedIceForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(CrushedIce.NAME);


        //crush
        stoessel.crush();
        StepsOfCocktaillover.crushedWithStoessel(CrushedIce.NAME);


        //Cacacha
        cacacha.setPortionSize(5);
        if (cacacha.isEnoughForCocktail() == false) {
            this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha.NAME);
            StepsOfCocktaillover.boughtNewIngredients(Cacacha.NAME);
        }
        Cacacha cacachaForCaipi = (Cacacha) cacacha.getOnePortionForCocktail();
        StepsOfCocktaillover.ingredientMeasured(Cacacha.NAME);

        cocktailglas.addIngredient(cacachaForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(Cacacha.NAME);


        //Strohalm
        strohhalme.setPortionSize(1);
        if (strohhalme.isEnoughForCocktail() == false) {
            this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalme.NAME);
            StepsOfCocktaillover.boughtNewIngredients(Strohhalme.NAME);
        }
        Strohhalme strohhalmeForCaipi = (Strohhalme) strohhalme.getOnePortionForCocktail();
        StepsOfCocktaillover.ingredientMeasured(Strohhalme.NAME);

        cocktailglas.addIngredient(strohhalmeForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(Strohhalme.NAME);
    }


    @Override
    public void enjoyCocktail() {
        System.out.println(StepsOfCocktaillover.PROSTCAIPI);
    }
}
