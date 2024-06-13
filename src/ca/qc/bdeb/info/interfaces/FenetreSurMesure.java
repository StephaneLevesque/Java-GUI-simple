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
public class FenetreSurMesure {
    static final int LARGEUR_PANNEAU = 500;
    /**
     * Fenêtre du questionnaire.
     */
    private final JFrame fenetre;
    /**
     * Panneau contenant les questions.
     */
    private final JPanel panneau;
    private final JButton btnTermine = new JButton("Terminé");
    private boolean termine;

    private final List<Question> questions = new ArrayList<>();

    public FenetreSurMesure(final String titre, final int hauteur, final int largeur) {
        fenetre = new JFrame(titre);
        fenetre.setIconImage(new ImageIcon("bdeb.png").getImage());
        panneau = new JPanel();
        panneau.setLayout(new GridLayout(0, 1, 10, 10));
        fenetre.add(panneau);
        fenetre.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        btnTermine.addActionListener(e -> {
            termine = true;
        });

        fenetre.setSize(largeur, hauteur);
    }

    public void ajouterQuestion(final Question question) {
        questions.add(question);
        panneau.add(question);
    }

    public void ajouterContenu(final Contenu contenu) {
        panneau.add(contenu);
    }

    public String[] afficherInterface() {
        panneau.add(btnTermine);

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
