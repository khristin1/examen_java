
package modele;

public class Equipement {
private String idEquipement,Nom,Type_Appareil,Marque; 
    
public  Equipement (String idEquipement, String Nom, String Type_Appareil, String  Marque) {
        this.idEquipement = idEquipement;
        this.Nom = Nom;
        this.Type_Appareil = Type_Appareil;
        this.Marque = Marque;
       
     }
    public Equipement(){
        
    }
    public String getIdEquipement() {
        return idEquipement;
    }

    public void setIdEquipement(String idEquipement) {
        this.idEquipement = idEquipement;
    }
    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    public String getType_Appareil() {
        return Type_Appareil;
    }

    public void setType_Appareil(String Type_Appareil) {
        this.Type_Appareil = Type_Appareil;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String Marque) {
        this.Marque = Marque;
    }

   
}


