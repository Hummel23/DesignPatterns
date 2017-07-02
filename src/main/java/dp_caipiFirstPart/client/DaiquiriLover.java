package dp_caipiFirstPart.client;


import dp_caipiFirstPart.subsystem.ingredients.*;
import dp_caipiFirstPart.subsystem.tools.Mixer;

import java.util.List;

import static dp_caipiFirstPart.client.view.StepsOfCocktaillover.*;

public class DaiquiriLover extends AbstractCocktailLover {

    Erdbeeren erdbeeren;
    Limetten limetten;
    Rohrzucker rohrzucker;
    Minze minze;
    CrushedIce crushedIce;
    Rum rum;
    Mixer mixer;

    public DaiquiriLover() {
        super();
        this.mixer = new Mixer();

        this.erdbeeren = (Erdbeeren) supermarkt.buyIngredient(Erdbeeren.NAME);
        boughtNewIngredients(Erdbeeren.NAME);

        this.limetten = (Limetten) supermarkt.buyIngredient(Limetten.NAME);
        this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker.NAME);
        this.minze = (Minze) supermarkt.buyIngredient(Minze.NAME);
        this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce.NAME);
        this.rum = (Rum) supermarkt.buyIngredient(Rum.NAME);
    }


    @Override
    public void prepareCocktail() {
        super.prepareCocktail();

        //Erdbeeren
        erdbeeren.setPortionSize(6);
        if (erdbeeren.isEnoughForCocktail() == false) {
            this.erdbeeren = (Erdbeeren) supermarkt.buyIngredient(Erdbeeren.NAME);
            boughtNewIngredients(Erdbeeren.NAME);
        }

        Erdbeeren erdbeerenForDaiquiri = (Erdbeeren) erdbeeren.getOnePortionForCocktail();
        ingredientMeasured(Erdbeeren.NAME);

        erdbeerenForDaiquiri.washErdbeere();
        ingredientWashed(Erdbeeren.NAME);

        mixer.addIngredient(erdbeerenForDaiquiri);
        addedIngredientToMixer(Erdbeeren.NAME);

        //Limetten
        limetten.setPortionSize(2);
        if (limetten.isEnoughForCocktail() == false) {
            this.limetten = (Limetten) supermarkt.buyIngredient(Limetten.NAME);
            boughtNewIngredients(Erdbeeren.NAME);
        }

        Limetten limettenForDaiquiri = (Limetten) limetten.getOnePortionForCocktail();
        ingredientMeasured(Limetten.NAME);

        limettenForDaiquiri.squeezeLimetten();
        limettenSqueezed(2);

        mixer.addIngredient(limettenForDaiquiri);
        addedIngredientToMixer(Limetten.NAME);

        //Rum
        rum.setPortionSize(5);
        if (rum.isEnoughForCocktail() == false) {
            this.rum = (Rum) supermarkt.buyIngredient(Rum.NAME);
            boughtNewIngredients(Rum.NAME);
        }
        Rum rumForDaiquiri = (Rum) rum.getOnePortionForCocktail();
        ingredientMeasured(Rum.NAME);

        mixer.addIngredient(rumForDaiquiri);
        addedIngredientToMixer(Rum.NAME);

        //Rohrzucker
        rohrzucker.setPortionSize(30);
        if (rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker.NAME);
            boughtNewIngredients(Rohrzucker.NAME);
        }
        Rohrzucker rohrzuckerForCaipi = (Rohrzucker) rohrzucker.getOnePortionForCocktail();
        ingredientMeasured(Rohrzucker.NAME);

        mixer.addIngredient(rohrzuckerForCaipi);
        addedIngredientToMixer(Rohrzucker.NAME);

        //CrushedIce
        crushedIce.setPortionSize(1);
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce.NAME);
            boughtNewIngredients(CrushedIce.NAME);
        }
        CrushedIce crushedIceForCaipi = (CrushedIce) crushedIce.getOnePortionForCocktail();
        ingredientMeasured(CrushedIce.NAME);

        mixer.addIngredient(crushedIceForCaipi);
        addedIngredientToMixer(CrushedIce.NAME);
        
        mixer.mixIngredients();
        mixedIngredients();

        List<AbstractCocktailIngredient> ingredients = mixer.getIngredients();
        for (AbstractCocktailIngredient ingredient : ingredients) {
            cocktailglas.addIngredient(ingredient);
        }
        pouredCocktailFromMixerToGlas();

        //Minze
        minze.setPortionSize(3);
        if (minze.isEnoughForCocktail() == false) {
            this.minze = (Minze) supermarkt.buyIngredient(Minze.NAME);
            boughtNewIngredients(Minze.NAME);
        }
        Minze minzeForCaipi = (Minze) minze.getOnePortionForCocktail();
        ingredientMeasured(Minze.NAME);

        cocktailglas.addIngredient(minzeForCaipi);
        addedIngredientToGlas(Minze.NAME);

    }

    @Override
    public void enjoyCocktail() {
        System.out.println(PROSTDAIQUIRI);
    }
}
