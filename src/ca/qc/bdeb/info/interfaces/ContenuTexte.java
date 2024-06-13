package ca.qc.bdeb.info.interfaces;

import javax.swing.*;

/**
 * Classe de contenu textuel non modifiable pour la fenêtre sur mesure.
 * @author Stéphane Lévesque
 */
public class ContenuTexte extends Contenu {
    /**
     * @param texte Le texte à afficher. Supporte certaines balises HTML
     */
    public ContenuTexte(final String texte) {
        final JEditorPane editTexte = new JEditorPane("text/html", texte);
        editTexte.setEditable(false);
        this.ajouterComposantContenu(editTexte);
    }
}
