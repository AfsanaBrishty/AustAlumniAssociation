package austalumniassociationnb;
import static austalumniassociationnb.RequestedApplyTable.jtRowData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
public class SignIn extends javax.swing.JFrame {
    public void clean() 
    {
            stuRadio.setSelected(false);
            adminRadio.setSelected(false);
    }
    public SignIn() {
        initComponents();
        Toolkit toolkit=getToolkit();
        Dimension size=toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    }
    StuProfileFrame jtRowData = new StuProfileFrame();
    UpcomingEvents jtRowData2 = new UpcomingEvents();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idtext = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        login_btn = new javax.swing.JButton();
        stuRadio = new javax.swing.JRadioButton();
        adminRadio = new javax.swing.JRadioButton();
        signupbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password:");

        idtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtextActionPerformed(evt);
            }
        });

        login_btn.setBackground(new java.awt.Color(0, 153, 0));
        login_btn.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        login_btn.setForeground(new java.awt.Color(255, 0, 0));
        login_btn.setText("Log in");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        stuRadio.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        stuRadio.setForeground(new java.awt.Color(255, 0, 0));
        stuRadio.setText("Student");
        stuRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuRadioActionPerformed(evt);
            }
        });

        adminRadio.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        adminRadio.setForeground(new java.awt.Color(255, 0, 0));
        adminRadio.setText("Admin");
        adminRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminRadioActionPerformed(evt);
            }
        });

        signupbtn.setBackground(new java.awt.Color(0, 153, 0));
        signupbtn.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        signupbtn.setForeground(new java.awt.Color(255, 0, 0));
        signupbtn.setText("Sign Up");
        signupbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idtext, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addComponent(pass))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stuRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminRadio)
                        .addGap(83, 83, 83))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(212, 212, 212))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idtext, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuRadio)
                    .addComponent(adminRadio))
                .addGap(18, 18, 18)
                .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtextActionPerformed

    }//GEN-LAST:event_idtextActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
       if(stuRadio.isSelected())
       { 
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
            String query1="Select * From MAINALUMNITABLE where ID=? and Password=?";
            PreparedStatement pst = conn.prepareStatement(query1);
            pst.setString(1,idtext.getText());
            pst.setString(2,pass.getText());
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "ID and Password matched!!");
               
                String query2="Select * From MAINALUMNITABLE where ID=?";
                 PreparedStatement pst2 = conn.prepareStatement(query2);
                 pst2.setString(1,idtext.getText());
                 ResultSet rs2=pst2.executeQuery();
           if(rs2.next())
           {
                String FullName=rs2.getString("Fullname");
                String ID=rs2.getString("id");
                String MailID=rs2.getString("mailid");
                String ContactNo=rs2.getString("contactno");
                String Address=rs2.getString("address");
                String CGPA=rs2.getString("cgpa");
                String Gender=rs2.getString("gender");
                String Department=rs2.getString("department");
                String YearOfAdmission=rs2.getString("yearofadm"
                        + "ission");
                String PassingYear=rs2.getString("passingyear");
           
                idtext.setText("");
                pass.setText("");
                this.setVisible(false);
                jtRowData.setVisible(true);
                jtRowData.pack();
                jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jtRowData.fullname.setText(FullName);
                jtRowData.id.setText(ID);
                jtRowData.email.setText(MailID);
                jtRowData.contactno.setText(ContactNo);
                jtRowData.address.setText(Address);
                jtRowData.cgpa.setText(CGPA);
                jtRowData.gen.setText(Gender);
                jtRowData.dept.setText(Department);
                jtRowData.addyear.setText(YearOfAdmission);
                jtRowData.passyear.setText(PassingYear);

              String idtxt=jtRowData.id.getText();
              String query3="SELECT EventID From MAINALUMNITABLE where ID='"+idtxt+"'";
              PreparedStatement pst3 = conn.prepareStatement(query3);
              ResultSet rs3=pst3.executeQuery();
                  
              String depttxt=jtRowData.dept.getText();
              String query4="SELECT EventID From EVENT_table where Department='"+depttxt+"'  and Status is NULL";
              PreparedStatement pst4 = conn.prepareStatement(query4);
              ResultSet rs4=pst4.executeQuery();
                  if(rs3.next()==rs4.next())
                  {
                jtRowData.nt.setText("You have upcoming events!");
                      jtRowData.nt.setForeground(Color.red);
                  }else
                  {
                      jtRowData.nt.setText("You have no upcoming event!");
                      jtRowData.nt.setForeground(Color.red);
                  }  
           }
            }
            else{
                JOptionPane.showMessageDialog(null, "ID and Password not correct.Please give the correct id or password!!");
                idtext.setText("");
                pass.setText("");
                clean();
            }
            conn.close();
            
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
       }else if(adminRadio.isSelected())
       {
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
            String query1="Select * From ADMINtable where AdminID=? and Password=?";
            PreparedStatement pst3 = conn.prepareStatement(query1);
            pst3.setString(1,idtext.getText());
            pst3.setString(2,pass.getText());
            ResultSet rs3=pst3.executeQuery();
            if(rs3.next()){
                JOptionPane.showMessageDialog(null, "ID and Password matched!!");
                new AdminMenu().setVisible(true);
                this.setVisible(false);
            }

            else{
                JOptionPane.showMessageDialog(null, "ID and Password not correct.Please give the correct id or password!!");
                idtext.setText("");
                pass.setText("");
                clean();
            }
            conn.close();
            
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
       }else{
            JOptionPane.showMessageDialog(null, "Please select whether you are student or admin");
            }
       
      
    }//GEN-LAST:event_login_btnActionPerformed

    private void stuRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuRadioActionPerformed
        if(adminRadio.isSelected())
       {
           stuRadio.setSelected(true);
           adminRadio.setSelected(false);
       }
    }//GEN-LAST:event_stuRadioActionPerformed

    private void signupbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupbtnMouseClicked
        // TODO add your handling code here:
        new ApplyFrame().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_signupbtnMouseClicked

    private void adminRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminRadioActionPerformed
        if(stuRadio.isSelected())
       {
           adminRadio.setSelected(true);
           stuRadio.setSelected(false);
       }
    }//GEN-LAST:event_adminRadioActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton adminRadio;
    private javax.swing.JTextField idtext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton login_btn;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton signupbtn;
    private javax.swing.JRadioButton stuRadio;
    // End of variables declaration//GEN-END:variables
}
