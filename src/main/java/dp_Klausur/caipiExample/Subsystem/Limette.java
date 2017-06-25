package dp_Klausur.caipiExample.Subsystem;

public class Limette implements CocktailIngredient{

    public void washWithWarmWater() {
        System.out.println(getName() + " was washed with warm water.");
    }

    public void cutInPieces() {
        System.out.println(getName() + " was cut to pieces.");
    }

    @Override
    public String getName() {
        return "Limette";
    }

    @Override
    public boolean hasEnoughContent4OneCocktail() {
        return true;
    }
}
