package org.acme.Util;

public class ConversorDeUnidadesUtils {
    public static double metrosParaCentimetros(double metros) {
        return metros * 100;
    }

    // Conversão de metros para polegadas
    public static double metrosParaPolegadas(double metros) {
        return metros * 39.37;
    }

    // Conversão de centímetros para metros
    public static double centimetrosParaMetros(double centimetros) {
        return centimetros / 100;
    }

    // Conversão de centímetros para polegadas
    public static double centimetrosParaPolegadas(double centimetros) {
        return centimetros * 0.3937;
    }

    // Conversão de polegadas para metros
    public static double polegadasParaMetros(double polegadas) {
        return polegadas / 39.37;
    }

    // Conversão de polegadas para centímetros
    public static double polegadasParaCentimetros(double polegadas) {
        return polegadas / 0.3937;
    }
    public static double kgParaGrama(double kg) {
        return kg * 1000;
    }

    public static double gramaParaKg(double grama) {
        return grama / 1000;
    }
    public static double litrosParaGaloes(double litros) {
        return litros / 3.785;
    }

    public static double galoesParaLitros(double galoes) {
        return galoes * 3.785;
    }
}
