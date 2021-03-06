package data;

import metier.Apparaitre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOApparaitre {

    private final Connection connexion;

    public DAOApparaitre(Connection connexion) {
        this.connexion = connexion;
    }

    // Faire apparaître un vip sur une photo (table apparaitre)
    public void ajouterApparaitre(Apparaitre app, int numPhoto) {
        try {
            String requete = "INSERT INTO apparaitre(idvip, idphoto) VALUES(?,?) ;";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1, app.getIdVip());
            pstmt.setInt(2, numPhoto);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
