package data;

import application.Appli;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;


public class DAOMariages {

    private final Connection connexion;

    public DAOMariages(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }

    // Concerne les vips avec un mariage un cours
    // Retourne la date du dernier mariage (celui qui est en cours)
    public LocalDate getDateMariageEnCours(int numero) {
        try {
            String requete = "SELECT datemariage FROM unionmaritale  WHERE idvip1 = ? AND datedivorce IS NULL";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1, numero);
            ResultSet rset;
            rset = pstmt.executeQuery();
            rset.next();
            LocalDate dernDateMariage = rset.getDate(1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            rset.close();
            pstmt.close();

            return dernDateMariage;

        } catch (SQLException se) {
            try {
                // Normalement, si on tombe ici, c'est parce que le result set est vide
                String requete = "SELECT datemariage FROM unionmaritale  WHERE idvip2 = ? AND datedivorce IS NULL";
                PreparedStatement pstmt = connexion.prepareStatement(requete);
                pstmt.setInt(1, numero);
                ResultSet rset = pstmt.executeQuery();
                rset.next();

                LocalDate dernDateMariage2 = rset.getDate(1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                rset.close();
                pstmt.close();

                return dernDateMariage2;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void prepareDivorce(int numero, Date dateMariage, Date dateDivorce) {
        int autreVip = -1;
        String dateMariageSql = dateMariage.toString();
        java.sql.Date dateDivorceSql = new java.sql.Date(dateDivorce.getTime());

        System.out.println(dateDivorce);
        try {
            // regarde si partenaire est vip2 
            //Si il ne l'est pas -> exception car il est donc vip1
            String requete = "SELECT idvip2 FROM unionmaritale  WHERE idvip1 = ? AND datemariage = ?";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1, numero);
            pstmt.setString(2, dateMariageSql);
            ResultSet rset;
            rset = pstmt.executeQuery();
            rset.next();
            autreVip = rset.getInt(1);
            rset.close();
            pstmt.close();
        } catch (SQLException se) {
            try {
                // Normalement, si on tombe ici, c'est parce que le result set est vide
                String requete = "SELECT idvip1 FROM unionmaritale  WHERE idvip2 = ? AND datemariage = ?";
                PreparedStatement pstmt = connexion.prepareStatement(requete);
                pstmt.setInt(1, numero);
                pstmt.setString(2, dateMariageSql);
                ResultSet rset;
                rset = pstmt.executeQuery();
                rset.next();
                autreVip = rset.getInt(1);
                rset.close();
                pstmt.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // si on est ici c'est qu'on a récuperé le numéro du vip partenaire futur divocé(e)
        if (autreVip != -1) {
            setDivorce(numero, autreVip, dateDivorceSql);
            Appli.getDaoVip().changerStatut(numero, 1);
            Appli.getDaoVip().changerStatut(autreVip, 1);
        } else {
            System.err.println("Erreur dans la requete de la préparation divorce");
        }
    }

    public void setDivorce(int vip1, int vip2, java.sql.Date datedivorce) {
        try {
            String requete = "UPDATE unionmaritale SET datedivorce = ? " +
                    "WHERE (idvip1 = ? AND idvip2 = ?)" +
                    " OR (idvip1 = ? AND idvip2 = ?)" +
                    " AND datedivorce IS NULL ;";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setDate(1, datedivorce);
            pstmt.setInt(2, vip1);
            pstmt.setInt(3, vip2);
            pstmt.setInt(4, vip2);
            pstmt.setInt(5, vip1);
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erreur sql dans setDivorce " + ex.getMessage());
        }
    }

    public LocalDate dernierDivorce(int vip) {
        try {
            String requete = "SELECT max(datedivorce) FROM unionmaritale WHERE idvip1 = ?  OR idvip2 = ?;";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1, vip);
            pstmt.setInt(2, vip);
            ResultSet rset;
            rset = pstmt.executeQuery();
            rset.next();
            return rset.getDate(1).toLocalDate();
        } catch (SQLException ex) {
            // Il n'y a pas de dernier divorce
            return null;
        }
    }

    public void fraichementMarie(int id1, int id2, Date dateM, String lieu) {
        try {
            java.sql.Date dateMariageSql = new java.sql.Date(dateM.getTime());
            String requete = "INSERT INTO unionmaritale VALUES(?,?,?,?,NULL)";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1, id1);
            pstmt.setInt(3, id2);
            pstmt.setDate(2, dateMariageSql);
            pstmt.setString(4, lieu);
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erreur sql dans fraichementMarié" + ex.getMessage());
        }
        Appli.getDaoVip().changerStatut(id1, 2);
        Appli.getDaoVip().changerStatut(id2, 2);
    }
}
