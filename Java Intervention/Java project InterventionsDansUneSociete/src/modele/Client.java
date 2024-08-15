package modele;

public class Client {
    private String idClient,Nom,Prenom,Adresse,Sexe,Email; 
    private int Tel;
    
public  Client (String idClient, String Nom, String Prenom, String Adresse, String Sexe, int Tel, String Email ) {
        this.idClient = idClient;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse = Adresse;
        this.Sexe = Sexe;
        this.Tel = Tel;
        this.Email = Email;
        
        
     }
    public Client(){
        
    }
     public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }
    
    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
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

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    
}


