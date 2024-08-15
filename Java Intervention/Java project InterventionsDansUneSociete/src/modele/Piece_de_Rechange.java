package modele;

public class Piece_de_Rechange {
private String idPiece,Nom; 
private int Numero_Referance,Quantite_Disponible;

public  Piece_de_Rechange (String idPiece, String Nom, int Numero_Referance, int  Quantite_Disponible) {
        this.idPiece = idPiece;
        this.Nom = Nom;
        this.Numero_Referance = Numero_Referance;
        this.Quantite_Disponible = Quantite_Disponible;
       
     }
    public Piece_de_Rechange(){
        
    }
    public String getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(String idPiece) {
        this.idPiece = idPiece;
    }
    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    public int getNumero_Referance() {
        return Numero_Referance;
    }

    public void setNumero_Referance(int Numero_Referance) {
        this.Numero_Referance = Numero_Referance;
    }

    public int getQuantite_Disponible() {
        return Quantite_Disponible;
    }

    public void setQuantite_Disponible(int Quantite_Disponible) {
        this.Quantite_Disponible = Quantite_Disponible;
    }

   
}
