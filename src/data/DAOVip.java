package data;

import metier.Role;
import metier.Statut;
import metier.Vip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOVip {

    private final Connection connexion;

    public DAOVip(Connection connexion) throws SQLException {
        this.connexion = connexion;
    }

    public void lireLesVipsLibres(List<Vip> lesVips) throws Exception {
        String requete = "SELECT * FROM vip WHERE codestatut = 1";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);

        Map<Integer, String> nats = new HashMap<>();
        this.getNationalites(nats);

        while (rset.next()) {       // traitement du résulat
            int num = rset.getInt(1);
            String nom = rset.getString(2);
            String prenom = rset.getString(3);
            String civilite = rset.getString(4);
            LocalDate dateNaissance = rset.getDate(5).toLocalDate();
            String lieuNaissance = rset.getString(6);

            Role role = Vip.getRole(rset.getInt(7));
            Statut statut = Vip.getStatut(rset.getInt(8));

            String nationalite = nats.get(rset.getInt(9));

            lesVips.add(new Vip(num, nom, prenom, civilite,
                    dateNaissance, lieuNaissance,
                    role, statut, nationalite));
        }
        rset.close();
        pstmt.close();
    }

    public void lireLesVips(List<Vip> lesVips) throws Exception {
        String requete = "SELECT * FROM vip";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);

        Map<Integer, String> nats = new HashMap<>();
        this.getNationalites(nats);

        while (rset.next()) {       // traitement du résulat
            int num = rset.getInt(1);
            String nom = rset.getString(2);
            String prenom = rset.getString(3);
            String civilite = rset.getString(4);
            LocalDate dateNaissance = rset.getDate(5).toLocalDate();
            String lieuNaissance = rset.getString(6);

            Role role = Vip.getRole(rset.getInt(7));
            Statut statut = Vip.getStatut(rset.getInt(8));

            String nationalite = nats.get(rset.getInt(9));

            lesVips.add(new Vip(num, nom, prenom, civilite,
                    dateNaissance, lieuNaissance,
                    role, statut, nationalite));
        }
        rset.close();
        pstmt.close();
    }



    public void getNationalites(Map<Integer, String> nat) {
        try {
            String requete = "SELECT id, nationalite FROM nationalite";
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
            System.out.println(ex.getMessage());
        }
    }

    public void getCivilites(List<String> civ) {
        try {
            String requete = "SELECT DISTINCT(civilite) FROM vip";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            ResultSet rset = pstmt.executeQuery(requete);
            while (rset.next()) {
                String laciv = rset.getString(1);
                civ.add(laciv);
            }
            rset.close();
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int nationaliteToInt(String nationalite) {
        Map<String, Integer> corresNat = new HashMap<>();
        try {
            String requete = "SELECT id, nationalite FROM nationalite";
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
            System.out.println(ex.getMessage());
        }
        return corresNat.get(nationalite);
    }

    public Vip lireUnVip(int numero) {
        try {
            String requete = "SELECT * FROM vip WHERE idvip = ? ;";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1, numero);
            ResultSet rset = pstmt.executeQuery();
            rset.next();

            int num = rset.getInt(1);
            String nom = rset.getString(2);
            String prenom = rset.getString(3);
            Statut statut = Vip.getStatut(rset.getInt(8));
            LocalDate dateNaissance = rset.getDate(5).toLocalDate();

            Vip vip = new Vip(num, nom, prenom, dateNaissance, statut);

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

    // codeStatut -> le statut qu'on veut avoir apès le changement
    // Libre = 1
    // Marié(e) = 2
    public void changerStatut(int numVip, int codeStatut) {
        try {

            String requete = "UPDATE vip SET codestatut = ? WHERE idvip = ?";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setInt(1, codeStatut);
            pstmt.setInt(2, numVip);
            pstmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Erreur sql dans le changement de Statut " + ex.getMessage());
        }
    }

    public Boolean insererVip(Vip vip) {
        try {
            String requete = "INSERT INTO vip " +
                    "(nom, prenom, civilite, datenaissance, lieunaissance, coderole, codestatut, idnat) " +
                    "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connexion.prepareStatement(requete);
            pstmt.setString(1, vip.getNom());
            pstmt.setString(2, vip.getPrenom());
            pstmt.setString(3, vip.getCivilite());
            pstmt.setDate(4, java.sql.Date.valueOf(vip.getDateNaissance()));
            pstmt.setString(5, vip.getLieuNaissance());
            pstmt.setInt(6, Vip.roleToInt(vip.getRole()));
            pstmt.setInt(7, Vip.statutToInt(vip.getStatut()));
            pstmt.setInt(8, nationaliteToInt(vip.getNationalite()));

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

}
