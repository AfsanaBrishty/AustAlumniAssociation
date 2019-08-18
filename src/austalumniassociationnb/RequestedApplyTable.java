package austalumniassociationnb;
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
public class RequestedApplyTable extends javax.swing.JFrame {

    /**
     * Creates new form RequestedApplyTable
     */
    public RequestedApplyTable() {
        initComponents();
        Toolkit toolkit=getToolkit();
        Dimension size=toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        Show_AppliedForm();
    }
    static FullViewofDataFrame jtRowData = new FullViewofDataFrame();
    public ArrayList<User> userList(){
        ArrayList<User> usersList = new ArrayList<>();
        
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject;selectMethod=cursor", "sa", "123456");
            String query1="Select * From APPLYFRAMEDB";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            User us;
            while(rs.next())
            {
                us=new User(rs.getString("FullName"),rs.getInt("ID"),rs.getString("MailID"),rs.getString("ContactNo"),rs.getString("Address"),rs.getString("CGPA"),rs.getString("Gender"),rs.getString("Department"));
            usersList.add(us);
            }
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
        return usersList;
    }
    
    public void Show_AppliedForm(){
        ArrayList<User> list =userList();
        DefaultTableModel model=(DefaultTableModel)requestedapplytable.getModel();
        Object[] row=new Object[8];
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
           model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        requestedapplytable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        requestedapplytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Full Name", "ID", "Mail ID", "Contact No", "Address", "CGPA", "Gender", "Department"
            }
        ));
        requestedapplytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                requestedapplytableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(requestedapplytable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Requested Apply Frame");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void requestedapplytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestedapplytableMouseClicked
int index = requestedapplytable.getSelectedRow();
TableModel model = requestedapplytable.getModel();
String FullName=model.getValueAt(index, 0).toString();
String ID=model.getValueAt(index, 1).toString();
String MailID=model.getValueAt(index, 2).toString();
String ContactNo=model.getValueAt(index, 3).toString();
String Address=model.getValueAt(index, 4).toString();
String CGPA=model.getValueAt(index, 5).toString();
String Gender=model.getValueAt(index, 6).toString();
String Department=model.getValueAt(index, 7).toString();

jtRowData.setTable(requestedapplytable);
jtRowData.setVisible(true);
jtRowData.pack();
jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

jtRowData.fn.setText(FullName);
jtRowData.id_.setText(ID);
jtRowData.mid_.setText(MailID);
jtRowData.cn_.setText(ContactNo);
jtRowData.address_.setText(Address);
jtRowData.cgpa_.setText(CGPA);
jtRowData.gender_.setText(Gender);
jtRowData.dept_.setText(Department);
    }//GEN-LAST:event_requestedapplytableMouseClicked

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
            java.util.logging.Logger.getLogger(RequestedApplyTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestedApplyTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestedApplyTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestedApplyTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new RequestedApplyTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable requestedapplytable;
    // End of variables declaration//GEN-END:variables
}
