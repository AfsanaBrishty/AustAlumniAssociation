package austalumniassociationnb;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author User
 */
public class FullViewofDataFrame extends javax.swing.JFrame {

     JTable requestedapplytable;
    private String FullName;
    private String ID;
    private String MailID;
    private String ContactNo;
    private String Address;
    private String CGPA;
    private String Gender;
    private String Department;
    private String YearOfAdmission;
    private String PassingYear;
    private String Password;
    // RequestedApplyTable ratb = new RequestedApplyTable();
    /**
     * Creates new form FullViewofDataFrame
     */
    static String PasswordEncryptor(String Password)
    { 
  
        char[] str1 = Password.toCharArray();
     for (int i = 0; i < Password.length(); i++)
     { 
         int asc = str1[i]; 
         str1[i] = (char)(str1[i] + 5);
     } 
     String PasswordEn = String.valueOf(str1);
     return PasswordEn;
    }
    
    static String PasswordDecryptor(String Password)
    { 
  
        char[] str1 = Password.toCharArray();
     for (int i = 0; i < Password.length(); i++)
     { 
         int asc = str1[i]; 
         str1[i] = (char)(str1[i] - 5);
     } 
     String PasswordEn = String.valueOf(str1);
     return PasswordEn;
    }
     void setTable(JTable requestedapplytable,String FullName,String ID,String MailID,String ContactNo,String Address,String CGPA,String Gender,String Department,String YearOfAdmission,String PassingYear,String Password)
     {
         this.requestedapplytable=requestedapplytable;
         this.FullName=FullName;
         this.ID=ID;
         this.MailID=MailID;
         this.ContactNo=ContactNo;
         this.Address=Address;
         this.CGPA=CGPA;
         this.Gender=Gender;
         this.Department=Department;
         this.YearOfAdmission=YearOfAdmission;
         this.PassingYear=PassingYear;
         this.Password=Password;
         
         setLabel();
                 
     }
    public FullViewofDataFrame() {
        initComponents();
         Toolkit toolkit=getToolkit();
        Dimension size=toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        
       
    }
   void setLabel()
   {
        fn.setText(FullName);
        id_.setText(ID);
        mid_.setText(MailID);
        cn_.setText(ContactNo);
        address_.setText(Address);
        cgpa_.setText(CGPA);
        gender_.setText(Gender);
        dept_.setText(Department);
        adyear_.setText(YearOfAdmission);
        passyear_.setText(PassingYear);
        password_.setText(Password);
   }
    private void clearFields()
{
    fn.setText(null);
    id_.setText(null);
    mid_.setText(null);
    cn_.setText(null);
    address_.setText(null);
    cgpa_.setText(null);
    gender_.setText(null);
    dept_.setText(null);
    adyear_.setText(null);
    passyear_.setText(null);
    password_.setText(null);
}
    public void removeSelectedRows(JTable table){
   DefaultTableModel model = (DefaultTableModel)table.getModel();
   if (table.getSelectedRow() != -1) {
            model.removeRow(table.getSelectedRow());
        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        acceptbtn = new javax.swing.JButton();
        declinebtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        adyear_ = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        passyear_ = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        password_ = new javax.swing.JLabel();
        fn = new javax.swing.JLabel();
        id_ = new javax.swing.JLabel();
        mid_ = new javax.swing.JLabel();
        cn_ = new javax.swing.JLabel();
        address_ = new javax.swing.JLabel();
        cgpa_ = new javax.swing.JLabel();
        gender_ = new javax.swing.JLabel();
        dept_ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Full Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Contact No:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Address:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("CGPA:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Gender:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Department:");

        acceptbtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        acceptbtn.setText("Accept");
        acceptbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptbtnActionPerformed(evt);
            }
        });

        declinebtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        declinebtn.setText("Decline");
        declinebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                declinebtnActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Admission Year:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Passing Year:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(adyear_, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addComponent(passyear_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cn_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(address_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cgpa_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gender_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dept_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(mid_, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(acceptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(declinebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(id_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(mid_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(cn_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(address_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(cgpa_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(gender_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dept_, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(adyear_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(passyear_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(password_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(declinebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptbtnActionPerformed
 try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
            String query= "insert into MAINALUMNITABLE(FullName,ID,MailID,ContactNo,Address,CGPA,Gender,Department,YearOfAdmission,PassingYear,Password) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, fn.getText());
            pst.setInt(2, Integer.parseInt(id_.getText()));
            pst.setString(3, mid_.getText());
            pst.setString(4, cn_.getText());
            pst.setString(5, address_.getText());
            pst.setString(6, cgpa_.getText());
            pst.setString(7, gender_.getText());
            pst.setString(8, dept_.getText());
            pst.setString(9, adyear_.getText());
            pst.setString(10, passyear_.getText());
            String ps=PasswordDecryptor(Password);
            pst.setString(11,ps);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Accepted!!");
           
            /*String idtxt=id_.getText();
            String query2="UPDATE MAINALUMNITABLE\n" +
                          "SET MAINALUMNITABLE.EventID = EVENT_table.EventID\n" +
                          "FROM MAINALUMNITABLE\n" +
                          "INNER JOIN EVENT_table\n" +
                          "ON MAINALUMNITABLE.Department = EVENT_table.Department\n" +
                          "AND EVENT_table.Status is NULL And MAINALUMNITABLE.ID='"+idtxt+"'";
                  PreparedStatement pst2 = conn.prepareStatement(query2);
                  pst2.executeQuery();*/
            this.setVisible(false);
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          int row= requestedapplytable.getSelectedRow();
          String id= (requestedapplytable.getModel().getValueAt(row, 1).toString());
          String query1="Delete From APPLYFRAMEDB where ID="+id;
          PreparedStatement pst1=conn.prepareStatement(query1);
          pst1.executeUpdate();
          removeSelectedRows(requestedapplytable);
          new RequestedApplyTable().Show_AppliedForm();
          
          String idtxt=id_.getText();
            String query2="UPDATE MAINALUMNITABLE\n" +
                          "SET MAINALUMNITABLE.EventID = EVENT_table.EventID\n" +
                          "FROM MAINALUMNITABLE\n" +
                          "INNER JOIN EVENT_table\n" +
                          "ON MAINALUMNITABLE.Department = EVENT_table.Department\n" +
                          "AND EVENT_table.Status is NULL And MAINALUMNITABLE.ID='"+idtxt+"'";
                  PreparedStatement pst2 = conn.prepareStatement(query2);
                  pst2.executeUpdate();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_acceptbtnActionPerformed

    private void declinebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_declinebtnActionPerformed
          int opt=JOptionPane.showConfirmDialog(null, "Do you really want to decline it?", "Decline",JOptionPane.YES_NO_OPTION);
                  if(opt==0)
                  {
            try
           {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
          int row= requestedapplytable.getSelectedRow();
          String id= (requestedapplytable.getModel().getValueAt(row, 1).toString());
          String query="Delete From APPLYFRAMEDB where ID="+id;
          PreparedStatement pst=conn.prepareStatement(query);
          pst.executeUpdate();
          removeSelectedRows(requestedapplytable);
          new RequestedApplyTable().Show_AppliedForm();
          JOptionPane.showMessageDialog(null, "Declined Successfully!!");
          //clearFields();
          this.setVisible(false);
          }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
                  }
    }//GEN-LAST:event_declinebtnActionPerformed

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
            java.util.logging.Logger.getLogger(FullViewofDataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FullViewofDataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FullViewofDataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FullViewofDataFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FullViewofDataFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptbtn;
    private javax.swing.JLabel address_;
    private javax.swing.JLabel adyear_;
    private javax.swing.JLabel cgpa_;
    private javax.swing.JLabel cn_;
    private javax.swing.JButton declinebtn;
    private javax.swing.JLabel dept_;
    private javax.swing.JLabel fn;
    private javax.swing.JLabel gender_;
    private javax.swing.JLabel id_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel mid_;
    private javax.swing.JLabel password_;
    private javax.swing.JLabel passyear_;
    // End of variables declaration//GEN-END:variables
}
