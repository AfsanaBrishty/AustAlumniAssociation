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

public class UpevAdmin extends javax.swing.JFrame {

    public UpevAdmin() {
        initComponents();
        Toolkit toolkit=getToolkit();
        Dimension size=toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        Show_UpEVForm();
    }
    FullView3 jtRowData= new FullView3();
    
    public ArrayList<User3> userList(){
        ArrayList<User3> usersList = new ArrayList<>();
        
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection( "jdbc:sqlserver://localhost:1433;databaseName=AustAlumniAssociationProject1;selectMethod=cursor", "sa", "123456");
            String query1="Select * From EVENT_table where Status is NULL";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            User3 us;
            while(rs.next())
            {
                us=new User3(rs.getInt("EventID"),rs.getString("EventName"),rs.getString("Department"),rs.getString("EventVenue"),rs.getString("EventDate"),rs.getString("EventTime"),rs.getString("EventMessage"));
            usersList.add(us);
            }
           String query3="SELECT Count(Status) As Going\n" +
                          "FROM MAINALUMNITABLE\n" +
                          "GROUP BY Status, Department\n" +
                          "HAVING ( COUNT(Status) > 0 and Status=1 and Department='CSE')";
             Statement st2 = conn.createStatement();
             ResultSet rs2 = st2.executeQuery(query3);
            
            if(rs2.next())
            {
             
              int Count = rs2.getInt(1);
               System.out.println(Count);
            }
            
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
        return usersList;
    }
    
    public void Show_UpEVForm(){
        ArrayList<User3> list =userList();
        DefaultTableModel model=(DefaultTableModel)upevtable.getModel();
        Object[] row=new Object[7];
        for(int i=0;i<list.size();i++)
        {
           row[0]=list.get(i).getEventID();
           row[1]=list.get(i).getEventName();
           row[2]=list.get(i).getDepartment();
           row[3]=list.get(i).getEventVenue();
           row[4]=list.get(i).getEventDate();
           row[5]=list.get(i).getEventTime();
           row[6]=list.get(i).getEventMessage();
           model.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        upevtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        backbtn = new javax.swing.JButton();
        Refreshbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        upevtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EventID", "EventName", "Department", "EventVenue", "EventDate", "EventTime", "Message", "Going", "Interested", "Can't_Go"
            }
        ));
        upevtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upevtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(upevtable);

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 3, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Upcoming Events For Our Ex Students");

        backbtn.setText("Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        Refreshbtn.setText("Refresh");
        Refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Refreshbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backbtn)
                    .addComponent(Refreshbtn)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
         
         this.setVisible(false);
         new AdminMenu().setVisible(true);
    }//GEN-LAST:event_backbtnActionPerformed

    private void upevtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upevtableMouseClicked
        int index = upevtable.getSelectedRow();
        TableModel model = upevtable.getModel();
        String EventID=model.getValueAt(index, 0).toString();
        String EventName=model.getValueAt(index, 1).toString();
        String Department=model.getValueAt(index, 2).toString();
        String EventVenue=model.getValueAt(index, 3).toString();
        String EventDate=model.getValueAt(index, 4).toString();
        String EventTime=model.getValueAt(index, 5).toString();
        String EventMessage=model.getValueAt(index, 6).toString();
        jtRowData.setVisible(true);
        jtRowData.pack();
        jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        jtRowData.evid.setText(EventID);
        jtRowData.ename.setText(EventName);
        jtRowData.dept.setText(Department);
        jtRowData.evenue.setText(EventVenue);
        jtRowData.edate.setText(EventDate);
        jtRowData.etime.setText(EventTime);
        jtRowData.emsg.setText(EventMessage);
    }//GEN-LAST:event_upevtableMouseClicked

    private void RefreshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshbtnActionPerformed
    
    }//GEN-LAST:event_RefreshbtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpevAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refreshbtn;
    private javax.swing.JButton backbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable upevtable;
    // End of variables declaration//GEN-END:variables
}
