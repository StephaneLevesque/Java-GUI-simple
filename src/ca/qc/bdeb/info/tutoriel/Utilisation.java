package ca.qc.bdeb.info.tutoriel;

import ca.qc.bdeb.info.interfaces.*;

/**
 * Exemple d'utilisation des interfaces usager simples et sur mesure.
 * @autor Stéphane Lévesque
 */
public class Utilisation {
    public static void main(final String[] args) {
        // Partie 1 : interface usager simple (de type wizard)
        // Créer l'interface usager
        InterfaceSimple interfaceSimple = new InterfaceSimple();

        // Afficher un message d'information
        interfaceSimple.afficherMessage("Ceci est un message d'information.", "Information");
        interfaceSimple.afficherMessage("<html>Ceci est un message d'information avec du <span style='font-style: italic'>HTML</span>.<br><br><u>#wow</u><span style='color:yellow; background-color:black'>wow</span></html>", "Information");
        interfaceSimple.afficherMessage("<html>En tableau !<table><tr><td>allo</td><td>bonjour</td></tr><tr><td>coucou</td><td>salut</td></tr></table></html>", "Information");

        // Afficher un message d'erreur
        interfaceSimple.afficherErreur("Ceci est un message d'erreur.", "Erreur");

        // Demander à l'usager de saisir une chaîne de caractères
        String chaine = interfaceSimple.lireChaine("Entrez du texte.", "Chaîne de caractères");
        System.out.println("Chaîne entrée: " + chaine);

        // Demander à l'usager de saisir une valeur numérique entière
        int valeurEntiere = interfaceSimple.lireEntier("Entrez une valeur numérique.", "Valeur numérique", 0, 10);
        System.out.println("Valeur numérique entrée: " + valeurEntiere);

        // Demander à l'usager de saisir une valeur numérique réelle
        double valeurReelle = interfaceSimple.lireReel("Entrez une valeur réelle.", "Valeur réelle", 0.0, 10.0);
        System.out.println("Valeur réelle entrée: " + valeurReelle);

        // Demander à l'usager de saisir une valeur Oui / Non
        boolean valeurOui = interfaceSimple.lireOuiNon("Choisissez Oui ou Non.", "Valeur Oui / Non");
        System.out.println("Valeur Oui entrée: " + valeurOui);

        // Demander à l'usager de choisir une option dans une liste déroulante ou des boutons
        String choix = interfaceSimple.lireChoixListeDeroulante("Choisissez une option.", "Options", "Roche", "Papier", "Ciseaux");
        System.out.println("Option choisie: " + choix);

        choix = interfaceSimple.lireChoixBoutons("Choisissez une option.", "Options", "Roche", "Papier", "Ciseaux");
        System.out.println("Option choisie: " + choix);

        // Partie 2 : interface usager sur mesure
        // Création d'une fenêtre sur mesure
        InterfaceSurMesure fenetre = new InterfaceSurMesure("Test");

        // Ajout des questions et des contenus
        // Questions à réponse textuelles
        fenetre.ajouterQuestion(new QuestionTexte("Quel est votre nom?"));
        fenetre.ajouterQuestion(new QuestionTexte("Quel est votre prénom?"));

        // Question à choix de réponses
        fenetre.ajouterQuestion(new QuestionChoixReponses("Quel est votre statut?", new String[]{"Étudiant / étudiante", "Employé / Employée", "Perdu / perdue depuis les portes ouvertes"}));

        // Question à réponse entière
        fenetre.ajouterQuestion(new QuestionEntier("Quel est votre âge?", 0, 120));

        // Question à réponse décimale
        fenetre.ajouterQuestion(new QuestionDouble("Quel est votre poids?", 0.1, 500.0, 0.1));

        // Contenu graphique
        fenetre.ajouterContenu(new ContenuImage("arbre.png"));

        // Contenu textuel
        fenetre.ajouterContenu(new ContenuTexte("<html><p>Ceci est <span style='font-family:monospace'; font-weight='bold'>un texte</span>.</p></html>"));

        // Affichage de la fenêtre et récupération des réponses sous forme de tableau de chaînes de caractères
        String[] reponses = fenetre.afficherInterface();

        for (String reponse : reponses) {
            System.out.println("Réponse reçue : \"" + reponse + "\"");
        }
    }
}
