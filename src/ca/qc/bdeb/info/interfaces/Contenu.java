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

    protected Contenu() {
        this.add(panneau);

        panneau.setSize(InterfaceSurMesure.LARGEUR_PANNEAU, Contenu.HAUTEUR_CONTENU);
        panneau.setPreferredSize(new Dimension(Contenu.LARGEUR_CONTENU, Contenu.HAUTEUR_CONTENU));
        panneau.setMinimumSize(new Dimension(Contenu.LARGEUR_CONTENU, Contenu.HAUTEUR_CONTENU));

        this.setSize(InterfaceSurMesure.LARGEUR_PANNEAU, Contenu.HAUTEUR_CONTENU);
        this.setPreferredSize(new Dimension(Contenu.LARGEUR_CONTENU, Contenu.HAUTEUR_CONTENU));
        this.setMinimumSize(new Dimension(Contenu.LARGEUR_CONTENU, Contenu.HAUTEUR_CONTENU));
    }

    /**
     * Ajoute un composant de contenu.
     *
     * @param composant Composant à ajouter.
     */
    void ajouterComposantContenu(final JComponent composant) {
        panneau.add(composant);

        this.setPreferredSize(new Dimension(Math.max(Contenu.LARGEUR_CONTENU,composant.getPreferredSize().width), Math.max(Contenu.HAUTEUR_CONTENU,composant.getPreferredSize().height)));
        this.setMinimumSize(new Dimension(Math.max(Contenu.LARGEUR_CONTENU,composant.getPreferredSize().width), Math.max(Contenu.HAUTEUR_CONTENU,composant.getPreferredSize().height)));
        this.setSize(Math.max(Contenu.LARGEUR_CONTENU,composant.getPreferredSize().width), Math.max(Contenu.HAUTEUR_CONTENU,composant.getPreferredSize().height));
    }
}
