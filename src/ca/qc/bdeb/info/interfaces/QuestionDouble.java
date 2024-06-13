package ca.qc.bdeb.info.interfaces;

import javax.swing.*;

/**
 * Classe abstraite pour les questions à réponse de type réel.
 * @author Stéphane Lévesque
 */
public class QuestionDouble extends Question {
    private final JSpinner spnReponse = new JSpinner();

    /**
     * @param libelle Libellé de la question.
     * @param valeurMinimale Valeur minimale de la réponse.
     * @param valeurMaximale Valeur maximale de la réponse.
     * @param increment Incrément utilisé par les flèches d'incrément/décrément.
     */
    public QuestionDouble(final String libelle, final double valeurMinimale, final double valeurMaximale, final double increment) {
        super(libelle);

        spnReponse.setSize(Question.LARGEUR_QUESTION, Question.HAUTEUR_QUESTION);
        spnReponse.setModel(new SpinnerNumberModel(valeurMinimale, valeurMinimale, valeurMaximale, increment));

        ajouterComposantQuestion(spnReponse);
    }

    /**
     * @param libelle Libellé de la question.
     * @param valeurMinimale Valeur minimale de la réponse.
     * @param valeurMaximale Valeur maximale de la réponse.
     * @param increment Incrément utilisé par les flèches d'incrément/décrément.
     * @param valeurParDefaut Valeur par défaut de la réponse.
     */
    public QuestionDouble(final String libelle, final double valeurMinimale, final double valeurMaximale, final double increment, final double valeurParDefaut) {
        this(libelle, valeurMinimale, valeurMaximale, increment);
        spnReponse.setValue(valeurParDefaut);
    }

    @Override
    public String obtenirReponse() {
        return spnReponse.getValue().toString();
    }
}
