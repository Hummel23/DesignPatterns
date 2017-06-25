package dp_Klausur.caipiExample.Subsystem;

public class Strohhalm implements CocktailIngredient {

    public boolean isDarkStrohhalm;

    private StrohhalmColour COLOR;

    public Strohhalm(StrohhalmColour COLOR) {
        this.COLOR = COLOR;
        switch (COLOR) {
            case BLACK:
            case BLUE:
            case BROWN:
                isDarkStrohhalm = true;
                break;
            default:
                isDarkStrohhalm = false;
                break;
        }
    }

    @Override
    public String getName() {
        return COLOR.toString() + " Strohhalm";
    }

    @Override
    public boolean hasEnoughContent4OneCocktail() {
        return true;
    }
}
