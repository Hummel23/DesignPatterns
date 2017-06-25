package dp_Klausur.caipiExample.Subsystem;

public class Rohrzucker implements CocktailIngredient{

    private int contentOfPackageInGramm;

    Rohrzucker() {
        this.contentOfPackageInGramm = 500;
    }

    @Override
    public String getName() {
        return "Rohrzucker";
    }

    @Override
    public boolean hasEnoughContent4OneCocktail() {
        return contentOfPackageInGramm >= 60;
    }

    public void getTL(int numberOfTL) {
        System.out.println("Added " + numberOfTL + " teaspoons of crushed Rohrzucker.");
        this.contentOfPackageInGramm -= (numberOfTL * 20);
    }

}
