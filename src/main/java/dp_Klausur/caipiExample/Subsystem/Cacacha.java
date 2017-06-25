package dp_Klausur.caipiExample.Subsystem;

public class Cacacha implements CocktailIngredient {

    private int contentOfBottleInCL;

    Cacacha() {
        this.contentOfBottleInCL = 80;
    }

    @Override
    public String getName() {
        return "Cacacha";
    }

    @Override
    public boolean hasEnoughContent4OneCocktail() {
        return contentOfBottleInCL >= 5;
    }

    public void get5CL() {
        this.contentOfBottleInCL -= 5;
        System.out.println("5 cl Cacacha extracted from bottle.");
    }
}
