package dp_Klausur.caipiExample.client;

import dp_Klausur.caipiExample.Subsystem.*;

import java.util.List;

import static dp_Klausur.caipiExample.Subsystem.StrohhalmColour.BLACK;

public class CaipiLover {
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
        this.limetten = supermarkt.buyLimetten(5);
        this.strohhalme = supermarkt.buyStrohalme();
        this.rohrzucker = supermarkt.buyRohrzucker();
        this.crushedIce = supermarkt.buyCrushedIce();
    }

    public void prepareCaipi() throws IllegalStateException {
        prepareLimetten();
        addRohrzucker();
        addCrushedIce();
        addCacacha();
        addStrohalm();
        enjoy();
    }

    private synchronized void enjoy() {
        System.out.println("Enjoy your cocktail! ");
        System.out.println();
        System.out.println();
    }

    private synchronized void addStrohalm() {
        if (strohhalme.size() > 0) {
            boolean strohhalmAdded = false;
            for (Strohhalm strohhalm : strohhalme) {
                if (strohhalm.isDarkStrohhalm) {
                    cocktailglas.addIngredient(strohhalm);
                    strohhalmAdded = true;
                    break;
                }
            }
            if (!strohhalmAdded) {
                Strohhalm cocktailIngredient = strohhalme.get(0);
                cocktailglas.addIngredient(cocktailIngredient);
            }
        } else {
            throwIllegalStateException(new Strohhalm(BLACK).getName());
        }
    }

    private synchronized void addCacacha() {
        if (cacacha.hasEnoughContent4OneCocktail()) {
                cacacha.get5CL();
            } else {
                throwIllegalStateException(cacacha.getName());
            }
        cocktailglas.addIngredient(cacacha);
    }

    private synchronized void addCrushedIce() {
        if (crushedIce.hasEnoughContent4OneCocktail()) {
            crushedIce.getPortion();
        } else {
            throwIllegalStateException(crushedIce.getName());
        }
        cocktailglas.addIngredient(crushedIce);
        stoessel.crush(crushedIce);
    }

    private synchronized void addRohrzucker() {
        if (rohrzucker.hasEnoughContent4OneCocktail()) {
            rohrzucker.getTL(3);
        } else {
            throwIllegalStateException(rohrzucker.getName());
        }
        cocktailglas.addIngredient(rohrzucker);
    }

    private synchronized void prepareLimetten() {
        Limette limetteForCaipi;
        if (limetten.size() > 0) {
            limetteForCaipi = limetten.get(0);
            limetten.remove(0);
            limetteForCaipi.washWithWarmWater();
            limetteForCaipi.cutInPieces();
            cocktailglas.addIngredient(limetteForCaipi);
            stoessel.crush(limetteForCaipi);
        } else {
            throwIllegalStateException(new Limette().getName());
        }
    }

    private void throwIllegalStateException(String s) {
        throw new IllegalStateException("Not enough " +  s + " to prepare a Caipi.");
    }
}
