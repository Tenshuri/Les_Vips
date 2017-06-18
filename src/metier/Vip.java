package metier;

import java.time.LocalDate;

public class Vip {

    private int num;
    private String nom;
    private String prenom;
    private String civilite;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private Role role;
    private Statut statut;
    private String nationalite;

    public Vip(int num, String nom, String prenom, String civilite,
               LocalDate dateNaissance, String lieuNaissance,
               Role role, Statut statut, String nationalite) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.role = role;
        this.statut = statut;
        this.nationalite = nationalite;
    }

    public Vip(int num, String nom, String prenom, Statut statut) {
        this(num, nom, prenom, null, null, null, null, statut, null);
    }

    public Vip(int num, String nom, String prenom, LocalDate dateNaissance, Statut statut) {
        this(num, nom, prenom, null, dateNaissance, null, null, statut, null);
    }

    public static String statutToString(Statut statut) {
        if (statut == Statut.MARIE) {
            return "Marié(e)";
        } else if (statut == Statut.LIBRE) {
            return "Libre";
        } else {
            return "Inconnu";
        }
    }

    public static int statutToInt(Statut statut) {
        if (statut == Statut.LIBRE) {
            return 1;
        } else if (statut == Statut.MARIE) {
            return 2;
        } else {
            return 3;
        }
    }

    public static Role getRole(int codeRole) throws Exception {
        if (codeRole == 1) return Role.ACTEUR;
        else if (codeRole == 2) return Role.REALISATEUR;
        else if (codeRole == 3) return Role.ACTEUR_REALISATEUR;
        else if (codeRole == 4) return Role.AUTRE;
        else {
            throw new Exception("Le code ne correspond à aucun role");
        }
    }

    public static int roleToInt(Role role) {
        if (role == Role.ACTEUR) return 1;
        else if (role == Role.REALISATEUR) return 2;
        else if (role == Role.ACTEUR_REALISATEUR) return 3;
        else {
            return 4;
        }
    }

    public static Statut getStatut(int codeStatut) throws Exception {
        if (codeStatut == 1) return Statut.LIBRE;
        else if (codeStatut == 2) return Statut.MARIE;
        else if (codeStatut == 3) return Statut.INCONNU;
        else {
            throw new Exception("Le code ne correspond à aucun statut");
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }


}
