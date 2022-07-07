package br.com.jaiminho.enuns;

import java.util.Arrays;

public enum EnunsProvider {

    SMS_DEV,
    KOMUNIQUE;

    public static EnunsProvider getByName(String name){
        return Arrays
                .stream(EnunsProvider
                            .values())
                .filter(enunsProvider -> enunsProvider.name().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Provider " + name +" unknown"));
    }
}
