package Feladat_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Feladat_2 {

    public static void main(String[] args) {
//6. Készítsen programot, mely beolvassa a billentyűzetről az egész számokat egy
//meghatározott végjelig. Az éppen beolvasott számnak írja ki a négyzetét.               
        kiir("Utolsó beolvasott szám négyzete");
        int beolvasottSzam = 0;
        int vegjel = 666;
        ArrayList<Integer> szamLista = new ArrayList<>();
        while (beolvasottSzam != vegjel || szamLista.isEmpty()) {
            kiir("Kérek egy egész számot!");
            beolvasottSzam = szamBeolvaso();
            if (szamLista.isEmpty() && beolvasottSzam == vegjel) {
                kiir("A végjel előtt nem adtál meg számot.");
                continue;
            }
            szamLista.add(beolvasottSzam);
        }
        kiir("A végjelig beolvasott utolsó szám négyzete: ");
        int utolsoSzam = szamLista.get(szamLista.size() - 2);
        szamKiir(szamNegyzete(utolsoSzam));

//7. A felhasználótól beolvasott számot a program váltsa át kettes számrendszerbe!
        kiir("Megadott szám kettes számrendszerben.");
        int osztando;
        String binarisSzam = "";
        kiir("Kérek egy egész számot.");
        beolvasottSzam = szamBeolvaso();
        atvaltasKettesSzamrendszerbe(beolvasottSzam);
        kiir(binarisSzam);

//8. Programja olvasson be a billentyűzetről egész számokat egy meghatározott végjelig
//(legyen a végjel -999999), majd a végjel beolvasása után írja ki a legnagyobbat és a
//legkisebbet a kapott értékek közül.     
        kiir("Beolvasott intervallum minimum, maximum értéke.");
        beolvasottSzam = 0;
        vegjel = -999999;
        szamLista.clear();
        int legnagyobbSzam;
        int legkissebbSzam;

        while (beolvasottSzam != vegjel || szamLista.isEmpty()) {
            kiir("Kérek egy egész számot!");
            beolvasottSzam = szamBeolvaso();
            if (szamLista.isEmpty() && beolvasottSzam == vegjel) {
                kiir("A végjel előtt nem adtál meg számot.");
                continue;
            }
            szamLista.add(beolvasottSzam);
        }
        legnagyobbSzam = szamListaLegnagyobbKereses(szamLista);
        if (szamLista.isEmpty()) {
            kiir("Nem adtál meg értéket a végjelig.");
        }
        kiir("A beolvasott sorozat legnagyobb száma:");
        szamKiir(legnagyobbSzam);

        legkissebbSzam = szamListaLegkissebbKereses(szamLista);

        kiir("A beolvasott sorozat legkissebb száma:");
        szamKiir(legkissebbSzam);

    }

    private static int szamBeolvaso() {
        Scanner sc = new Scanner(System.in);
        int ertek = sc.nextInt();
        return ertek;
    }

    private static void kiir(String szoveg) {
        System.out.println(szoveg);
    }

    private static void szamKiir(int szam) {
        System.out.println(szam);
    }

    private static void tombKiir(int[] tomb) {
        for (int i = 0; i < tomb.length - 1; i++) {
            System.out.print(tomb[i] + ", ");
        }
        System.out.println(tomb[tomb.length - 1]);
    }

    private static void tombParosElemeKiir(int[] tomb) {
        for (int i = 0; i < tomb.length; i++) {
            if (tomb[i] % 2 == 0) {
                System.out.print(tomb[i] + ", ");
            }
        }
        System.out.println("");
    }

    private static void tombCsokkenoFeltolt(int[] tomb) {
        for (int i = 0; i < tomb.length; i++) {
            tomb[i] = tomb.length - i;
        }
    }

    private static int nEgeszOsszege(int n) {
        int osszeg = 0;
        for (int i = 0; i < n; i++) {
            osszeg += i;
        }
        return osszeg;
    }

    private static int nEgeszNegyzet(int n) {
        int eredmeny = 0;
        for (int i = 0; i < n; i++) {
            eredmeny += Math.pow(i, 2);
        }
        return eredmeny;
    }

    private static String oszthato3_5(int kezdoErtek, int vegErtek) {
//        int[] tomb = new int;
        int index = 0;
        String eredmeny = "";
        for (int i = kezdoErtek; i < vegErtek; i++) {
            if (i % 15 == 0) {
                eredmeny += i + ", ";
                index++;
            }
        }
        return eredmeny;
    }

    private static int szamNegyzete(int szam) {
        return szam * szam;
    }

    private static int szamListaLegnagyobbKereses(ArrayList<Integer> szamLista) {
        int max = 0;
        for (int i = 0; i < szamLista.size(); i++) {
            if (szamLista.get(max) < szamLista.get(i)) {
                max = i;
            }
        }
        return szamLista.get(max);
    }

    private static int szamListaLegkissebbKereses(ArrayList<Integer> szamLista) {
        int min = 0;
        for (int i = 0; i < szamLista.size() - 1; i++) {
            if (szamLista.get(min) > szamLista.get(i)) {
                min = i;
            }
        }
        return szamLista.get(min);
    }

    private static String atvaltasKettesSzamrendszerbe(int beolvasottSzam) {
        int valtozo;
        String binarisSzam = "";
        while (beolvasottSzam > 9) {
            valtozo = beolvasottSzam % 2;
            binarisSzam = valtozo + binarisSzam;
            beolvasottSzam /= 2;
        }
        return binarisSzam;
    }

}
