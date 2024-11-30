package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        Tulajdonos tulajdonos = new Tulajdonos("Kovács Péter");
        Szamla szamla = new MegtakaritasiSzamla(tulajdonos);
        Kartya kartya = szamla.ujKartya("1234-5678-9012-3456");

        szamla.befizet(10000);
        System.out.println("Egyenleg: " + szamla.getEgyenleg());

        boolean sikeresKivetel = szamla.kivesz(5000);
        System.out.println("Kivetel sikeres: " + sikeresKivetel);
        System.out.println("Egyenleg: " + szamla.getEgyenleg());
    }
}

