package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Statut;
import metier.Vip;

public class DAOMariages {

    private final Connection connexion;

    public DAOMariages(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }

    public Vip lireUnVipMariage(int numero) {
        try {
            String requete = "select * from vip WHERE idvip = ? ;";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1,numero);
            ResultSet rset = pstmt.executeQuery();
            rset.next();
            
            int num = rset.getInt(1);
            String nom = rset.getString(2);
            String prenom = rset.getString(3);
            Statut statut = Vip.getStatut(rset.getInt(8));
            
            Vip vip = new Vip(num,nom,prenom,statut);
            
            rset.close();
            pstmt.close();
            return vip;
            
        } catch (SQLException se) {
            System.out.println("sql " + se.getMessage());
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return null;
    }
    
    // Concerne les vips avec un mariage un cours
    // Retourne la date du dernier mariage (celui qui est en cours)
    public Date getDateMariageEnCours(int numero) {
        try {
           // String requete = "select datemariage from vip V INNER JOIN unionmaritale U ON V.idvip = U.idvip1 WHERE idvip = ? AND datedivorce IS NULL";
            String requete = "select datemariage from unionmaritale  WHERE idvip1 = ? AND datedivorce IS NULL";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1,numero);
            ResultSet rset;
            rset= pstmt.executeQuery();
            rset.next();
            Date dernDateMariage = rset.getDate(1);
            System.out.println("1ere requete : "+dernDateMariage);
            rset.close();
            pstmt.close();
            
           
                

            
            return dernDateMariage;
            
        } catch (SQLException se) {
            try {
                // Normalement, si on tombe ici, c'est parce que le result set est vide
                String requete = "select datemariage from unionmaritale  WHERE idvip2 = ? AND datedivorce IS NULL";
                PreparedStatement pstmt = connexion.prepareStatement(requete);
                pstmt.setInt(1,numero);
                ResultSet rset = pstmt.executeQuery();
                rset.next();
                
                Date dernDateMariage2 = rset.getDate(1);
                System.out.println("2ere requete : "+dernDateMariage2);
                rset.close();
                pstmt.close();
                
                return dernDateMariage2;
            } catch (SQLException ex) {
                //Logger.getLogger(DAOMariages.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        return null;
    }
}
