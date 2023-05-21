import javax.swing.SwingUtilities;

import controller.CurrencyController;
import model.CurrencyModel;
import view.CurrencyView;

public class App {
    public static void main(String[] args) {
        // Invocar la creación de la GUI en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear instancia del modelo
                CurrencyModel model = new CurrencyModel();
                
                // Crear instancia de la vista
                CurrencyView view = new CurrencyView();
                
                // Crear instancia del controlador y pasarle el modelo y la vista
                CurrencyController controller = new CurrencyController(model, view);
                
                // Establecer el controlador en la vista
                view.setController(controller);
                
                // Crear y mostrar la interfaz gráfica
                view.createAndShowGUI();
            }
        });
    }
}
