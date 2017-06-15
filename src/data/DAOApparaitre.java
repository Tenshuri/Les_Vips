/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Apparaitre;
import metier.Photo;

/**
 *
 * @author p1512264
 */
public class DAOApparaitre {
    
    private final Connection connexion;

    public DAOApparaitre(Connection connexion) {
        this.connexion = connexion;
    }

//    public void lireLesPhotos(List<Photo> lesPhotos) throws Exception {
//        String requete = "select * from photo";
//        PreparedStatement pstmt = connexion.prepareStatement(requete);
//        ResultSet rset = pstmt.executeQuery(requete);
//        while (rset.next()) {  
//            int idphoto = rset.getInt(1);
//            String lieu = rset.getString(2);
//            int annee = rset.getInt(3);
//
//            lesPhotos.add(new Photo(idphoto, lieu, annee));
//        }
//        rset.close();
//        pstmt.close();
//    }
    
    public void ajouterApparaitre(Apparaitre app) {
        try {
            String requete = "insert into apparaitre(idvip, idphoto) values(?,?)";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1, app.getIdVip());
            pstmt.setInt(2, app.getIdPhoto());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void ajouterVip(Apparaitre app, int numPhoto) {
        try {
            String requete = "insert into apparaitre(idvip, idphoto) values(?,?) ;";
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
