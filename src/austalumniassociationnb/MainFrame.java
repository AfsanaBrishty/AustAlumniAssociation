package austalumniassociationnb;
import static austalumniassociationnb.RequestedApplyTable.jtRowData;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class MainFrame extends javax.swing.JFrame implements DocumentListener{

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        Toolkit toolkit=getToolkit();
        Dimension size=toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        Show_MainForm();
         searchdata.getDocument().addDocumentListener( this );
    }
           FUllView2 jtRowData = new FUllView2();
    
    //static FullViewofDataFrame jtRowData2 = new FullViewofDataFrame();
    public ArrayList<User> userList()
    {
        ArrayList<User> usersList = new ArrayList<>();
        
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
            String query1="Select * From MAINALUMNITABLE";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            User us;
            while(rs.next())
            {
                us=new User(rs.getString("FullName"),rs.getInt("ID"),rs.getString("MailID"),rs.getString("ContactNo"),rs.getString("Address"),rs.getString("CGPA"),rs.getString("Gender"),rs.getString("Department"),rs.getString("YearOfAdmission"),rs.getString("PassingYear"),rs.getString("Password"));
            usersList.add(us);
            }
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
        return usersList;
    }
    
    public void Show_MainForm(){
        ArrayList<User> list =userList();
        DefaultTableModel model=(DefaultTableModel)MainAlumniTableJframe.getModel();
        Object[] row=new Object[10];
        for(int i=0;i<list.size();i++)
        {
           row[0]=list.get(i).getFullName();
           row[1]=list.get(i).getID();
           row[2]=list.get(i).getMailID();
           row[3]=list.get(i).getContactNo();
           row[4]=list.get(i).getAddress();
           row[5]=list.get(i).getCGPA();
           row[6]=list.get(i).getGender();
           row[7]=list.get(i).getDepartment();
           row[8]=list.get(i).getYearOfAdmission();
           row[9]=list.get(i).getPassingYear();
           model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchdata = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainAlumniTableJframe = new javax.swing.JTable();
        back_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("ALUMNI TABLE");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Search ID:");

        searchdata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchdataKeyReleased(evt);
            }
        });

        MainAlumniTableJframe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FullName", "ID", "MailID", "ContactNo", "Address", "CGPA", "Gender", "Department", "YearOfAdmission", "PassingYear"
            }
        ));
        MainAlumniTableJframe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainAlumniTableJframeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MainAlumniTableJframe);

        back_btn.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        back_btn.setForeground(new java.awt.Color(255, 0, 0));
        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 390, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(400, 400, 400))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchdata, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchdataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchdataKeyReleased
        // TODO add your handling code here:
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
            String query= ("Select FullName,ID,MailID,ContactNo,Address,CGPA,Gender,Department,YearOfAdmission,PassingYear From MAINALUMNITABLE where ID = ?");
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,String.valueOf(searchdata.getText()));
            ResultSet rs = pst.executeQuery();
            MainAlumniTableJframe.setModel(DbUtils.resultSetToTableModel(rs));
            pst.close();
            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_searchdataKeyReleased

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
         new AdminMenu().setVisible(true);
         //this.setVisible(false);
    }//GEN-LAST:event_back_btnActionPerformed

    private void MainAlumniTableJframeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainAlumniTableJframeMouseClicked
        // TODO add your handling code here:
        int index = MainAlumniTableJframe.getSelectedRow();
        TableModel model = MainAlumniTableJframe.getModel();
        String FullName=model.getValueAt(index, 0).toString();
        String ID=model.getValueAt(index, 1).toString();
        String MailID=model.getValueAt(index, 2).toString();
        String ContactNo=model.getValueAt(index, 3).toString();
        String Address=model.getValueAt(index, 4).toString();
        String CGPA=model.getValueAt(index, 5).toString();
        String Gender=model.getValueAt(index, 6).toString();
        String Department=model.getValueAt(index, 7).toString();
        String YearOfAdmission=model.getValueAt(index, 8).toString();
        String PassingYear=model.getValueAt(index, 9).toString();
        
        jtRowData.setVisible(true);
        jtRowData.pack();
        jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        jtRowData.fullname.setText(FullName);
        jtRowData.id.setText(ID);
        jtRowData.eid.setText(MailID);
        jtRowData.cn.setText(ContactNo);
        jtRowData.add.setText(Address);
        jtRowData.cgpa.setText(CGPA);
        jtRowData.gen.setText(Gender);
        jtRowData.dep.setText(Department);
        jtRowData.adyear.setText(YearOfAdmission);
        jtRowData.passyear.setText(PassingYear);
        
    }//GEN-LAST:event_MainAlumniTableJframeMouseClicked
     static void fun()
     {
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new MainFrame().setVisible(true);
                // MainFrame().hh();
            }
            });
         }catch(ClassNotFoundException ex)
         {
             JOptionPane.showMessageDialog(null, ex);
         }catch(SQLException ex)
         {
             JOptionPane.showMessageDialog(null,ex);
         }
     }
       void hh() throws ClassNotFoundException
     {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
            String query= ("Select FullName,ID,MailID,ContactNo,Address,CGPA,Gender,Department,YearOfAdmission,PassingYear From MAINALUMNITABLE order by FullName asc");
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
             MainAlumniTableJframe.setModel(DbUtils.resultSetToTableModel(rs));
            }
            
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
     }
      
    public static void main(String args[]) {
               

        fun();
        
            }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MainAlumniTableJframe;
    private javax.swing.JButton back_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchdata;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
       if(searchdata.getText().isEmpty())
        {
            Show_MainForm();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if(searchdata.getText().isEmpty())
        {
            Show_MainForm();
        }
 }

    @Override
    public void changedUpdate(DocumentEvent e) {
    if(searchdata.getText().isEmpty())
        {
            Show_MainForm();
        }
}
}
