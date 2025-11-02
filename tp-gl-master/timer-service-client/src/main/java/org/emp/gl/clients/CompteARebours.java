package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.beans.PropertyChangeEvent;

public class CompteARebours implements TimerChangeListener {

    private int compteur;
    private final TimerService timerService;
    private final String nom;

    public CompteARebours(String nom, int valeurInitiale, TimerService timerService) {
        this.nom = nom;
        this.compteur = valeurInitiale;
        this.timerService = timerService;

        // S'abonner au service de temps
        timerService.addTimeChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
            if (compteur > 0) {
                compteur--;
                System.out.println(nom + " → Compte à rebours : " + compteur);
            }
            if (compteur == 0) {
                System.out.println(nom + " → Fin du compte à rebours !");
                timerService.removeTimeChangeListener(this);
            }
        }
    }
}
