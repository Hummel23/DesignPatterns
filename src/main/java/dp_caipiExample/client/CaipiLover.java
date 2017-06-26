package dp_caipiExample.client;

import dp_caipiExample.client.interfaces.CocktailLover;
import dp_caipiExample.subsystem.Supermarkt;
import dp_caipiExample.subsystem.tools.Glas;
import dp_caipiExample.subsystem.tools.Stoessel;
import dp_caipiExample.client.view.StepsOfCocktaillover;
import dp_caipiExample.subsystem.ingredients.*;

import java.util.List;

public class CaipiLover implements CocktailLover {

    private Supermarkt supermarkt;
    private Cacacha cacacha;
    private List<Limette> limetten;
    private List<Strohhalm> strohhalme;
    private Rohrzucker rohrzucker;
    private Stoessel stoessel;
    private CrushedIce crushedIce;
    private Glas cocktailglas;


    public CaipiLover() {
        this.supermarkt = new Supermarkt();
        this.stoessel = new Stoessel();
        this.cocktailglas = new Glas();
        this.cacacha = supermarkt.buyCacacha();
        StepsOfCocktaillover.boughtNewIngredients(cacacha.getName());
        this.limetten = supermarkt.buyLimetten(5);
        StepsOfCocktaillover.boughtNewIngredients(limetten.get(0).getName());
        this.strohhalme = supermarkt.buyStrohalme();
        StepsOfCocktaillover.boughtNewIngredients(strohhalme.get(0).getName());
        this.rohrzucker = supermarkt.buyRohrzucker();
        StepsOfCocktaillover.boughtNewIngredients(rohrzucker.getName());
        this.crushedIce = supermarkt.buyCrushedIce();
        StepsOfCocktaillover.boughtNewIngredients(crushedIce.getName());
    }

    @Override
    public void prepareCocktail() throws IllegalStateException {

        // Glas
        if (this.cocktailglas.isFull()) {
            this.cocktailglas = new Glas();
        }
        StepsOfCocktaillover.pickedNewGlas();

        //Limette
        Limette limetteForCaipi = pickLimette();
        washLimette(limetteForCaipi);
        cutLimette(limetteForCaipi);
        cocktailglas.addIngredient(limetteForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(limetteForCaipi.getName());

        //crush
        stoessel.crush();
        StepsOfCocktaillover.crushedWithStoessel(limetteForCaipi.getName());

        //Rohrzucker
        Rohrzucker rohrzuckerForCaipi = measureRohrzucker();
        cocktailglas.addIngredient(rohrzuckerForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(rohrzuckerForCaipi.getName());

        //Crushed Ice
        CrushedIce crushedIceForCaipi = measureCrushedIce();
        cocktailglas.addIngredient(crushedIceForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(crushedIceForCaipi.getName());

        //crush
        stoessel.crush();
        StepsOfCocktaillover.crushedWithStoessel(crushedIceForCaipi.getName());

        //Cacacha
        Cacacha cacachaForCaipi = measureCacacha();
        cocktailglas.addIngredient(cacachaForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(cacachaForCaipi.getName());

        //Strohalm
        Strohhalm strohhalmForCaipi = pickStrohalm();
        cocktailglas.addIngredient(strohhalmForCaipi);
        StepsOfCocktaillover.addedIngredientToGlas(strohhalmForCaipi.getName());
    }


    @Override
    public void enjoyCocktail() {
        System.out.println(StepsOfCocktaillover.PROSTCAIPI);
    }

    private Limette pickLimette() {
        if (limetten.size() == 0) {
            this.limetten = supermarkt.buyLimetten(5);
            StepsOfCocktaillover.boughtNewIngredients(limetten.get(0).getName());
            return pickLimette();
        }
        Limette limetteForCaipi = limetten.get(0);
        limetten.remove(0);
        StepsOfCocktaillover.ingredientMeasured(limetteForCaipi.getName());

        return limetteForCaipi;
    }

    private void washLimette(Limette limette) {
        limette.washWithWarmWater();
        StepsOfCocktaillover.ingredientWashed(limette.getName());
    }

    private void cutLimette(Limette limette) {
        limette.cutInPieces();
        StepsOfCocktaillover.ingredientCut(limette.getName());
    }

    private Rohrzucker measureRohrzucker() {
       if(rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = supermarkt.buyRohrzucker();
            StepsOfCocktaillover.boughtNewIngredients(rohrzucker.getName());
            return measureRohrzucker();
        }

        StepsOfCocktaillover.ingredientMeasured(rohrzucker.getName());
        return rohrzucker.getTL(3);
    }

    private CrushedIce measureCrushedIce() {
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = supermarkt.buyCrushedIce();
            StepsOfCocktaillover.boughtNewIngredients(crushedIce.getName());
            return measureCrushedIce();
        }
        StepsOfCocktaillover.ingredientMeasured(crushedIce.getName());
        return crushedIce.getPortion();
    }

    private Cacacha measureCacacha() {
        if (cacacha.isEnoughForCocktail() == false) {
            this.cacacha = supermarkt.buyCacacha();
            StepsOfCocktaillover.boughtNewIngredients(cacacha.getName());
            return measureCacacha();
        }
        StepsOfCocktaillover.ingredientMeasured(cacacha.getName());
        return cacacha.get5CL();
    }

    private Strohhalm pickStrohalm() {
        if (strohhalme.size() == 0) {
            this.strohhalme = supermarkt.buyStrohalme();
            StepsOfCocktaillover.boughtNewIngredients(strohhalme.get(0).getName());
            return pickStrohalm();
        }
        Strohhalm strohhalmForCaipi = strohhalme.get(0);
        strohhalme.remove(0);

        StepsOfCocktaillover.ingredientMeasured(strohhalmForCaipi.getName());
        return strohhalmForCaipi;
    }
}
