package controller;

import model.CurrencyModel;
import view.CurrencyView;

public class CurrencyController {
    private CurrencyModel model;
    private CurrencyView view;

    public CurrencyController(CurrencyModel model, CurrencyView view) {
        this.model = model;
        this.view = view;
    }

    public void convertCurrency() {
        // Obtener los datos de la vista
        String fromCurrency = view.getFromCurrency();
        String toCurrency = view.getToCurrency();
        double fromAmount = view.getFromAmount();
        double toAmount = view.getToAmount();
        String currencyPair = new StringBuilder(fromCurrency).append("-").append(toCurrency).toString();

        double convertedAmount = 0.0;
        if (fromAmount != 0.0 || toAmount != 0.0) {
            if (fromCurrency.equalsIgnoreCase(toCurrency)) {
                convertedAmount = (fromAmount != 0.0) ? fromAmount : toAmount;
            } else {
                convertedAmount = model.convert(currencyPair, (fromAmount != 0.0) ? fromAmount : toAmount);
            }

            if (fromAmount != 0.0) {
                // Actualizar el campo de cantidad de destino en la vista
                view.setToAmount(convertedAmount);
            } else {
                // Actualizar el campo de cantidad de origen en la vista
                view.setFromAmount(convertedAmount);
            }
        }
    }
}
