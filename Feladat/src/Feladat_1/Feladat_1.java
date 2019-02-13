package Feladat_1;

import java.util.Scanner;

public class Feladat_1 {

    public static void main(String[] args) {

// 1. Írjon programot, mely kiírja a képernyőre az első tíz egész számot 
//    visszafelé!
        int tombHossza = 10;
        int[] tomb = new int[tombHossza];

        tombCsokkenoFeltolt(tomb);
        tombKiir(tomb);

// 2. Alakítsa át az előző programot úgy, hogy az csak a páros számokat írja 
//    a képernyőre!       
        tombParosElemeKiir(tomb);

//3. Írassa ki a képernyőre az első n egész szám összegét!        
        int n = 5;
        int osszeg = nEgeszOsszege(n);
        System.out.println("Első n egész szám összeg: ");
        szamKiir(osszeg);

//4. Írassa ki a képernyőre az első n egész négyzetszámot!               
        int negyzetszam = nEgeszNegyzet(n);
        System.out.println("Első n egész szám négyzetszáma: ");
        szamKiir(negyzetszam);

//5. Írjon programot, mely beolvassa a billentyűzetről egy intervallum kezdő és
//végértékét, majd kiírja a képernyőre az intervallumba eső egész számok közül 
//azokat, melyek 3-mal és 5-tel is oszthatók!  
        int kezdoErtek = 0;
        int vegErtek = 1;
        do {
            kiir("Kérem a kezdő értéket!");
            kezdoErtek = szamBeolvaso();
            kiir("Kérem a végértéket!");
            vegErtek = szamBeolvaso();
            if (kezdoErtek >= vegErtek) {
                kiir("A kezdőérték legyen kisseb, mint a sorozat végértéke!");
            }
        } while (kezdoErtek > vegErtek);
        String eredmeny = oszthato3_5(kezdoErtek, vegErtek);
        if ("".equals(eredmeny)) {
            kiir("A megadott intervallumnak nincs 3-mal vagy 5-tel "
                    + "osztható eleme!");
        } else {
            kiir("A megadott intervallum 3-mal és 5-tel osztható elemei: ");
            kiir(eredmeny);
        }


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
    
}
