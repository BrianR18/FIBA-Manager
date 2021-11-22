package Thread;

import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import ui.FIBAGUI;


public class Progress extends Thread{

    private FIBAGUI referencia;
    private ProgressBar bar;
    private double porcentaje;
    public Progress(FIBAGUI td,ProgressBar bar) {
        this.bar = bar;
        porcentaje=0;
        referencia= td;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            porcentaje+=0.05;
            Platform.runLater(() -> { // Para cambiar algo grafico-- desde un hilo alternativo
                bar.setProgress(porcentaje);	//setprogre para el avance
            });
            delay();

        }
        Platform.runLater(() -> { // Para cambiar algo grafico-- desde un hilo alternativo
            try {
                referencia.loadLogin();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }	//setprogre para el avance

        });


    }
    private void delay() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
