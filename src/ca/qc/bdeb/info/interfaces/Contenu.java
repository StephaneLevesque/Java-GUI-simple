package ca.qc.bdeb.info.interfaces;

import javax.swing.*;
import java.awt.*;

/**
 * Classe abstraite servant de base pour les différents contenus non-interactifs de la fenêtre sur mesure.
 * @author Stéphane Lévesque
 */
public abstract class Contenu extends JComponent {
    private static final int LARGEUR_CONTENU = 200;
    private static final int HAUTEUR_CONTENU = 50;
    private final JPanel panneau = new JPanel();

    public Contenu() {
        this.add(panneau);

        panneau.setSize(FenetreSurMesure.LARGEUR_PANNEAU, Contenu.HAUTEUR_CONTENU);
        panneau.setMinimumSize(new Dimension(Contenu.LARGEUR_CONTENU, Contenu.HAUTEUR_CONTENU));
    }

    /**
     * Ajoute un composant de contenu.
     *
     * @param composant Composant à ajouter.
     */
    void ajouterComposantContenu(final JComponent composant) {
        panneau.add(composant);
    }
}
