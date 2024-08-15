package modele;

public class Technicien {
 private String idTech,Nom,Prenom,Disponibilite,Specialite,Adresse,Sexe,Status; 
 private int Tel;
    

     public Technicien(String idTech, String Nom, String Prenom, String Disponibilite, String Specialite, String Adresse, String Sexe, int Tel, String Status) {
        this.idTech = idTech;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Disponibilite = Disponibilite;
        this.Specialite = Specialite;
        this.Adresse = Adresse;
        this.Sexe = Sexe;
        this.Tel = Tel;
        this.Status = Status;
       
        
     }
    public Technicien(){
        
    }

    public String getIdTech() {
        return idTech;
    }

    public void setIdTech(String idTech) {
        this.idTech = idTech;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getDisponibilite() {
        return Disponibilite;
    }

    public void setDisponibilite(String Disponibilite) {
        this.Disponibilite = Disponibilite;
    }

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String Specialite) {
        this.Specialite = Specialite;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }
}