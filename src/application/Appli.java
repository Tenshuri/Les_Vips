package application;

import data.DAOApparaitre;
import data.DAOMariages;
import data.DAOPhoto;
import data.DAOVip;
import ihm.FenetreIdentification;
import ihm.FenetreApplication;
import data.SourceMariaDB;
import java.awt.Window;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Appli {
    // réfrences sur les DAO utilisés par l'application
    private static DAOVip daoVip;
    private static DAOMariages daoMariages;
    private static DAOPhoto daoPhoto;
    private static DAOApparaitre daoApparaitre;
    private static Connection laConnexion;

    // les accesseurs aux DAO utilisés par l'application
    public static DAOVip getDaoVip() {
        return daoVip;
    }
    
    public static DAOPhoto getDaoPhoto() {
        return daoPhoto;
    }
    
    public static DAOApparaitre getDaoApparaitre() {
        return daoApparaitre;
    }

    public static DAOMariages getDaoMariages() {
        return daoMariages;
    }
    
    public static void centreWindow(Window frame) {
        frame.setLocationRelativeTo( null );
    }

    public static Connection getLaConnexion() {
        return laConnexion;
    }
    
    

    // le point d'entré du programme
    public static void main(String[] args) {
        // les variables locales
        DataSource laSourceDeDonnees;   // la sourde de données
        laConnexion = null;  // la connexion
        
        // Look and Feel windows
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.print(e.getMessage());
        }

        // Etablissement de la connexion à la base MariaDB avec affichage de la fenetre d'identification 
        boolean etat = false;
        do {
            FenetreIdentification fi = new FenetreIdentification(null);
            PasswordAuthentication login = fi.identifier();
            try {
                laSourceDeDonnees = SourceMariaDB.getSource(login);
                laConnexion = laSourceDeDonnees.getConnection();
                etat = true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "login incorrect : " + ex.getMessage(),
                        "avertissement", JOptionPane.WARNING_MESSAGE);
            }
        } while (etat == false); // tant que la saisie n'est pas correcte

        // Instanciation des objets nécessaires à l'application
        try {
            // les DAO nécessaires
            daoVip = new DAOVip(laConnexion);
            daoMariages = new DAOMariages(laConnexion);
            daoPhoto = new DAOPhoto(laConnexion);
            daoApparaitre = new DAOApparaitre(laConnexion);

            // la fenetre principale de l'application qui tourne dans l'EDT
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new FenetreApplication().setVisible(true);
                    }
                    catch (Exception e) {
                        System.out.println("---");
                    }
                }
            });
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "problème dans la création des objets nécessaires" + ex.getMessage(),
                    "avertissement", JOptionPane.WARNING_MESSAGE);
        }
    }
}
