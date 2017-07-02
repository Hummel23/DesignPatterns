package dp_caipiFinal.fassade;

import dp_caipiFinal.subsystem.interfaces.Fruit;
import dp_caipiFinal.subsystem.Supermarkt;
import dp_caipiFinal.subsystem.enums.Cocktail;
import dp_caipiFinal.subsystem.ingredients.*;
import dp_caipiFinal.subsystem.tools.AbstractContainer;
import dp_caipiFinal.subsystem.tools.Glas;
import dp_caipiFinal.subsystem.tools.Mixer;
import dp_caipiFinal.subsystem.tools.Stoessel;

import java.util.List;

import static dp_caipiFinal.subsystem.enums.IngredientName.*;

public class Barkeeper {

    private Supermarkt supermarkt;
    private Glas cocktailglas;
    private Mixer mixer;
    private Stoessel stoessel;
    
    private Cacacha cacacha;
    private Rum rum;
    private Soda soda;
    private Limettensaft limettensaft;
    
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

        //add 6 Erdbeeren to mixer
        addIngredientToContainer(this.erdbeeren, this.mixer, 6);
       // add 2 cl lemon juice to mixer
        addIngredientToContainer(this.limetten, this.mixer, 2);
        //add 5 cl Rum to mixer
        addIngredientToContainer(this.rum, this.mixer, 5);
        //add 30 gram of Rohrzucker to mixer
        addIngredientToContainer(this.rohrzucker, this.mixer, 30);
        //add one handful of CrushedIce to mixer
        addIngredientToContainer(this.crushedIce, this.mixer, 1);
        mixer.mixIngredients();
        pourFromContainerToContainer(this.mixer, this.cocktailglas);
        //add3 leaves of Minze
        addIngredientToContainer(this.minze, this.cocktailglas, 3);
    }

    private void prepareMojito() {
        getEmptyGlass();

        //add 1 Limette
        addIngredientToContainer(this.limetten, this.cocktailglas, 1);
        //add 20 gram of Rohrzucker
        addIngredientToContainer(this.rohrzucker, this.cocktailglas, 20);
        //add 8 leaves of Minze
        addIngredientToContainer(this.minze, this.cocktailglas, 8);
        //crush
        stoessel.crush();
        //add 2 hand full crushed Ice
        addIngredientToContainer(this.crushedIce, this.cocktailglas, 2);
        //add 5 cl of Rum
        addIngredientToContainer(this.rum, this.cocktailglas, 5);
        //add 150 ml Soda
        addIngredientToContainer(this.soda, this.cocktailglas, 150);
        //add 1 Strohalm
        addIngredientToContainer(this.strohhalme, this.cocktailglas, 1);

    }

    private void prepareCaipi() {
        getEmptyGlass();
        //wash, cut and add limetten
        addIngredientToContainer(this.limetten, this.cocktailglas, 1);
        //crush
        stoessel.crush();
        //add 20 gram Rohrzucker
        addIngredientToContainer(this.rohrzucker, this.cocktailglas, 20);
        //add 2 hand full of Crushed Ice
        addIngredientToContainer(this.crushedIce, this.cocktailglas, 2);
        //crush
        stoessel.crush();
        //add 5 cl of Cacacha
        addIngredientToContainer(this.cacacha, this.cocktailglas, 5);
        //add 1 Strohalm
        addIngredientToContainer(this.strohhalme, this.cocktailglas, 1);
    }

    private void buyAllIngredients() {
        this.cacacha = (Cacacha) supermarkt.buyIngredient(Cacacha);
        this.rum = (Rum) supermarkt.buyIngredient(Rum);
        this.soda = (Soda) supermarkt.buyIngredient(Soda);
        this.limetten = (Limetten) supermarkt.buyIngredient(Limette);
        this.erdbeeren = (Erdbeeren) supermarkt.buyIngredient(Erdbeere);
        this.strohhalme = (Strohhalme) supermarkt.buyIngredient(Strohhalm);
        this.rohrzucker = (Rohrzucker) supermarkt.buyIngredient(Rohrzucker);
        this.crushedIce = (CrushedIce) supermarkt.buyIngredient(CrushedIce);
        this.minze = (Minze) supermarkt.buyIngredient(Minze);
        this.limettensaft = (Limettensaft) supermarkt.buyIngredient(Limettensaft);
    }

    private void getEmptyGlass() {
        if (this.cocktailglas.isFull()) {
            this.cocktailglas = new Glas();
        }
    }

    <I extends AbstractCocktailIngredient, C extends AbstractContainer>void addIngredientToContainer(I ingredient,C container, int number) {
        ingredient.setPortionSize(number);
        if (ingredient.isEnoughForCocktail() == false) {
            ingredient = (I) supermarkt.buyIngredient(valueOf(ingredient.getNAME()));
        }
        if (ingredient instanceof Fruit) {
            ((Fruit) ingredient).washFruit();
            ((Fruit) ingredient).cutInPieces();
        }
        I ingredientForCocktail = (I) ingredient.getOnePortionForCocktail();
        container.addIngredient(ingredientForCocktail);
    }

    <C extends AbstractContainer> void pourFromContainerToContainer(C containerFrom, C containerTo) {
        List<AbstractCocktailIngredient> ingredients = containerFrom.getIngredients();
        ingredients.forEach(containerTo::addIngredient);
    }
}
