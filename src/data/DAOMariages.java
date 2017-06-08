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
    
    //a finir + transformer util.date à sql.date
    public void prepareDivorce(int numero, Date dateMariage, Date dateDivorce ){
        int autreVip = -1;
        String dateMariageSql = dateMariage.toString();
        java.sql.Date dateDivorceSql = new java.sql.Date(dateDivorce.getTime());

        System.out.println(dateDivorce);
        try {
            // regarde si partenaire est vip2 
            //Si il ne l'est pas -> exception car il est donc vip1
            String requete = "select idvip2 from unionmaritale  WHERE idvip1 = ? AND datemariage = ?";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1,numero);
            pstmt.setString(2, dateMariageSql);
            ResultSet rset;
            rset= pstmt.executeQuery();
            rset.next();
            autreVip = rset.getInt(1);
            System.out.println("1ere requete : "+autreVip);
            rset.close();
            pstmt.close();
        } catch (SQLException se) {
            try {
                // Normalement, si on tombe ici, c'est parce que le result set est vide
                String requete = "select idvip1 from unionmaritale  WHERE idvip2 = ? AND datemariage = ?";
                PreparedStatement pstmt = connexion.prepareStatement(requete);
                pstmt.setInt(1,numero);
                pstmt.setString(2, dateMariageSql);
                ResultSet rset;
                rset= pstmt.executeQuery();
                rset.next();
                autreVip = rset.getInt(1);
                System.out.println("2ere requete : "+autreVip);
                rset.close();
                pstmt.close();
            } catch (SQLException ex) {
                //Logger.getLogger(DAOMariages.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        // si on est ici c'est qu'on a récuperer le numéro du vip partenaire futur divocé(e)
        if(autreVip != -1){
        System.out.println("avant setDivorce");            
        setDivorce(numero,autreVip,dateDivorceSql);
        System.out.println("apres setDivorce");
        Appli.getDaoVip().changerStatut(numero, 1);
        Appli.getDaoVip().changerStatut(autreVip, 1);
        }else{
            System.err.println("Erreur dans la requete de la préparation divorce");
        }
    }
    public void setDivorce(int vip1,int vip2, java.sql.Date datedivorce) {
        try {
            String requete = "UPDATE unionmaritale Set datedivorce = ? where (idvip1 = ? and idvip2 = ?) or (idvip1 = ? and idvip2 = ?) and datedivorce IS NULL ;";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setDate(1,datedivorce);
            pstmt.setInt(2,vip1);
            pstmt.setInt(3,vip2);
            pstmt.setInt(4,vip2);
            pstmt.setInt(5,vip1);
            pstmt.executeQuery();
        } catch (SQLException ex) {
           System.out.println("Erreur sql dans setDivorce " + ex.getMessage());
        }
    }
    
    public Date dernierDivorce(int vip){
        try {
            String requete = "Select max(datedivorce) where idvip1 = ?  or idvip2 = ?;";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1,vip);
            pstmt.setInt(2,vip);
            ResultSet rset;
            rset= pstmt.executeQuery();
            rset.next();
            return rset.getDate(1);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void fraichementMarie(int id1, int id2, Date dateM, String lieu){
        try {
            java.sql.Date dateMariageSql = new java.sql.Date(dateM.getTime());
            String requete = "Insert into unionmaritale values(?,?,?,?,null)";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1,id1);
            pstmt.setInt(3,id2);
            pstmt.setDate(2, dateMariageSql);
            pstmt.setString(4,lieu);        
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erreur sql dans fraichementMarié" + ex.getMessage());
        }
            Appli.getDaoVip().changerStatut(id1,2);
            Appli.getDaoVip().changerStatut(id2,2);
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
