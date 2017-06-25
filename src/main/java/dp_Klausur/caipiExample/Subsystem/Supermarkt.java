package dp_Klausur.caipiExample.Subsystem;

import java.util.ArrayList;
import java.util.List;

public class Supermarkt {

    public Cacacha buyCacacha() {
        System.out.println("You bought a bottle of Cacacha.");
        return new Cacacha();
    }

    public List<Limette> buyLimetten(int numberOfLimetten ) {
        System.out.println("You bought " + numberOfLimetten + " Limetten.");
        List<Limette> limetten = new ArrayList<>();
        for (int i = 0; i < numberOfLimetten; i++) {
            limetten.add(new Limette());
        }
        return limetten;
    }

    public List<Strohhalm> buyStrohalme() {
        System.out.println("You bought a bag of Strohalme.");
        List<Strohhalm> strohhalme = new ArrayList<>();
        for (StrohhalmColour strohhalmColour : StrohhalmColour.values()) {
            for (int i = 0; i < 10; i++) {
                strohhalme.add(new Strohhalm(strohhalmColour));
            }
        }
        return strohhalme;
    }

    public Rohrzucker buyRohrzucker() {
        System.out.println("You bought a bag of Rohrzucker.");
        return new Rohrzucker();
    }

    public CrushedIce buyCrushedIce() {
        System.out.println("You bought a bag of crushed Ice.");
        return new CrushedIce();
    }
}
