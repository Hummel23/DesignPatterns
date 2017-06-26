package dp_caipiExample.client;

import dp_caipiExample.client.interfaces.CocktailLover;
import dp_caipiExample.subsystem.Supermarkt;
import dp_caipiExample.subsystem.tools.Glas;
import dp_caipiExample.subsystem.tools.Stoessel;
import dp_caipiExample.client.view.ViewElements;
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
        ViewElements.boughtNewIngredients(cacacha.getName());
        this.limetten = supermarkt.buyLimetten(5);
        ViewElements.boughtNewIngredients(limetten.get(0).getName());
        this.strohhalme = supermarkt.buyStrohalme();
        ViewElements.boughtNewIngredients(strohhalme.get(0).getName());
        this.rohrzucker = supermarkt.buyRohrzucker();
        ViewElements.boughtNewIngredients(rohrzucker.getName());
        this.crushedIce = supermarkt.buyCrushedIce();
        ViewElements.boughtNewIngredients(crushedIce.getName());
    }

    @Override
    public void prepareCocktail() throws IllegalStateException {

        // Glas
        if (this.cocktailglas.isFull()) {
            this.cocktailglas = new Glas();
        }
        ViewElements.pickedNewGlas();

        //Limette
        Limette limetteForCaipi = pickLimette();
        washLimette(limetteForCaipi);
        cutLimette(limetteForCaipi);
        cocktailglas.addIngredient(limetteForCaipi);
        ViewElements.addedIngredientToGlas(limetteForCaipi.getName());

        //crush
        stoessel.crush();
        ViewElements.crushedWithStoessel(limetteForCaipi.getName());

        //Rohrzucker
        Rohrzucker rohrzuckerForCaipi = measureRohrzucker();
        cocktailglas.addIngredient(rohrzuckerForCaipi);
        ViewElements.addedIngredientToGlas(rohrzuckerForCaipi.getName());

        //Crushed Ice
        CrushedIce crushedIceForCaipi = measureCrushedIce();
        cocktailglas.addIngredient(crushedIceForCaipi);
        ViewElements.addedIngredientToGlas(crushedIceForCaipi.getName());

        //crush
        stoessel.crush();
        ViewElements.crushedWithStoessel(crushedIceForCaipi.getName());

        //Cacacha
        Cacacha cacachaForCaipi = measureCacacha();
        cocktailglas.addIngredient(cacachaForCaipi);
        ViewElements.addedIngredientToGlas(cacachaForCaipi.getName());

        //Strohalm
        Strohhalm strohhalmForCaipi = pickStrohalm();
        cocktailglas.addIngredient(strohhalmForCaipi);
        ViewElements.addedIngredientToGlas(strohhalmForCaipi.getName());
    }


    @Override
    public void enjoyCocktail() {
        System.out.println(ViewElements.PROSTCAIPI);
    }

    private Limette pickLimette() {
        if (limetten.size() == 0) {
            this.limetten = supermarkt.buyLimetten(5);
            ViewElements.boughtNewIngredients(limetten.get(0).getName());
            return pickLimette();
        }
        Limette limetteForCaipi = limetten.get(0);
        limetten.remove(0);
        ViewElements.ingredientMeasured(limetteForCaipi.getName());

        return limetteForCaipi;
    }

    private void washLimette(Limette limette) {
        limette.washWithWarmWater();
        ViewElements.ingredientWashed(limette.getName());
    }

    private void cutLimette(Limette limette) {
        limette.cutInPieces();
        ViewElements.ingredientCut(limette.getName());
    }

    private Rohrzucker measureRohrzucker() {
       if(rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = supermarkt.buyRohrzucker();
            ViewElements.boughtNewIngredients(rohrzucker.getName());
            return measureRohrzucker();
        }

        ViewElements.ingredientMeasured(rohrzucker.getName());
        return rohrzucker.getTL(3);
    }

    private CrushedIce measureCrushedIce() {
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = supermarkt.buyCrushedIce();
            ViewElements.boughtNewIngredients(crushedIce.getName());
            return measureCrushedIce();
        }
        ViewElements.ingredientMeasured(crushedIce.getName());
        return crushedIce.getPortion();
    }

    private Cacacha measureCacacha() {
        if (cacacha.isEnoughForCocktail() == false) {
            this.cacacha = supermarkt.buyCacacha();
            ViewElements.boughtNewIngredients(cacacha.getName());
            return measureCacacha();
        }
        ViewElements.ingredientMeasured(cacacha.getName());
        return cacacha.get5CL();
    }

    private Strohhalm pickStrohalm() {
        if (strohhalme.size() == 0) {
            this.strohhalme = supermarkt.buyStrohalme();
            ViewElements.boughtNewIngredients(strohhalme.get(0).getName());
            return pickStrohalm();
        }
        Strohhalm strohhalmForCaipi = strohhalme.get(0);
        strohhalme.remove(0);

        ViewElements.ingredientMeasured(strohhalmForCaipi.getName());
        return strohhalmForCaipi;
    }
}
