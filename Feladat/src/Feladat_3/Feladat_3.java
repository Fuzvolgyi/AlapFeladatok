package Feladat_3;

import java.util.Scanner;

public class Feladat_3 {

    public static void main(String[] args) {
//9. Írjon programot, mely kiírja az első n db páros szám összegét a képernyőre!      
        int vegjel;
        int eredmeny;

        System.out.println("Kérek egy egész számot");
        vegjel = szamBeolvas();
        vegjel = Math.abs(vegjel);
        eredmeny = nParosSzamOsszege(vegjel);
        System.out.println("A " + vegjel + " elemből álló számsor "
                + "páros számainak összege: " + eredmeny);

// 10. Készítsen programot, mely beolvas n db számot a billentyűzetről, majd meghatározza
//a számok átlagát.       
        vegjel = 5;
        int osszeg = 0;
        int index = 0;
        double atlag;
        while (index < 5) {
            System.out.print("Kérek egy egész számot " + (index + 1) + "/"
                    + vegjel + " :");
            osszeg = osszeg + szamBeolvas();
            index++;
        }
        atlag = atlagSzamitas(osszeg, index);
        System.out.println("A megadott számok átlaga: " + atlag);

//11. Készíts programot, amely (maximum 99 karakter hosszú) mondatokat kér be a
//felhasználótól, és minden bekérés után kiírja, hogy a megadott mondat palindróma-e!        
//A palindróma-vizsgálatnál a
//program ne vegye figyelembe a fehér karaktereket .A kis és a nagy betűk ne
//számítsanak különbözőnek! Feltételezheted, hogy a mondatok nem tartalmaznak
//ékezetes betűket és jeleket. Ha a felhasználó a "kilep" mondatot adta meg, akkor a
//program lépjen ki!        
        int maxKarakter = 99;
        String bekertSzoveg = "";
        String osszehasonlitandoSzoveg;
        String megforditottSzoveg;
        while (!bekertSzoveg.equals("kilep")) {
            System.out.println("Kérek egy mondatot. "
                    + "(Maximum 99 karakter lehet. "
                    + "Kilépéshez írd be, hogy \"kilep\".)");
            bekertSzoveg = szovegBeolvaso();
            if (bekertSzoveg.equals("kilep") || bekertSzoveg.length() > 99) {
                continue;
            }
            osszehasonlitandoSzoveg = bekertSzoveg.toLowerCase();
            osszehasonlitandoSzoveg = osszehasonlitandoSzoveg.replaceAll(" ", "");
            megforditottSzoveg = szovegMegfordit(osszehasonlitandoSzoveg);
            if (osszehasonlitandoSzoveg.equals(megforditottSzoveg)) {
                System.out.println("A megadott szöveg palindróm!");
            } else {
                System.out.println("A megadott szöveg nem palindrom.");
            }
        }

    }

    private static int szamBeolvas() {
        Scanner sc = new Scanner(System.in);
        int szam = sc.nextInt();
        return szam;
    }

    private static String szovegBeolvaso() {
        Scanner sc = new Scanner(System.in);
        String szoveg = sc.nextLine();
        return szoveg;
    }

    private static String szovegMegfordit(String Szoveg) {
        String eredmeny = "";
        int balFel = Szoveg.length() / 2;
        int jobbFel = Szoveg.length() - balFel;
        if (jobbFel > balFel) {
            eredmeny += Szoveg.charAt(balFel);
        }
        for (int i = 0; i < balFel; i++) {
            eredmeny = Szoveg.charAt(jobbFel + i) + eredmeny
                    + Szoveg.charAt(balFel - 1 - i);
        }
        return eredmeny;
    }

    private static int nParosSzamOsszege(int vegjel) {
        int eredmeny = 0;
        for (int i = 0; i <= vegjel;) {
            eredmeny += i;
            i += 2;
        }
        return eredmeny;
    }

    private static double atlagSzamitas(int osszeg, int elemeinekSzama) {
        double eredmeny = (double) osszeg / elemeinekSzama;
        return eredmeny;
    }
}
