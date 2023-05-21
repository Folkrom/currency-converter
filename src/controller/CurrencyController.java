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

        if (fromAmount != 0.0) {
            // Convertir la moneda de origen a la moneda de destino
            double convertedAmount = model.convert(fromCurrency, toCurrency, fromAmount);
            
            // Actualizar el campo de cantidad de destino en la vista
            view.setToAmount(convertedAmount);
        } else if (toAmount != 0.0) {
            // Convertir la moneda de destino a la moneda de origen
            double convertedAmount = model.convert(toCurrency, fromCurrency, toAmount);
            
            // Actualizar el campo de cantidad de origen en la vista
            view.setFromAmount(convertedAmount);
        }
    }
}
