package dp_caipiFinal.fassade;

import dp_caipiFinal.subsystem.Supermarkt;
import dp_caipiFinal.subsystem.ingredients.*;
import dp_caipiFinal.subsystem.tools.Glas;
import dp_caipiFinal.subsystem.tools.Mixer;
import dp_caipiFinal.subsystem.tools.Stoessel;

public class Barkeeper {

    private Supermarkt supermarkt;
    private Glas cocktailglas;
    private Mixer mixer;
    private Stoessel stoessel;
    
    private Cacacha cacacha;
    private Rum rum;
    private Soda soda;
    
    private Limetten limetten;
    private Erdbeeren erdbeeren;
    private Minze minze;
    
    private Strohhalme strohhalme;
    private Rohrzucker rohrzucker;
    private CrushedIce crushedIce;

    public Barkeeper() {
        this.supermarkt = new Supermarkt();
        this.cocktailglas = new Glas();
        this.mixer = new Mixer();
        this.stoessel = new Stoessel();

        buyAllIngredients();
    }

    public void prepareCocktail(Cocktail cocktail) {
        switch (cocktail) {
            case CAIPI:
                prepareCaipi();
                break;
            case MOJITO:
                prepareMojito();
                break;
            case DAIQUIRI:
                prepareDaiquiri();
                break;
            default:
                break;
        }
    }

    private void prepareDaiquiri() {
        getEmptyGlass();

        //Erdbeeren
        addErdbeerenToMixer(6);

 /*       //Limetten
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
*/
        //3 leaves of Minze
        addMinzeToGlas(3);
    }

    private void prepareMojito() {
        getEmptyGlass();

        //add 1 Limette
        addLimettenToGlas(1);
        //add 20 gram of Rohrzucker
        addRohrzuckerToGlas(20);
        //Minze
        addMinzeToGlas(8);
        //crush
        stoessel.crush();
        //add 2 hand full crushed Ice
        addCrushedIceToGlas(2);
        //add 5 cl of Rum
        addRumToGlas(5);
        //add 150 ml Soda
        addSodaToGlas(150);
        //add 1 Strohalm
        addStrohhalmToGlas(1);
    }

    private void prepareCaipi() {
        getEmptyGlass();

        //wash, cut and add limetten
        addLimettenToGlas(1);
        //crush
        stoessel.crush();
        //add 20 gram Rohrzucker
        addRohrzuckerToGlas(20);
        //add 2 hand full of Crushed Ice
        addCrushedIceToGlas(2);
        //crush
        stoessel.crush();
        //add 5 cl of Cacacha
        addCacachaToGlas(5);
        addStrohhalmToGlas(1);
    }

    private void buyAllIngredients() {
        this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha.NAME);
        this.rum = (Rum) supermarkt.buyIngredient(Rum.NAME);
        this.soda = (Soda) supermarkt.buyIngredient(Soda.NAME);
        this.limetten = (Limetten) supermarkt.buyIngredient(Limetten.NAME);
        this.erdbeeren = (Erdbeeren) supermarkt.buyIngredient(Erdbeeren.NAME);
        this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalme.NAME);
        this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker.NAME);
        this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce.NAME);
        this.minze = (Minze) supermarkt.buyIngredient(Minze.NAME);
    }

    private void getEmptyGlass() {
        if (this.cocktailglas.isFull()) {
            this.cocktailglas = new Glas();
        }
    }

    private void addLimettenToGlas(int number) {
        limetten.setPortionSize(number);
        if (limetten.isEnoughForCocktail() == false) {
            this.limetten = (Limetten) supermarkt.buyIngredient(Limetten.NAME);
}
    Limetten limetteForCaipi = (Limetten) limetten.getOnePortionForCocktail();
        limetteForCaipi.washLimette();
        limetteForCaipi.cutInPieces();
        cocktailglas.addIngredient(limetteForCaipi);
}

    private void addRohrzuckerToGlas(int grams) {
        rohrzucker.setPortionSize(grams);
        if (rohrzucker.isEnoughForCocktail() == false) {
            this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker.NAME);
}
    Rohrzucker rohrzuckerForCaipi = (Rohrzucker) rohrzucker.getOnePortionForCocktail();
        cocktailglas.addIngredient(rohrzuckerForCaipi);
}

    private void addCrushedIceToGlas(int handful) {
        crushedIce.setPortionSize(handful);
        if (crushedIce.isEnoughForCocktail() == false) {
            this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce.NAME);
}
    CrushedIce crushedIceForCaipi = (CrushedIce) crushedIce.getOnePortionForCocktail();
        cocktailglas.addIngredient(crushedIceForCaipi);
    }

    private void addCacachaToGlas(int cl) {
        cacacha.setPortionSize(cl);
        if (cacacha.isEnoughForCocktail() == false) {
            this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha.NAME);
        }
        Cacacha cacachaForCaipi = (Cacacha) cacacha.getOnePortionForCocktail();

        cocktailglas.addIngredient(cacachaForCaipi);
    }

    private void addStrohhalmToGlas(int number) {
        //Strohalm
        strohhalme.setPortionSize(number);
        if (strohhalme.isEnoughForCocktail() == false) {
            this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalme.NAME);
        }
        Strohhalme strohhalmeForCaipi = (Strohhalme) strohhalme.getOnePortionForCocktail();
        cocktailglas.addIngredient(strohhalmeForCaipi);
    }

    private void addMinzeToGlas(int leaves) {
        minze.setPortionSize(leaves);
        if (minze.isEnoughForCocktail() == false) {
            this.minze = (Minze) supermarkt.buyIngredient(Minze.NAME);
        }
        Minze minzeForMojito = (Minze) minze.getOnePortionForCocktail();
        cocktailglas.addIngredient(minzeForMojito);
    }

    private void addRumToGlas(int cl) {
        rum.setPortionSize(cl);
        if (rum.isEnoughForCocktail() == false) {
            this.rum = (Rum) supermarkt.buyIngredient(Rum.NAME);
        }
        Rum rumForCaipi = (Rum) rum.getOnePortionForCocktail();
        cocktailglas.addIngredient(rumForCaipi);
    }

    private void addSodaToGlas(int ml) {
        soda.setPortionSize(ml);
        if (soda.isEnoughForCocktail() == false) {
            this.soda = (Soda) supermarkt.buyIngredient(Soda.NAME);
        }
        Soda sodaForCaipi = (Soda) soda.getOnePortionForCocktail();
        cocktailglas.addIngredient(sodaForCaipi);
    }

    private void addErdbeerenToMixer(int number) {
        erdbeeren.setPortionSize(number);
        if (erdbeeren.isEnoughForCocktail() == false) {
            this.erdbeeren = (Erdbeeren) supermarkt.buyIngredient(Erdbeeren.NAME);
        }
        Erdbeeren erdbeerenForDaiquiri = (Erdbeeren) erdbeeren.getOnePortionForCocktail();
        erdbeerenForDaiquiri.washErdbeere();
        mixer.addIngredient(erdbeerenForDaiquiri);
    }
}
