package ca.qc.bdeb.info.interfaces;

import javax.swing.*;

/**
 * Classe de question à choix de réponses pour la fenêtre sur mesure.
 * @author Stéphane Lévesque
 */
public class QuestionChoixReponses extends Question {
    private final JComboBox<String> listeReponses;

    /**
     * @param libelle Libellé de la question.
     * @param choixReponses Choix de réponses possibles.
     */
    public QuestionChoixReponses(final String libelle, final String[] choixReponses) {
        super(libelle);
        listeReponses = new JComboBox<>(choixReponses);
        ajouterComposantQuestion(listeReponses);
    }

    @Override
    public String obtenirReponse() {
        return (String) listeReponses.getSelectedItem();
    }
}
