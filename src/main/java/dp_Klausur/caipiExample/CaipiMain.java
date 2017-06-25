package dp_Klausur.caipiExample;

import dp_Klausur.caipiExample.client.CaipiLover;

public class CaipiMain {

    public static void main(String[] args) {

        CaipiLover caipiLover = new CaipiLover();

        for (int i = 0; i < 7; i++) {
            try {
                caipiLover.prepareCaipi();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }



    }
}
