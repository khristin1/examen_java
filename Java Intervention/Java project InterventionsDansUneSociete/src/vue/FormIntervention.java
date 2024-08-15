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

public class FormIntervention extends JFrame implements ActionListener{
    JLabel lidInterv,lNom,lidTech,lDescription,lDate_Intervention;
    JTextField tidInterv,tNom,tidTech,tDescription,tDate_Intervention,trech;
    JComboBox listeidTech;
    JButton benreg,bvisua,binitia,brech,bupdate,bdel;
    JTable tableIntervention;
    int index = 0;
    ArrayList<Intervention> listeIntervention = new ArrayList(); 
    ArrayList<Technicien> listeTechnicien = new ArrayList();
    private final DefaultTableModel model;
    Intervention Interv = null;
    
    public FormIntervention(){
    lidInterv = new JLabel("idInterv");
    lidInterv.setBounds(10,30,100,30);
    this.getContentPane().add(lidInterv);
        
    tidInterv = new JTextField();
    tidInterv.setBounds(120,30,100,30);
    this.getContentPane().add(tidInterv);
    
    trech = new JTextField();
    trech.setBounds(230,30,100,30);
    this.getContentPane().add(trech);
    
    lNom = new JLabel("Nom ");
    lNom .setBounds(10,70,100,30);
    this.getContentPane().add(lNom );
        
    tNom = new JTextField();
    tNom .setBounds(120,70,100,30);
    this.getContentPane().add(tNom);
    
    lidTech = new JLabel("idTech");
    lidTech.setBounds(10,110,100,30);
    this.getContentPane().add(lidTech);
        
    listeidTech = new JComboBox();
    listeTechnicien = Factory.getTechnicien();
    for(Technicien Tech : listeTechnicien){
        listeidTech.addItem(Tech.getIdTech());
    }
    listeidTech.setBounds(120,110,100,30);
    listeidTech.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            index = listeidTech.getSelectedIndex();
    }
    }
    );
    this.getContentPane().add(listeidTech);
    
    
    lDescription = new JLabel("Description");
    lDescription.setBounds(10,160,100,30);
    this.getContentPane().add(lDescription);
        
    tDescription = new JTextField();
    tDescription.setBounds(120,160,100,30);
    this.getContentPane().add(tDescription);
    
    lDate_Intervention = new JLabel("Date_Intervention");
    lDate_Intervention.setBounds(10,200,100,30);
    this.getContentPane().add(lDate_Intervention);
        
    tDate_Intervention = new JTextField();
    tDate_Intervention.setBounds(120,200,100,30);
    this.getContentPane().add(tDate_Intervention);
           
    benreg = new JButton("Enregistrer");
    benreg.setBounds(10,250,100,30);
    benreg.addActionListener(this);
    this.getContentPane().add(benreg);
     
    bvisua = new JButton("Visualiser");
    bvisua.setBounds(120,250,100,30);
    bvisua.addActionListener(this);
    this.getContentPane().add(bvisua);
    
    binitia = new JButton("Initialiser");
    binitia.setBounds(230,250,100,30);
    binitia.addActionListener(this);
    this.getContentPane().add(binitia);
    
    brech = new JButton("Recherche");
    brech.setBounds(340,250,100,30);
    brech.addActionListener(this);
    this.getContentPane().add(brech);
    
    bupdate = new JButton("Update");
    bupdate.setBounds(450,250,100,30);
    bupdate.addActionListener(this);
    this.getContentPane().add(bupdate);
    
    bdel = new JButton("Delete");
    bdel.setBounds(560,250,100,30);
    bdel.addActionListener(this);
    this.getContentPane().add(bdel);
    
    model = new DefaultTableModel();
    model.addColumn("idInterve");
    model.addColumn("Nom");
    model.addColumn("idTech");
    model.addColumn("Description");
    model.addColumn("Date_Intervention");
        
    this.getContentPane().setLayout(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==benreg){
            String idInterv = tidInterv.getText();
            String Nom= tNom.getText();
            String idTech = String.valueOf(listeidTech.getSelectedItem());
            String Description = tDescription.getText();
            String Date_Intervention = tDate_Intervention.getText();
                        
            Interv = new Intervention(idInterv,Nom,idTech,Description,Date_Intervention);
            Factory.setIntervention(Interv);
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
//                    
                    if(e.getSource()==brech){
                       String rech = String.valueOf(trech.getText());
                       Interv = Factory.getRechIntervention(rech);
                        if(Interv != null){
                            tidInterv.setText(String.valueOf(Interv.getIdInterv()));
                            tNom.setText(String.valueOf(Interv.getNom()));
                            listeidTech.setSelectedItem(Interv.getIdTech());
                            tDescription.setText(String.valueOf(Interv.getDescription()));
                            tDate_Intervention.setText(String.valueOf(Interv.getDate_Intervention()));
                            
                            }
                    }
                    
                     else 
                        if(e.getSource()==bupdate){
                    String idInterv= tidInterv.getText();
                    String Nom = tNom.getText();
                    String idTech = String.valueOf(listeidTech.getSelectedItem());
                    String Description = tDescription.getText();
                    String Date_Intervention = tDate_Intervention.getText();
                    
                    
                    try {
                         Factory.ModifierIntervention(idInterv, Nom, idTech, Description, Date_Intervention);
                         String message = "Intervention modifiée avec succes";
                         JOptionPane.showConfirmDialog(this, message);
                    } catch (Exception ex){
                    ex.printStackTrace();
                    }
                    }
                    
                    else{
                            if(e.getSource()==bdel){
                                if(Interv != null){
                                  String msg = "Souhaitez-vous supprimer "+Interv.getIdInterv()+Interv.getNom();
                                  int rep = JOptionPane.showConfirmDialog(this, msg);
                                  if(rep==0){
                                        Factory.getDelIntervention(Interv);
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
        listeIntervention = Factory.getInterv();
        for(Intervention Interv: listeIntervention){
            model.addRow(new Object[]{
                Interv.getIdInterv(),Interv.getNom(),Interv.getIdTech(),Interv.getDescription(),Interv.getDate_Intervention()});
        }
        tableIntervention= new JTable(model);
        JScrollPane p = new JScrollPane(tableIntervention);
        p.setBounds(40,400,600,100);
        this.getContentPane().add(p);
    }
    public void initialiser(){
        tidInterv.setText("");
        tNom.setText("");
        tidTech.setText("");
        tDescription.setText("");
        tDate_Intervention.setText("");
}
}



