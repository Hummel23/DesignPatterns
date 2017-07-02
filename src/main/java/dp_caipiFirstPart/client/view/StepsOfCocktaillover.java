package dp_caipiFirstPart.client.view;

public class StepsOfCocktaillover {


    public static String PROSTCAIPI = "\n\n" +
            "                ___0___o__o__o__0________0___o__o__o__0___\n" +
            "                __0___o__o_o_____0______0___o__o_o_____0__\n" +
            "                _0_o___o___o______0____0_o___o___o______0_\n" +
            "                00o0000oo0ooo0000o00__00o0000oo0ooo0000o00\n" +
            "                000o0o00o0o000o0o000__000o0o00o0o000o0o000\n" +
            "                00000oo0000oo0000o00__00000oo0000oo0000o00\n" +
            "                00ooo0000oo0000ooo00__00ooo0000oo0000ooo00\n" +
            "                _00o00o000000o00o00____00o00o000000o00o00_\n" +
            "                __0o00oo0000oo00o0______0o00oo0000oo00o0__\n" +
            "                ___0000oooooo0000________0000oooooo0000___\n" +
            "                ____000000000000__________000000000000____\n" +
            "                _________00____________________00_________\n" +
            "                _________00____________________00_________\n" +
            "                _________00____________________00_________\n" +
            "                _________00____________________00_________\n" +
            "                _________00____________________00_________\n" +
            "                _______000000__Prooooooooost__000000_______\n\n";


    public static String PROSTMOJITO = "\n\n" +
            "__________________________________________________\n" +
            "________________#_________________________________\n" +
            "______________#######_____________________________\n" +
            "_______________###__###___________________________\n" +
            "__________________##__##__________________________\n" +
            "____________________##_##_________________________\n" +
            "______________________#__#________________________\n" +
            "_______________________#__#_______________________\n" +
            "______________###########_##__######______________\n" +
            "___________####_________##_#________####__________\n" +
            "__________###____________#_##_________###_________\n" +
            "__________###############################_________\n" +
            "___________###########_###_##############_________\n" +
            "___________#______##_##########_##_____#__________\n" +
            "___________#______##__#______##_#_____##__________\n" +
            "___________##_____##__#______##_#_____##__________\n" +
            "____________#_____##__#______##_#_____#___________\n" +
            "____________##____##__#______##_#____##___________\n" +
            "_____________#____##__#______##_#____#____________\n" +
            "_____________##___##__#______##_#___##____________\n" +
            "______________#___##__#______##_#___##____________\n" +
            "______________#___##__#______##_#___##____________\n" +
            "______________##__##__#______##_#___##____________\n" +
            "_______________#__##__#______##_#___##____________\n" +
            "_______________#####__#______##_#__###____________\n" +
            "_______________#######################____________\n" +
            "_______________________########___________________\n\n";


    public static String PROSTDAIQUIRI   = "\n\n" +
            "………………………………….###.…………………………………………\n" +
            "…………………………..(o)..###.…………………………………\n" +
            "……………………….(…(..(.###.…………………………………\n" +
            "…………………._.(…(..(_.(##.………………………………\n" +
            "………………._.(..)..(_.).(.#)_.……………………\n" +
            "………………(…).(…).(…).(…).………………………………\n" +
            "……………xxxxxxxxxxxxxxxx.………………………………\n" +
            "…………………xxxxxxxxxx.…………………………………………\n" +
            "…………………….xxxxxx.………………………………………………\n" +
            "……………………….xx.………………………………………………………\n" +
            "……………………….xx.………………………………………………………\n" +
            "……………………….xx.………………………………………………………\n" +
            "……………………..xxxx.…………………………………………………\n" +
            "……………………xxxxxx.…………………………………………………\n" +
            "…………………xxxxxxxxx.……………………………………………\n\n";




    public static void boughtNewIngredients(String ingredient) {
        System.out.println("\n\nNo " + ingredient + " in stock. Buying new one(s).\n\n ");
    }

    public static void addedIngredientToGlas(String ingredient) {
        System.out.println(ingredient + " added to cocktail glas.");
    }

    public static void ingredientMeasured(String ingredient) {
        System.out.println(ingredient + " measured for Cocktail. ");
    }

    public static void ingredientWashed(String ingredient) {
        System.out.println(ingredient + " washed.");
    }

    public static void ingredientCut(String ingredient) {
        System.out.println(ingredient + " cut.");
    }

    public static void crushedWithStoessel(String... ingredients) {
        for (String ingredient : ingredients) {
            System.out.print(ingredient + " ");

        }

        System.out.println("crushed with stoessel.");
    }

    public static void pickedNewGlas() {
        System.out.println("A new glas was picked.");
    }

    public static void addedIngredientToMixer(String ingredient) {
        System.out.println(ingredient + " added to mixer.");
    }

    public static void limettenSqueezed(int number) {
        System.out.println(number + " Limetten were squeezed.");
    }

    public static void mixedIngredients() {
        System.out.println("All ingredients in the mixer were mixed.");
    }

    public static void pouredCocktailFromMixerToGlas() {
        System.out.println("Cocktail was poured from mixer to glas.");
    }
}