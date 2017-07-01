package dp_caipiExample.subsystem.ingredients;

public abstract class AbstractCocktailIngredient {

    public int contentOfIngredient;
    public int portionForOneCocktail;

    public AbstractCocktailIngredient() {

    }
    public boolean isEnoughForCocktail(){
        return contentOfIngredient >= portionForOneCocktail;
    }

    public AbstractCocktailIngredient getOnePortionForCocktail() {
        contentOfIngredient -= portionForOneCocktail;
        return this;
    }

    public void setPortionSize(int sizeOfPortion) {
        this.portionForOneCocktail = sizeOfPortion;
    }
}
