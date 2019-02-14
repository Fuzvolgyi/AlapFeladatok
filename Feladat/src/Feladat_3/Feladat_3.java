package Feladat_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Feladat_3 {

    public static void main(String[] args) {
//9. Írjon programot, mely kiírja az első n db páros szám összegét a képernyőre!      
        int vegjel;
        int eredmeny;
        ArrayList<Integer> szamlista = new ArrayList<>();
        System.out.println("Kérek egy egész számot");
        vegjel = szamBeolvas();
        vegjel = Math.abs(vegjel);
        szamlista = szamListaFeltolt(vegjel, szamlista);
        eredmeny = nParosSzamOsszege(szamlista);
        System.out.println("A " + vegjel + " elemből álló számsor "
                + "páros számainak összege: " + eredmeny);

// 10. Készítsen programot, mely beolvas n db számot a billentyűzetről, majd meghatározza
//a számok átlagát.       
        vegjel = 5;
        int beolvasottSzam;
        szamlista.clear();
        eredmeny = 0;
        while (szamlista.size() < 5) {
            System.out.print("Kérek egy egész számot " + (szamlista.size() + 1)
                    + "/" + vegjel + " :");
            beolvasottSzam = szamBeolvas();
            szamlista.add(beolvasottSzam);
        }
        eredmeny = szamlistaElemeinekAtlaga(szamlista);
        System.out.println("A megadott számok átlaga: " + eredmeny);

//11. Készíts programot, amely (maximum 99 karakter hosszú) mondatokat kér be a
//felhasználótól, és minden bekérés után kiírja, hogy a megadott mondat palindróma-e!        
//A palindróma-vizsgálatnál a
//program ne vegye figyelembe a fehér karaktereket .A kis és a nagy betűk ne
//számítsanak különbözőnek! Feltételezheted, hogy a mondatok nem tartalmaznak
//ékezetes betűket és jeleket. Ha a felhasználó a "kilep" mondatot adta meg, akkor a
//program lépjen ki!        
        int maxKarakter = 99;
        String bekertSzoveg;
        String osszehasonlitandoSzoveg;
        String megforditottSzoveg;
        do {
            System.out.println("Kérek egy mondatot. (Kilépéshez írd be, hogy \"kilep\".)");
            bekertSzoveg = szovegBeolvaso();
            osszehasonlitandoSzoveg = bekertSzoveg.toLowerCase();
            osszehasonlitandoSzoveg = osszehasonlitandoSzoveg.replaceAll(" ", "");
            megforditottSzoveg = szovegMegfordit(osszehasonlitandoSzoveg);
            if (osszehasonlitandoSzoveg.equals(megforditottSzoveg)) {
                System.out.println("A megadott szöveg palindróm!");
            } else {
                System.out.println("A megadott szöveg nem palindrom.");
            }
        } while (!bekertSzoveg.equals("kilep"));

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

    private static ArrayList<Integer> szamListaFeltolt(int vegjel, ArrayList<Integer> szamlista) {
        for (int i = 0; i < vegjel; i++) {
            szamlista.add(i);
        }
        return szamlista;
    }

    private static int nParosSzamOsszege(ArrayList<Integer> szamlista) {
        int eredmeny = 0;
        for (int i = 0; i < szamlista.size(); i++) {
            if (szamlista.get(i) % 2 == 0) {
                eredmeny += szamlista.get(i);
            }
        }
        return eredmeny;
    }

    private static int szamlistaElemeinekAtlaga(ArrayList<Integer> szamlista) {
        int eredmeny = 0;
        for (int i = 0; i < szamlista.size(); i++) {
            eredmeny += szamlista.get(i);
        }
        return eredmeny = eredmeny / szamlista.size();
    }

    private static String szovegMegfordit(String osszehasonlitandoSzoveg) {
        String eredmeny = "";
        int hossz = osszehasonlitandoSzoveg.length();
        for (int i = 0; i < hossz; i++) {
            eredmeny += osszehasonlitandoSzoveg.charAt(hossz - 1 - i);
        }
        return eredmeny;
    }

}
