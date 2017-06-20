package data;

import metier.Photo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAOPhoto {

    private final Connection connexion;

    public DAOPhoto(Connection connexion) {
        this.connexion = connexion;
    }

    // Récupérer toutes les photos de la base dans la liste données en argument
    public void lireLesPhotos(List<Photo> lesPhotos) throws Exception {
        String requete = "SELECT * FROM photo;";
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

    // Ajouter une photo dans la base
    public void ajouterPhoto(Photo photo) throws SQLException {
        String requete = "INSERT INTO photo(lieu, annee, chemin) VALUES(?,?,?);";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setString(1, photo.getLieu());
        pstmt.setInt(2, photo.getAnnee());
        pstmt.setString(3, photo.getChemin());
        pstmt.executeUpdate();
        // Récupérer l'id de la photo qui vient d'être insérée
        ResultSet genKeys = pstmt.getGeneratedKeys();
        genKeys.next();
        photo.setIdphoto(genKeys.getInt(1));

        pstmt.close();
    }

    // Récuperer le nom d'un photo dans la base
    public String recupererChemin(String chemin, int id) throws Exception {
        String requete = "SELECT chemin FROM photo WHERE idphoto=?;";
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
