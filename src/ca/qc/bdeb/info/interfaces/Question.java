package ca.qc.bdeb.info.interfaces;

import javax.swing.*;
import java.awt.*;

/**
 * Classe abstraite pour les questions.
 * @author Stéphane Lévesque
 */
public abstract class Question extends JComponent {
    static final int HAUTEUR_QUESTION = 25;
    static final int LARGEUR_QUESTION = 200;

    /**
     * Panneau contenant les composants de la question.
     */
    private final JPanel panneau = new JPanel(new GridLayout(1, 2));

    /**
     * @param libelle Libellé de la question.
     */
    protected Question(final String libelle) {
        this.add(panneau);

        panneau.add(new JLabel(libelle));

        panneau.setSize(InterfaceSurMesure.LARGEUR_PANNEAU, Question.HAUTEUR_QUESTION);
        panneau.setMinimumSize(new Dimension(Question.LARGEUR_QUESTION, Question.HAUTEUR_QUESTION));
        panneau.setPreferredSize(new Dimension(InterfaceSurMesure.LARGEUR_PANNEAU, Question.HAUTEUR_QUESTION));

        this.setSize(InterfaceSurMesure.LARGEUR_PANNEAU, Question.HAUTEUR_QUESTION);
        this.setMinimumSize(new Dimension(Question.LARGEUR_QUESTION, Question.HAUTEUR_QUESTION));
        this.setPreferredSize(new Dimension(InterfaceSurMesure.LARGEUR_PANNEAU, Question.HAUTEUR_QUESTION));
    }

    /**
     * Ajoute un composant à la question.
     *
     * @param composant Composant à ajouter.
     */
    void ajouterComposantQuestion(final JComponent composant) {
        panneau.add(composant);
    }

    /**
     * Obtenir la réponse saisie par l'utilisateur.
     * @return Réponse à la question.
     */
    public abstract String obtenirReponse();
}
