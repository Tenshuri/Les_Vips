package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import metier.Apparaitre;
import metier.Vip;
import metier.Photo;

public class DAOPhoto {
    
    private final Connection connexion;

    public DAOPhoto(Connection connexion) {
        this.connexion = connexion;
    }

    public void lireLesPhotos(List<Photo> lesPhotos) throws Exception {
        String requete = "select * from photo;";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {  
            int idphoto = rset.getInt(1);
            String lieu = rset.getString(2);
            int annee = rset.getInt(3);
            String chemin = rset.getString(4);
            lesPhotos.add(new Photo(idphoto, lieu, annee, chemin));
        }
        rset.close();
        pstmt.close();
    }
    
    public void ajouterPhoto(Photo photo) throws SQLException {
        String requete = "insert into photo(lieu, annee, chemin) values(?,?,?);";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, photo.getLieu());
        pstmt.setInt(2, photo.getAnnee());
        pstmt.setString(3, photo.getChemin());
        pstmt.executeUpdate();
        // Récupérer l'id de la photo
        ResultSet genKeys = pstmt.getGeneratedKeys();
        genKeys.next();
        photo.setIdphoto(genKeys.getInt(1));
        
        pstmt.close();
    }
    
    public String recupererChemin(String chemin, int id) throws Exception {
        String requete = "select chemin from photo where idphoto=?;";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, id);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {  
            chemin = rset.getString(1);
        }
        rset.close();
        pstmt.close();
        return chemin;
    }

} // class DAOPhoto
