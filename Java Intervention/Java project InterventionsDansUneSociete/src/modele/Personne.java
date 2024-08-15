
package modele;

public class Personne {
    private String Nom,Prenom,Adresse;
    private int Age;
    
    public Personne(String N,String P, int a, String Adr){
    
        Nom = N;
        Prenom = P;
        Age = a;
        Adresse = Adr;
        
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public int getAge() {
        return Age;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
  
}