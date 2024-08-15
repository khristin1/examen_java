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

public class FormEquipement extends JFrame implements ActionListener{
    JLabel lidEquipement,lNom,lType_Appareil,lMarque;
    JTextField tidEquipement,tNom,tType_Appareil,tMarque,trech;
    JButton benreg,bvisua,binitia,brech,bupdate,bdel;
    JTable tableEquipement;
    int index = 0;
    ArrayList<Equipement> listeEquipement = new ArrayList(); 
    private final DefaultTableModel model;
    Equipement equi = null;
    
    public FormEquipement(){
    lidEquipement = new JLabel("idEquipement");
    lidEquipement.setBounds(10,30,100,30);
    this.getContentPane().add(lidEquipement);
        
    tidEquipement = new JTextField();
    tidEquipement.setBounds(120,30,100,30);
    this.getContentPane().add(tidEquipement);
    
    trech = new JTextField();
    trech.setBounds(230,30,100,30);
    this.getContentPane().add(trech);
        
    lNom = new JLabel("Nom ");
    lNom .setBounds(10,70,100,30);
    this.getContentPane().add(lNom );
        
    tNom = new JTextField();
    tNom .setBounds(120,70,100,30);
    this.getContentPane().add(tNom);
    
    lType_Appareil = new JLabel("Type_Appareil");
    lType_Appareil.setBounds(10,110,100,30);
    this.getContentPane().add(lType_Appareil);
        
    tType_Appareil = new JTextField();
    tType_Appareil.setBounds(120,110,100,30);
    this.getContentPane().add(tType_Appareil);
    
    lMarque = new JLabel("Marque");
    lMarque.setBounds(10,160,100,30);
    this.getContentPane().add(lMarque);
        
    tMarque = new JTextField();
    tMarque.setBounds(120,160,100,30);
    this.getContentPane().add(tMarque);
           
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
    model.addColumn("idEquipement");
    model.addColumn("Nom");
    model.addColumn("Type_Appareil");
    model.addColumn("Marque");
        
    this.getContentPane().setLayout(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==benreg){
            String idEquipement = tidEquipement.getText();
            String Nom= tNom.getText();
            String Type_Appareil = tType_Appareil.getText();
            String Marque = tMarque.getText();
                        
            equi = new Equipement(idEquipement,Nom,Type_Appareil,Marque);
            Factory.setEquipement(equi);
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
                       equi = Factory.getRechEqui(rech);
                        if(equi != null){
                            tidEquipement.setText(String.valueOf(equi.getIdEquipement()));
                            tNom.setText(String.valueOf(equi.getNom()));
                            tType_Appareil.setText(String.valueOf(equi.getType_Appareil()));
                            tMarque.setText(String.valueOf(equi.getMarque()));
                            
                            }
                    }
                    
                     else 
                        if(e.getSource()==bupdate){
                    String idEquipement= tidEquipement.getText();
                    String Nom = tNom.getText();
                    String Type_Appareil = tType_Appareil.getText();
                    String Marque = tMarque.getText();
                    
                    try {
                         Factory.ModifierEquipement(idEquipement, Nom, Type_Appareil, Marque);
                         String message = "Equipement modifié avec succes";
                         JOptionPane.showConfirmDialog(this, message);
                    } catch (Exception ex){
                    ex.printStackTrace();
                    }
                    }
                    
                    else{
                            if(e.getSource()==bdel){
                                if(equi != null){
                                  String msg = "Souhaitez-vous supprimer "+equi.getNom()+equi.getMarque();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelEquipement(equi);
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
        listeEquipement = Factory.getEquipement();
        for(Equipement equi : listeEquipement){
            model.addRow(new Object[]{
                equi.getIdEquipement(),equi.getNom(),equi.getType_Appareil(),equi.getMarque()});
        }
        tableEquipement= new JTable(model);
        JScrollPane p = new JScrollPane(tableEquipement);
        p.setBounds(40,400,600,100);
        this.getContentPane().add(p);
    }
    public void initialiser(){
        tidEquipement.setText("");
        tNom.setText("");
        tType_Appareil.setText("");
        tMarque.setText("");
}
}



