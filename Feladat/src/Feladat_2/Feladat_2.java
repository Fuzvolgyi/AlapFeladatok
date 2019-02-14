package Feladat_2;

import java.util.Scanner;

public class Feladat_2 {

    public static void main(String[] args) {
//6. Készítsen programot, mely beolvassa a billentyűzetről az egész számokat egy
//meghatározott végjelig. Az éppen beolvasott számnak írja ki a négyzetét.               
        int beolvasottSzam = 0;
        int vegjel = 666;
        int szamlalo = 0;
        int eredmeny = 0;
        while (beolvasottSzam != vegjel) {
            kiir("Kérek egy egész számot!");
            beolvasottSzam = szamBeolvaso();
            if (beolvasottSzam != vegjel) {
                eredmeny = beolvasottSzam * beolvasottSzam;
            }
            szamlalo++;
            if (szamlalo == 1 && beolvasottSzam == vegjel) {
                kiir("Elsőre a végjelet adtad meg.");
            } else {
                kiir("Az utolsó szám négyzete: " + eredmeny);
            }
        }
        System.out.println("");

//7. A felhasználótól beolvasott számot a program váltsa át kettes számrendszerbe!
        kiir("Átváltás kettes számrendszerre");
        int osztando;
        String binarisSzam;
        kiir("Kérek egy egész számot.");
        beolvasottSzam = szamBeolvaso();
        binarisSzam = atvaltasKettesSzamrendszerbe(beolvasottSzam);
        kiir("Megadott szám kettes számrendszerben: " + binarisSzam);

        System.out.println("");

//8. Programja olvasson be a billentyűzetről egész számokat egy meghatározott végjelig
//(legyen a végjel -999999), majd a végjel beolvasása után írja ki a legnagyobbat és a
//legkisebbet a kapott értékek közül.     
        beolvasottSzam = 0;
        vegjel = -999999;
        int minSzam = Integer.MAX_VALUE;
        int maxSzam = Integer.MIN_VALUE;
        while (beolvasottSzam != vegjel) {
            System.out.println("Kérek egy egész számot");
            beolvasottSzam = szamBeolvaso();
            if (beolvasottSzam == vegjel) {
                continue;
            }
            minSzam = kissebbVizsgálat(beolvasottSzam, minSzam);
            maxSzam = nagyobbVizsgalat(beolvasottSzam, maxSzam);
        }
        kiir("A beolvasott számok közül a legnagyobb: " + maxSzam);
        kiir("A beolvasott számok közül a legkissebb: " + minSzam);
    }

    private static int szamBeolvaso() {
        Scanner sc = new Scanner(System.in);
        int ertek = sc.nextInt();
        return ertek;
    }

    private static void kiir(String szoveg) {
        System.out.println(szoveg);
    }

    private static int nEgeszNegyzet(int n) {
        int eredmeny = 0;
        for (int i = 0; i < n; i++) {
            eredmeny += Math.pow(i, 2);
        }
        return eredmeny;
    }

    private static String atvaltasKettesSzamrendszerbe(int beolvasottSzam) {
        int valtozo;
        String binarisSzam = "";
        while (beolvasottSzam > 0) {
            valtozo = beolvasottSzam % 2;
            binarisSzam = valtozo + binarisSzam;
            beolvasottSzam /= 2;
        }
        return binarisSzam;
    }

    private static int kissebbVizsgálat(int beolvasottSzam, int minSzam) {
        return minSzam = beolvasottSzam < minSzam ? minSzam = beolvasottSzam
                : minSzam;
    }

    private static int nagyobbVizsgalat(int beolvasottSzam, int maxSzam) {
        return maxSzam = beolvasottSzam > maxSzam
                ? maxSzam = beolvasottSzam : maxSzam;
    }

}
