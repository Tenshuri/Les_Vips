package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import metier.Role;
import metier.Statut;
import metier.Vip;

/**
 *
 * @author Alain
 */
public class DAOVip {

    private final Connection connexion;

    public DAOVip(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }
    


    public void lireLesVips(List<Vip> lesVips) throws Exception {
        String requete = "select * from vip";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int num = rset.getInt(1);
            String nom = rset.getString(2);
            String prenom = rset.getString(3);
            String civilite = rset.getString(4);
            LocalDate dateNaissance = rset.getDate(5).toLocalDate();
            String lieuNaissance = rset.getString(6);
            
            Role role = Vip.getRole(rset.getInt(7));
            Statut statut = Vip.getStatut(rset.getInt(8));
            
            String nationalite = rset.getString(9);
                        
            lesVips.add(new Vip(num,  nom, prenom, civilite, 
                                dateNaissance, lieuNaissance,
                                role, statut, nationalite));
        }
        rset.close();
        pstmt.close();
    }
    
    public void getNationalites(Map<Integer, String> nat) {
        try {
            String requete = "select id, nationalite from nationalite";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            ResultSet rset = pstmt.executeQuery(requete);
            while (rset.next()) {
                int id = rset.getInt(1);
                String lanat = rset.getString(2);
                nat.put(id, lanat);
            }
            rset.close();
            pstmt.close();
        } catch (SQLException ex) {
            //
        }
    }
    
    public void getCivilites(List<String> civ) {
        try {
            String requete = "select distinct(civilite) from vip";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            ResultSet rset = pstmt.executeQuery(requete);
            while (rset.next()) {
                String laciv = rset.getString(1);
                civ.add(laciv);
            }
            rset.close();
            pstmt.close();
        } catch (SQLException ex) {
            //
        }
    }
    
    public int nationaliteToInt(String nationalite) {
        Map<String, Integer> corresNat = new HashMap<>();
        try {
            String requete = "select id, nationalite from nationalite";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            ResultSet rset = pstmt.executeQuery(requete);
            while (rset.next()) {
                int idNat = rset.getInt(1);
                String nat = rset.getString(2);
                corresNat.put(nat, idNat);
            }
            rset.close();
            pstmt.close();
        } catch (SQLException ex) {
            //
        }
        return corresNat.get(nationalite);
    }
    
    public Boolean insererVip(Vip vip) {
        try {
            String requete = "insert into vip (nom, prenom, civilite, datenaissance, lieunaissance, coderole, codestatut, idnat) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setString(1, vip.getNom());
            pstmt.setString(2, vip.getPrenom());
            pstmt.setString(3, vip.getCivilite());
            pstmt.setDate(4, java.sql.Date.valueOf(vip.getDateNaissance()));
            pstmt.setString(5, vip.getLieuNaissance());
            pstmt.setInt(6, vip.roleToInt(vip.getRole()));
            pstmt.setInt(7, vip.statutToInt(vip.getStatut()));
            pstmt.setInt(8, nationaliteToInt(vip.getNationalite()));
            
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch (SQLException e) {
            return false;
        }
        
        return true;
    }
    
}
