package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Szamla> szamlak = new ArrayList<>();

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelkeret) {
        if (hitelkeret < 0) {
            throw new IllegalArgumentException("A hitelkeret nem lehet negatív.");
        }
        Szamla szamla = hitelkeret > 0
                ? new HitelSzamla(tulajdonos, hitelkeret)
                : new MegtakaritasiSzamla(tulajdonos);
        szamlak.add(szamla);
        return szamla;
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos) {
        return szamlak.stream()
                .filter(s -> s.getTulajdonos().equals(tulajdonos))
                .mapToInt(Szamla::getEgyenleg)
                .sum();
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        return szamlak.stream()
                .filter(s -> s.getTulajdonos().equals(tulajdonos))
                .max((a, b) -> Integer.compare((int) a.getEgyenleg(), (int) b.getEgyenleg()))
                .orElse(null);
    }

    public int getOsszHitelkeret() {
        return szamlak.stream()
                .filter(s -> s instanceof HitelSzamla)
                .mapToInt(s -> ((HitelSzamla) s).getHitelkeret())
                .sum();
    }
}

