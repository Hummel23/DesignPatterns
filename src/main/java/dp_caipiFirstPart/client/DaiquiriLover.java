package dp_caipiFirstPart.client;


import dp_caipiFinal.subsystem.enums.Cocktail;
import dp_caipiFinal.subsystem.ingredients.*;
import dp_caipiFinal.subsystem.tools.Mixer;
import dp_caipiFirstPart.client.view.StepsOfCocktaillover;

import java.util.List;

import static dp_caipiFinal.subsystem.enums.Cocktail.DAIQUIRI;
import static dp_caipiFinal.subsystem.enums.IngredientName.*;
import static dp_caipiFirstPart.client.view.StepsOfCocktaillover.*;

public class DaiquiriLover extends AbstractCocktailLover {

    Cocktail favouriteCocktail = DAIQUIRI;

    Erdbeeren erdbeeren;
    Limetten limetten;
    Rohrzucker rohrzucker;
    Minze minze;
    CrushedIce crushedIce;
    Rum rum;
    Limettensaft limettensaft;
    Mixer mixer;

    public DaiquiriLover() {
        super();
        this.mixer = new Mixer();

        this.erdbeeren = (Erdbeeren) supermarkt.buyIngredient(Erdbeere);
        boughtNewIngredients(Erdbeere.name());
        this.limetten = (Limetten) supermarkt.buyIngredient(Limette);
        boughtNewIngredients(Limette.name());
        this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker);
        boughtNewIngredients(Rohrzucker.name());
        this.minze = (Minze) supermarkt.buyIngredient(Minze);
        boughtNewIngredients(Minze.name());
        this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce);
        boughtNewIngredients(CrushedIce.name());
        this.rum = (Rum) supermarkt.buyIngredient(Rum);
        boughtNewIngredients(Rum.name());
        this.limettensaft = (dp_caipiFinal.subsystem.ingredients.Limettensaft) supermarkt.buyIngredient(Limettensaft);
        boughtNewIngredients(Limettensaft.name());
    }


    @Override
    public void prepareCocktail(Cocktail cocktail) {
        if (cocktail.equals(favouriteCocktail)) {
            super.prepareCocktail(cocktail);
            prepareDaiquiri();
            enjoyCocktail();
        } else{
            System.out.println(StepsOfCocktaillover.notAbleToPrepareThisCocktail(cocktail));
        }


    }

    private void prepareDaiquiri() {
        //Erdbeere
        erdbeeren.setPortionSize(6);
        if (erdbeeren.isEnoughForCocktail() == false) {
            this.erdbeeren = (Erdbeeren) supermarkt.buyIngredient(Erdbeere);
            boughtNewIngredients(Erdbeere.name());
        }

        Erdbeeren erdbeerenForDaiquiri = (Erdbeeren) erdbeeren.getOnePortionForCocktail();
        ingredientMeasured(Erdbeere.name());

        erdbeerenForDaiquiri.washFruit();
        ingredientWashed(Erdbeere.name());

        mixer.addIngredient(erdbeerenForDaiquiri);
        addedIngredientToMixer(Erdbeere.name());

        //Limettensaft
        limettensaft.setPortionSize(2);
        if (limettensaft.isEnoughForCocktail() == false) {
            this.limettensaft = (Limettensaft) supermarkt.buyIngredient(Limettensaft);
            boughtNewIngredients(Limettensaft.name());
        }

        Limettensaft limettensaftForDaiquiri = (Limettensaft) limettensaft.getOnePortionForCocktail();
        ingredientMeasured(Limettensaft.name());

        mixer.addIngredient(limettensaftForDaiquiri);
        addedIngredientToMixer(Limette.name());

        //Rum
        rum.setPortionSize(5);
        if (rum.isEnoughForCocktail() == false) {
            this.rum = (Rum) supermarkt.buyIngredient(Rum);
            boughtNewIngredients(Rum.name());
        }
        Rum rumForDaiquiri = (Rum) rum.getOnePortionForCocktail();
        ingredientMeasured(Rum.name());

        mixer.addIngredient(rumForDaiquiri);
        addedIngredientToMixer(Rum.name());

        //Rohrzucker
        rohrzucker.setPortionSize(30);
        if (rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker);
            boughtNewIngredients(Rohrzucker.name());
        }
        Rohrzucker rohrzuckerForCaipi = (Rohrzucker) rohrzucker.getOnePortionForCocktail();
        ingredientMeasured(Rohrzucker.name());

        mixer.addIngredient(rohrzuckerForCaipi);
        addedIngredientToMixer(Rohrzucker.name());

        //CrushedIce
        crushedIce.setPortionSize(1);
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce);
            boughtNewIngredients(CrushedIce.name());
        }
        CrushedIce crushedIceForCaipi = (CrushedIce) crushedIce.getOnePortionForCocktail();
        ingredientMeasured(CrushedIce.name());

        mixer.addIngredient(crushedIceForCaipi);
        addedIngredientToMixer(CrushedIce.name());

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
            this.minze = (Minze) supermarkt.buyIngredient(Minze);
            boughtNewIngredients(Minze.name());
        }
        Minze minzeForCaipi = (Minze) minze.getOnePortionForCocktail();
        ingredientMeasured(Minze.name());

        cocktailglas.addIngredient(minzeForCaipi);
        addedIngredientToGlas(Minze.name());
    }
}
