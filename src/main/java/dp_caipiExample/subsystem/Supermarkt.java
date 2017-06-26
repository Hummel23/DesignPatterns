package dp_caipiExample.subsystem;

import dp_caipiExample.subsystem.ingredients.*;

import java.util.ArrayList;
import java.util.List;

public class Supermarkt {

    public Cacacha buyCacacha() {
        return new Cacacha();
    }

    public List<Limette> buyLimetten(int numberOfLimetten ) {
        List<Limette> limetten = new ArrayList<>();
        for (int i = 0; i < numberOfLimetten; i++) {
            limetten.add(new Limette());
        }
        return limetten;
    }

    public List<Strohhalm> buyStrohalme() {
        List<Strohhalm> strohhalme = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                strohhalme.add(new Strohhalm());
            }
        return strohhalme;
    }

    public Rohrzucker buyRohrzucker() {
        return new Rohrzucker();
    }

    public CrushedIce buyCrushedIce() {
        return new CrushedIce();
    }
}
