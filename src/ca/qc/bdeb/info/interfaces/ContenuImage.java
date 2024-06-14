package ca.qc.bdeb.info.interfaces;

import java.awt.*;

/**
 * Classe de contenu graphique pour la fenêtre sur mesure.
 * @author Stéphane Lévesque
 */
public class ContenuImage extends Contenu {
    /**
     * Image à afficher.
     */
    private final Image image;

    /**
     * @param cheminImage Chemin de l'image à afficher.
     */
    public ContenuImage(final String cheminImage) {
        image = Toolkit.getDefaultToolkit().getImage(cheminImage);
        while (image.getWidth(null) == -1) { // Attendre que l'image soit chargée
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setSize(image.getWidth(null), image.getHeight(null));
        this.setMinimumSize(new Dimension(image.getWidth(null), image.getHeight(null)));
        this.setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
    }

    @Override
    public void paint(final Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
