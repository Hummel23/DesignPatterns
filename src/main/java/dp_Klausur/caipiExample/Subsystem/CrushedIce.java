package dp_Klausur.caipiExample.Subsystem;

public class CrushedIce implements CocktailIngredient{

    private int portionsOfCrushedIce;

    CrushedIce() {
        this.portionsOfCrushedIce = 20;
    }

    @Override
    public String getName() {
        return "crushed ice";
    }

    @Override
    public boolean hasEnoughContent4OneCocktail() {
        return portionsOfCrushedIce >= 0;
    }

    public synchronized void getPortion() {
        System.out.println("Added one portion of crushed ice.");
        this.portionsOfCrushedIce -= 1;
    }
}
