package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;

public class CurrencyModel {
    private final HashMap<String, Double> currencys = new HashMap<>();

    public CurrencyModel() {
        currencys.put("MXN-EUR", 0.05);
        currencys.put("MXN-USD", 0.06);
        currencys.put("EUR-MXN", 20.0);
        currencys.put("EUR-USD", 1.2);
        currencys.put("USD-MXN", 17.0);
        currencys.put("USD-EUR", 0.83);
    }

    public double getPair(String key) {
        return currencys.get(key);
    }

    public double convert(String currencyPair, double amount) {

        // Comparando valores de ambos inputs y asignando la conversion a la variable resultado
        double resultado = 0.0;
        
        resultado = amount * getPair(currencyPair);

        // Redondeando el resultado de la conversion a 2 decimales antes de devolver el resultado
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat formato = new DecimalFormat("#.##", symbols);
        String resultadoFormateado = formato.format(resultado);

        return Double.parseDouble(resultadoFormateado);
    }
}
