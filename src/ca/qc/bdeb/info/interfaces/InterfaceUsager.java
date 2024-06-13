package ca.qc.bdeb.info.interfaces;

import javax.swing.*;

/**
 * Interface usager sommaire pour des programmes de base en Java.
 *
 * @author Stéphane Lévesque
 */
public class InterfaceUsager {
    /**
     * Affiche un message d'information à l'usager.
     *
     * @param message      Le message à afficher.
     * @param titreFenetre Le titre de la fenêtre.
     */
    public void afficherMessage(final String message, final String titreFenetre) {
        JOptionPane.showMessageDialog(null, message, titreFenetre, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Affiche un message d'erreur à l'usager.
     *
     * @param message      Le message à afficher.
     * @param titreFenetre Le titre de la fenêtre.
     */
    public void afficherErreur(final String message, final String titreFenetre) {
        JOptionPane.showMessageDialog(null, message, titreFenetre, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Demande une valeur à l'usager.
     *
     * @param message      Le message à afficher.
     * @param titreFenetre Le titre de la fenêtre.
     * @return La valeur entrée par l'usager, null si l'usager annule.
     */
    public String lireChaine(final String message, final String titreFenetre) {
        return JOptionPane.showInputDialog(null, message, titreFenetre, JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Demande une valeur numérique entière à l'usager.
     *
     * @param message        Le message à afficher.
     * @param titreFenetre   Le titre de la fenêtre.
     * @param valeurMinimale La valeur minimale permise.
     * @param valeurMaximale La valeur maximale permise.
     * @return La valeur numérique entrée par l'usager.
     */
    public int lireEntier(final String message, final String titreFenetre, final int valeurMinimale, final int valeurMaximale) {
        int valeur = 0;
        boolean valeurValide = false;
        do {
            try {
                valeur = Integer.parseInt(JOptionPane.showInputDialog(null, message, titreFenetre, JOptionPane.QUESTION_MESSAGE).trim());
                if (valeur >= valeurMinimale && valeur <= valeurMaximale) {
                    valeurValide = true;
                } else {
                    afficherErreur("La valeur doit être entre " + valeurMinimale + " et " + valeurMaximale + ".", "Erreur de saisie");
                }
            } catch (final NumberFormatException | NullPointerException e) {
                afficherErreur("La valeur doit être un nombre entier.", "Erreur de saisie");
            }
        } while (!valeurValide);
        return valeur;
    }

    /**
     * Demande une valeur numérique réelle à l'usager.
     *
     * @param message        Le message à afficher.
     * @param titreFenetre   Le titre de la fenêtre.
     * @param valeurMinimale La valeur minimale permise.
     * @param valeurMaximale La valeur maximale permise.
     * @return La valeur numérique réelle entrée par l'usager.
     */
    public double lireReel(final String message, final String titreFenetre, final double valeurMinimale, final double valeurMaximale) {
        double valeur = 0;
        boolean valeurValide = false;
        do {
            try {
                valeur = Double.parseDouble(JOptionPane.showInputDialog(null, message, titreFenetre, JOptionPane.QUESTION_MESSAGE).replace(',', '.').trim());
                if (valeur >= valeurMinimale && valeur <= valeurMaximale) {
                    valeurValide = true;
                } else {
                    afficherErreur("La valeur doit être entre " + valeurMinimale + " et " + valeurMaximale + ".", "Erreur de saisie");
                }
            } catch (final NumberFormatException | NullPointerException e) {
                afficherErreur("La valeur doit être un nombre réel.", "Erreur de saisie");
            }
        } while (!valeurValide);
        return valeur;
    }

    /**
     * Demande à l'usager de répondre par oui ou par non.
     *
     * @param message      Le message à afficher.
     * @param titreFenetre Le titre de la fenêtre.
     * @return Vrai si l'usager a répondu oui, faux si l'usager a répondu non ou s'il a annulé la saisie.
     */
    public boolean lireOuiNon(final String message, final String titreFenetre) {
        return 0 == JOptionPane.showOptionDialog(null, message, titreFenetre, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Oui", "Non"}, null);
    }

    /**
     * Demande un choix dans une liste déroulante.
     *
     * @param message      Le message à afficher.
     * @param titreFenetre Le titre de la fenêtre.
     * @param option       Une option à afficher
     * @return L'option choisie, ou null si l'usager a annulé.
     */
    public String lireChoixListeDeroulante(final String message, final String titreFenetre, final String... option) {
        return (String) JOptionPane.showInputDialog(null, message, titreFenetre, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
    }

    /**
     * Demande un choix en cliquant sur un bouton.
     *
     * @param message      Le message à afficher.
     * @param titreFenetre Le titre de la fenêtre.
     * @param option       Une option à afficher
     * @return L'option choisie, ou null si l'usager a annulé.
     */
    public String lireChoixBoutons(final String message, final String titreFenetre, final String... option) {
        final int choix = JOptionPane.showOptionDialog(null, message, titreFenetre, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, null);
        if (JOptionPane.CLOSED_OPTION == choix) {
            return null;
        } else {
            return option[choix];
        }
    }
}
