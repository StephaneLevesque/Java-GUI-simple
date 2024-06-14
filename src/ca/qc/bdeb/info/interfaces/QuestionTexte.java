package ca.qc.bdeb.info.interfaces;

import javax.swing.*;

/**
 * Classe de question à réponse de type texte pour la fenêtre sur mesure.
 * @author Stéphane Lévesque
 */
public class QuestionTexte extends Question {
    private final JTextField champTexte = new JTextField(20);

    /**
     * @param libelle Libellé de la question.
     */
    public QuestionTexte(final String libelle) {
        super(libelle);
        champTexte.setSize(Question.LARGEUR_QUESTION, Question.HAUTEUR_QUESTION);
        ajouterComposantQuestion(champTexte);
    }

    /**
     * @param libelle Libellé de la question.
     * @param valeurParDefaut Valeur par défaut de la réponse.
     */
    public QuestionTexte(final String libelle, final String valeurParDefaut) {
        this(libelle);
        champTexte.setText(valeurParDefaut);
    }

    @Override
    public String obtenirReponse() {
        return champTexte.getText();
    }
}
