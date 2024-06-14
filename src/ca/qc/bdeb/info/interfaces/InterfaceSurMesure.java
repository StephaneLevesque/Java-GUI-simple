package ca.qc.bdeb.info.interfaces;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe pour les interfaces sur mesure.
 *
 * @author Stéphane Lévesque
 */
public class InterfaceSurMesure {
    static final int LARGEUR_PANNEAU = 500;
    /**
     * Fenêtre du questionnaire.
     */
    private final JFrame fenetre;
    /**
     * Panneau contenant les questions.
     */
    private final JPanel panneau = new JPanel(new GridBagLayout());
    /**
     * Bouton pour envoyer les réponses du questionnaire.
     */
    private final JButton btnTermine = new JButton("Terminé");
    /**
     * Contraintes pour le positionnement des composants.
     */
    private GridBagConstraints contraintes = new GridBagConstraints();
    /**
     * Indicateur pour que le thread principal attende la fin du questionnaire.
     */
    private boolean termine = false;
    /**
     * Liste des questions du questionnaire.
     */
    private final List<Question> questions = new ArrayList<>();

    /**
     * Constructeur de l'interface sur mesure.
     * @param titre   Titre de la fenêtre.
     */
    public InterfaceSurMesure(final String titre) {
        fenetre = new JFrame(titre);
        fenetre.setIconImage(new ImageIcon("bdeb.png").getImage());

        contraintes.gridx = 0;
        contraintes.gridy = 0;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.insets = new Insets(10, 10, 10, 10);

        fenetre.add(panneau);
        fenetre.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        btnTermine.addActionListener(e -> termine = true);

    }

    /**
     * Ajoute une question à l'interface.
     *
     * @param question Question à ajouter.
     */
    public void ajouterQuestion(final Question question) {
        questions.add(question);
        panneau.add(question, contraintes);
        contraintes.gridy++;
    }

    /**
     * Ajoute un contenu à l'interface.
     * @param contenu Contenu à ajouter.
     */
    public void ajouterContenu(final Contenu contenu) {
        panneau.add(contenu,contraintes);
        contraintes.gridy++;
    }

    /**
     * Affiche l'interface et attend que l'usager termine.
     *
     * @return Les réponses aux questions.
     */
    public String[] afficherInterface() {
        panneau.add(btnTermine,contraintes);
        fenetre.pack();
        fenetre.setVisible(true);

        while (!termine) {
            try {
                Thread.sleep(100);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
        final String[] reponses = obtenirReponses();
        detruireInterface();
        return reponses;
    }

    private void detruireInterface() {
        fenetre.setVisible(false);
        fenetre.dispose();
    }

    private String[] obtenirReponses() {
        final String[] reponses = new String[questions.size()];
        for (int i = 0; i < questions.size(); i++) {
            reponses[i] = questions.get(i).obtenirReponse();
        }
        return reponses;
    }
}