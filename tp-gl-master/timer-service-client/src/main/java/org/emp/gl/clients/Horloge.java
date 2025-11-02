package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.beans.PropertyChangeEvent;

public class Horloge implements TimerChangeListener {

    private final String nom;
    private final TimerService timerService;

    public Horloge(String nom, TimerService timerService) {
        this.nom = nom;
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // on s'intéresse uniquement aux secondes
        if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
            System.out.println(nom + " → Heure actuelle : " +
                    String.format("%02d:%02d:%02d",
                            timerService.getHeures(),
                            timerService.getMinutes(),
                            timerService.getSecondes()));
        }
    }
}
