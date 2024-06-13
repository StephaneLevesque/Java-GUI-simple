package ca.qc.bdeb.info.interfaces;

import javax.swing.*;

/**
 * Classe pour les questions à réponse de type entier.
 */
public class QuestionEntier extends Question {
    private final JSpinner spnReponse = new JSpinner();

    /**
     * @param libelle Libellé de la question.
     * @param valeurMinimale Valeur minimale de la réponse.
     * @param valeurMaximale Valeur maximale de la réponse.
     */
    public QuestionEntier(final String libelle, final int valeurMinimale, final int valeurMaximale) {
        super(libelle);

        spnReponse.setSize(Question.LARGEUR_QUESTION, Question.HAUTEUR_QUESTION);
        spnReponse.setModel(new SpinnerNumberModel(valeurMinimale, valeurMinimale, valeurMaximale, 1));

        ajouterComposantQuestion(spnReponse);
    }

    /**
     * @param libelle Libellé de la question.
     * @param valeurMinimale Valeur minimale de la réponse.
     * @param valeurMaximale Valeur maximale de la réponse.
     * @param valeurParDefaut Valeur par défaut de la réponse.
     */
    public QuestionEntier(final String libelle, final int valeurMinimale, final int valeurMaximale, final int valeurParDefaut) {
        this(libelle, valeurMinimale, valeurMaximale);
        spnReponse.setValue(valeurParDefaut);
    }

    @Override
    public String obtenirReponse() {
        return spnReponse.getValue().toString();
    }
}
