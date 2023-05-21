package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CurrencyModel {
    // Declarando valores constantes para cada par de valores
    private static final double MXN_TO_EUR = 0.05;
    private static final double MXN_TO_USD = 0.06;
    private static final double EUR_TO_MXN = 20.0;
    private static final double EUR_TO_USD = 1.2;
    private static final double USD_TO_MXN = 17.0;
    private static final double USD_TO_EUR = 0.83;

    public double convert(String fromCurrency, String toCurrency, double amount) {
        // En caso de que ambos inputs sean iguales no se hace ninguna operacion
        if (fromCurrency.equals(toCurrency)) {
            return amount;
        }

        // Comparando valores de ambos inputs y asignando la conversion a la variable resultado
        double resultado = 0.0;

        if (fromCurrency.equals("MXN") && toCurrency.equals("EUR")) {
            resultado = amount * MXN_TO_EUR;
        } else if (fromCurrency.equals("MXN") && toCurrency.equals("USD")) {
            resultado = amount * MXN_TO_USD;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("MXN")) {
            resultado = amount * EUR_TO_MXN;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            resultado = amount * EUR_TO_USD;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("MXN")) {
            resultado = amount * USD_TO_MXN;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            resultado = amount * USD_TO_EUR;
        } else {
            return 0.0;
        }

        // Redondeando el resultado de la conversion a 2 decimales antes de devolver el resultado
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat formato = new DecimalFormat("#.##", symbols);
        String resultadoFormateado = formato.format(resultado);

        return Double.parseDouble(resultadoFormateado);
    }
}
