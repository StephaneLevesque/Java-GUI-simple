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

    private final JPanel panneau = new JPanel(new GridLayout(1, 2));
    private final JLabel lblLibelle;

    /**
     * @param libelle Libellé de la question.
     */
    public Question(final String libelle) {
        this.add(panneau);

        this.lblLibelle = new JLabel(libelle);
        panneau.add(lblLibelle);

        panneau.setSize(FenetreSurMesure.LARGEUR_PANNEAU, Question.HAUTEUR_QUESTION);
        panneau.setMinimumSize(new Dimension(Question.LARGEUR_QUESTION, Question.HAUTEUR_QUESTION));
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
