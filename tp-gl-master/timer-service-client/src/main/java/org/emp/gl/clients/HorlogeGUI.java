package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import java.awt.Font;
import javax.swing.*;
import java.beans.PropertyChangeEvent;

/**
 * Horloge graphique (Swing) qui affiche l'heure en temps réel.
 */
public class HorlogeGUI extends JFrame implements TimerChangeListener {

    private final JLabel labelHeure = new JLabel("", SwingConstants.CENTER);
    private final TimerService timerService;

    public HorlogeGUI(TimerService timerService) {
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);

        // Configuration graphique
        labelHeure.setFont(new Font("Monospaced", Font.BOLD, 36));
        add(labelHeure);

        setTitle("Horloge Graphique");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (TimerChangeListener.SECONDE_PROP.equals(evt.getPropertyName())) {
            SwingUtilities.invokeLater(() -> {
                String heure = String.format("%02d:%02d:%02d",
                        timerService.getHeures(),
                        timerService.getMinutes(),
                        timerService.getSecondes());
                labelHeure.setText(heure);
            });
        }
    }
}
