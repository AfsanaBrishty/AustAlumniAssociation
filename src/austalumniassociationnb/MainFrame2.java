package austalumniassociationnb;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame2 extends javax.swing.JFrame {

    public MainFrame2() {
        initComponents();
        Toolkit toolkit=getToolkit();
        Dimension size=toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        Show_MainForm();
        if(combobox.getSelectedIndex()==0)
            {
                findId();
            }
        if(combobox.getSelectedIndex()==1)
            {
                findName();
            }
        if(combobox.getSelectedIndex()==2)
            {
                findDept();
            }
    }
    public Connection getConnection()
    {
        Connection con = null;
        
        try{
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        
        return con;
    }
    public ArrayList<User2> ListUsers(String IdToSearch)
    {
        ArrayList<User2> usersList2 = new ArrayList<User2>();
        
        Statement st2;
        ResultSet rs2;
            if(combobox.getSelectedIndex()==0)
            {
             try{
                 Connection con = getConnection();
                 st2 = con.createStatement();
                 String searchQuery = "SELECT * FROM MAINALUMNITABLE WHERE ID LIKE '%"+IdToSearch+"%'";
                 rs2= st2.executeQuery(searchQuery);
                 
                 User2 user2;
                 
                 while(rs2.next())
                 {
                     user2 = new User2(
                             rs2.getString("FullName"),
                             rs2.getInt("ID"),
                             rs2.getString("CGPA"),
                             rs2.getString("Gender"),
                             rs2.getString("Department"),
                             rs2.getString("YearOfAdmission"),
                             rs2.getString("PassingYear")
                     );
                     usersList2.add(user2);
                 }
                 
             }catch(Exception ex){
                 JOptionPane.showMessageDialog(null,ex);
             }
             
             }
        return usersList2;
    }
    public void findId()
    {
        ArrayList<User2> users2 = ListUsers(searchdata.getText());
        DefaultTableModel model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(new Object[]{"FullName","ID","CGPA","Gender","Department","YearOfAdmission","PassingYear"});
        Object[] row = new Object[7];
        
        for(int i = 0; i < users2.size(); i++)
        {
            row[0] = users2.get(i).getFullName();
            row[1] = users2.get(i).getID();
            row[2] = users2.get(i).getCGPA();
            row[3] = users2.get(i).getGender();
            row[4] = users2.get(i).getDepartment();
            row[5] = users2.get(i).getYearOfAdmission();
            row[6] = users2.get(i).getPassingYear();
            model2.addRow(row);
        }
       AlumniTable2.setModel(model2);
       
    }
    public ArrayList<User2> ListUsers2(String NameToSearch)
    {
        ArrayList<User2> usersList3 = new ArrayList<User2>();
        
        Statement st3;
        ResultSet rs3;
        if(combobox.getSelectedIndex()==1)
        {
        try{
            Connection con = getConnection();
            st3 = con.createStatement();
            String searchQuery2 = "SELECT * FROM MAINALUMNITABLE WHERE FullName LIKE '%"+NameToSearch+"%'";
            rs3= st3.executeQuery(searchQuery2);
            
            User2 user3;
            
            while(rs3.next())
            {
                user3 = new User2(
                                 rs3.getString("FullName"),
                                 rs3.getInt("ID"),
                                 rs3.getString("CGPA"),
                                 rs3.getString("Gender"),
                                 rs3.getString("Department"),
                                 rs3.getString("YearOfAdmission"),
                                 rs3.getString("PassingYear")
                                );
                usersList3.add(user3);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        }
        
        return usersList3;
    }
    public void findName()
    {
        ArrayList<User2> users3 = ListUsers2(searchdata.getText());
        DefaultTableModel model3 = new DefaultTableModel();
        model3.setColumnIdentifiers(new Object[]{"FullName","ID","CGPA","Gender","Department","YearOfAdmission","PassingYear"});
        Object[] row2 = new Object[7];
        
        for(int i = 0; i < users3.size(); i++)
        {
            row2[0] = users3.get(i).getFullName();
            row2[1] = users3.get(i).getID();
            row2[2] = users3.get(i).getCGPA();
            row2[3] = users3.get(i).getGender();
            row2[4] = users3.get(i).getDepartment();
            row2[5] = users3.get(i).getYearOfAdmission();
            row2[6] = users3.get(i).getPassingYear();
            model3.addRow(row2);
        }
       AlumniTable2.setModel(model3);
       
    }
    
    public ArrayList<User2> ListUsers3(String DepartmentToSearch)
    {
        ArrayList<User2> usersList4 = new ArrayList<User2>();
        
        Statement st4;
        ResultSet rs4;
        if(combobox.getSelectedIndex()==2)
        {
        try{
            Connection con = getConnection();
            st4 = con.createStatement();
            String searchQuery3 = "SELECT * FROM MAINALUMNITABLE WHERE Department LIKE '%"+DepartmentToSearch+"%'";
            rs4= st4.executeQuery(searchQuery3);
            
            User2 user4;
            
            while(rs4.next())
            {
                user4 = new User2(
                                 rs4.getString("FullName"),
                                 rs4.getInt("ID"),
                                 rs4.getString("CGPA"),
                                 rs4.getString("Gender"),
                                 rs4.getString("Department"),
                                 rs4.getString("YearOfAdmission"),
                                 rs4.getString("PassingYear")
                                );
                usersList4.add(user4);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        }
        
        return usersList4;
    }
    public void findDept()
    {
        ArrayList<User2> users4 = ListUsers3(searchdata.getText());
        DefaultTableModel model4 = new DefaultTableModel();
        model4.setColumnIdentifiers(new Object[]{"FullName","ID","CGPA","Gender","Department","YearOfAdmission","PassingYear"});
        Object[] row3 = new Object[7];
        
        for(int i = 0; i < users4.size(); i++)
        {
            row3[0] = users4.get(i).getFullName();
            row3[1] = users4.get(i).getID();
            row3[2] = users4.get(i).getCGPA();
            row3[3] = users4.get(i).getGender();
            row3[4] = users4.get(i).getDepartment();
            row3[5] = users4.get(i).getYearOfAdmission();
            row3[6] = users4.get(i).getPassingYear();
            model4.addRow(row3);
        }
       AlumniTable2.setModel(model4);
    }
public ArrayList<User2> userList()
    {
        ArrayList<User2> usersList = new ArrayList<>();
        
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
            String query1="Select * From MAINALUMNITABLE";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            User2 us;
            while(rs.next())
            {
                us=new User2(rs.getString("FullName"),rs.getInt("ID"),rs.getString("CGPA"),rs.getString("Gender"),rs.getString("Department"),rs.getString("YearOfAdmission"),rs.getString("PassingYear"));
            usersList.add(us);
            }
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
        return usersList;
    }
    
    public void Show_MainForm(){
        ArrayList<User2> list =userList();
        DefaultTableModel model=(DefaultTableModel)AlumniTable2.getModel();
        //this.model=model;
        Object[] row=new Object[8];
        for(int i=0;i<list.size();i++)
        {
           row[0]=list.get(i).getFullName();
           row[1]=list.get(i).getID();
           row[2]=list.get(i).getCGPA();
           row[3]=list.get(i).getGender();
           row[4]=list.get(i).getDepartment();
           row[5]=list.get(i).getYearOfAdmission();
           row[6]=list.get(i).getPassingYear();
           model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AlumniTable2 = new javax.swing.JTable();
        backbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combobox = new javax.swing.JComboBox<>();
        searchdata = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ALUMNI TABLE");

        AlumniTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FullName", "ID", "CGPA", "Gender", "Department", "AdmissionYear", "PassingYear"
            }
        ));
        jScrollPane1.setViewportView(AlumniTable2);

        backbtn.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 0, 0));
        backbtn.setText("BACK");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search by:");

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name", "Department" }));

        searchdata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchdataKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(550, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combobox, 0, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchdata)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchdata)
                            .addComponent(combobox))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
         this.setVisible(false);
         //new StuProfileFrame().setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    private void searchdataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdataKeyReleased
    if(combobox.getSelectedIndex()==0)
            {
                findId();
            }
        if(combobox.getSelectedIndex()==1)
            {
                findName();
            }
        if(combobox.getSelectedIndex()==2)
            {
                findDept();
            }
    }//GEN-LAST:event_searchdataKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AlumniTable2;
    private javax.swing.JButton backbtn;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchdata;
    // End of variables declaration//GEN-END:variables
}
