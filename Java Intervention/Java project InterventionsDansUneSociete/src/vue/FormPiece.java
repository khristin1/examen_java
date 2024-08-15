package vue;
import controleur.*;
import modele.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import java.util.Enumeration;

public class FormPiece extends JFrame implements ActionListener{
    JLabel lidPiece,lNom,lNumero_Referance,lQuantite_Disponible;
    JTextField tidPiece,tNom,tNumero_Referance,tQuantite_Disponible,trech;
    JButton benreg,bvisua,binitia,brech,bupdate,bdel;
    JTable tablePiece;
    int index = 0;
    ArrayList<Piece_de_Rechange> listePiece = new ArrayList(); 
    private final DefaultTableModel model;
    Piece_de_Rechange Piece = null;
    
    public FormPiece(){
    lidPiece = new JLabel("idPiece");
    lidPiece.setBounds(10,30,100,30);
    this.getContentPane().add(lidPiece);
        
    tidPiece = new JTextField();
    tidPiece.setBounds(120,30,100,30);
    this.getContentPane().add(tidPiece);
    
        
    trech = new JTextField();
    trech.setBounds(230,30,100,30);
    this.getContentPane().add(trech);
    
    
    lNom = new JLabel("Nom ");
    lNom .setBounds(10,70,100,30);
    this.getContentPane().add(lNom );
        
    tNom = new JTextField();
    tNom .setBounds(120,70,100,30);
    this.getContentPane().add(tNom);
    
    lNumero_Referance = new JLabel("Numero_Referance");
    lNumero_Referance.setBounds(10,110,100,30);
    this.getContentPane().add(lNumero_Referance);
        
    tNumero_Referance = new JTextField();
    tNumero_Referance.setBounds(120,110,100,30);
    this.getContentPane().add(tNumero_Referance);
    
    lQuantite_Disponible = new JLabel("Quantite_Disponible");
    lQuantite_Disponible.setBounds(10,160,100,30);
    this.getContentPane().add(lQuantite_Disponible);
        
    tQuantite_Disponible = new JTextField();
    tQuantite_Disponible.setBounds(120,160,100,30);
    this.getContentPane().add(tQuantite_Disponible);
           
    benreg = new JButton("Enregistrer");
    benreg.setBounds(10,210,100,30);
    benreg.addActionListener(this);
    this.getContentPane().add(benreg);
     
    bvisua = new JButton("Visualiser");
    bvisua.setBounds(120,210,100,30);
    bvisua.addActionListener(this);
    this.getContentPane().add(bvisua);
    
    binitia = new JButton("Initialiser");
    binitia.setBounds(230,210,100,30);
    binitia.addActionListener(this);
    this.getContentPane().add(binitia);
    
    brech = new JButton("Recherche");
    brech.setBounds(340,210,100,30);
    brech.addActionListener(this);
    this.getContentPane().add(brech);
    
    bupdate = new JButton("Mettre a jour");
    bupdate.setBounds(450,210,100,30);
    bupdate.addActionListener(this);
    this.getContentPane().add(bupdate);
    
    bdel = new JButton("Supprimer");
    bdel.setBounds(560,210,100,30);
    bdel.addActionListener(this);
    this.getContentPane().add(bdel);
    
    model = new DefaultTableModel();
    model.addColumn("idPiece");
    model.addColumn("Nom");
    model.addColumn("Numero_Referance");
    model.addColumn("Quantite_Disponible");
        
    this.getContentPane().setLayout(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==benreg){
            String idPiece = tidPiece.getText();
            String Nom= tNom.getText();
            int Numero_Referance = Integer.valueOf(tNumero_Referance.getText());
            int Quantite_Disponible = Integer.valueOf(tQuantite_Disponible.getText());
                        
            Piece = new Piece_de_Rechange(idPiece,Nom,Numero_Referance,Quantite_Disponible);
            Factory.setPiece(Piece);
        }
        else{
            if(e.getSource()==bvisua){
                afficher();
            }
            else{
                if(e.getSource()==binitia){
                    initialiser();
                }
                else{
//                    Bouton rechercher
                    if(e.getSource()==brech){
                       String rech = String.valueOf(trech.getText());
                       Piece = Factory.getRechPiece(rech);
                        if(Piece != null){
                            tidPiece.setText(String.valueOf(Piece.getIdPiece()));
                            tNom.setText(String.valueOf(Piece.getNom()));
                            tNumero_Referance.setText(String.valueOf(Piece.getNumero_Referance()));
                            tQuantite_Disponible.setText(String.valueOf(Piece.getQuantite_Disponible()));
                            
                            }
                    }
                     
                     else 
                        if(e.getSource()==bupdate){
                    String idPiece= tidPiece.getText();
                    String Nom = tNom.getText();
                    int Numero_Referance = Integer.parseInt(tNumero_Referance.getText());
                    int Quantite_Disponible = Integer.parseInt(tQuantite_Disponible.getText());
                    
                    try {
                         Factory.ModifierPiece(idPiece, Nom, Numero_Referance, Quantite_Disponible);
                         String message = "Piece modifiée avec succes";
                         JOptionPane.showConfirmDialog(this, message);
                    } catch (Exception ex){
                    ex.printStackTrace();
                    }
                    }
                    
                    else{
                            if(e.getSource()==bdel){
                                if(Piece != null){
                                  String msg = "Souhaitez-vous supprimer "+Piece.getIdPiece()+Piece.getNom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelPiece(Piece);
                                        afficher();
                                        initialiser();
                                  }
                                }
                            }
                        }
                    }
                }
            }
        }

   public void afficher(){
        model.setRowCount(0);
        listePiece = Factory.getPiece();
        for(Piece_de_Rechange Piece: listePiece){
            model.addRow(new Object[]{
                Piece.getIdPiece(),Piece.getNom(),Piece.getNumero_Referance(),Piece.getQuantite_Disponible()});
        }
        tablePiece= new JTable(model);
        JScrollPane p = new JScrollPane(tablePiece);
        p.setBounds(40,400,600,100);
        this.getContentPane().add(p);
    }
    public void initialiser(){
        tidPiece.setText("");
        tNom.setText("");
        tNumero_Referance.setText("");
        tQuantite_Disponible.setText("");
}
}



