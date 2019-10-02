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

public class MainFrame extends javax.swing.JFrame implements DocumentListener{
    public MainFrame() {
        initComponents();
        combobox2.setVisible(false);
        Toolkit toolkit=getToolkit();
        Dimension size=toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        Show_MainForm();
         searchdata.getDocument().addDocumentListener( this );
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
        if(combobox.getSelectedIndex()==3)
            {
              //combobox2.setVisible(true);
                System.out.println("Hello");
            }
        if(combobox2.getSelectedIndex()==0)
            {
              AllCG();
            }
       if(combobox2.getSelectedIndex()==1)
            {
              AboveCG();
            }
       if(combobox2.getSelectedIndex()==2)
            {
              BelowCG();
            }
        /*if(combobox.getSelectedIndex()==3)
            {
             combobox2.setVisible(false);
            }*/
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
    public ArrayList<User> ListUsers(String IdToSearch)
    {
        ArrayList<User> usersList2 = new ArrayList<User>();
        
        Statement st2;
        ResultSet rs2;
            if(combobox.getSelectedIndex()==0)
            {
             try{
                 Connection con = getConnection();
                 st2 = con.createStatement();
                 String searchQuery = "SELECT * FROM MAINALUMNITABLE WHERE ID LIKE '%"+IdToSearch+"%'";
                 rs2= st2.executeQuery(searchQuery);
                 
                 User user2;
                 
                 while(rs2.next())
                 {
                     user2 = new User(
                             rs2.getString("FullName"),
                             rs2.getInt("ID"),
                             rs2.getString("MailID"),
                             rs2.getString("ContactNo"),
                             rs2.getString("Address"),
                             rs2.getString("CGPA"),
                             rs2.getString("Gender"),
                             rs2.getString("Department"),
                             rs2.getString("YearOfAdmission"),
                             rs2.getString("PassingYear"),
                             rs2.getString("Password")
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
        ArrayList<User> users2 = ListUsers(searchdata.getText());
        DefaultTableModel model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(new Object[]{"FullName","ID","MailID","ContactNo","Address","CGPA","Gender","Department","YearOfAdmission","PassingYear"});
        Object[] row = new Object[10];
        
        for(int i = 0; i < users2.size(); i++)
        {
            row[0] = users2.get(i).getFullName();
            row[1] = users2.get(i).getID();
            row[2] = users2.get(i).getMailID();
            row[3] = users2.get(i).getContactNo();
            row[4] = users2.get(i).getAddress();
            row[5] = users2.get(i).getCGPA();
            row[6] = users2.get(i).getGender();
            row[7] = users2.get(i).getDepartment();
            row[8] = users2.get(i).getYearOfAdmission();
            row[9] = users2.get(i).getPassingYear();
            model2.addRow(row);
        }
       MainAlumniTableJframe.setModel(model2);
       
    }
    public ArrayList<User> ListUsers2(String NameToSearch)
    {
        ArrayList<User> usersList3 = new ArrayList<User>();
        
        Statement st3;
        ResultSet rs3;
        if(combobox.getSelectedIndex()==1)
        {
        try{
            Connection con = getConnection();
            st3 = con.createStatement();
            String searchQuery2 = "SELECT * FROM MAINALUMNITABLE WHERE FullName LIKE '%"+NameToSearch+"%'";
            rs3= st3.executeQuery(searchQuery2);
            
            User user3;
            
            while(rs3.next())
            {
               user3 = new User(
                                 rs3.getString("FullName"),
                                 rs3.getInt("ID"),
                                 rs3.getString("MailID"),
                                 rs3.getString("ContactNo"),
                                 rs3.getString("Address"),
                                 rs3.getString("CGPA"),
                                 rs3.getString("Gender"),
                                 rs3.getString("Department"),
                                 rs3.getString("YearOfAdmission"),
                                 rs3.getString("PassingYear"),
                                 rs3.getString("Password")
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
        ArrayList<User> users3 = ListUsers2(searchdata.getText());
        DefaultTableModel model3 = new DefaultTableModel();
        model3.setColumnIdentifiers(new Object[]{"FullName","ID","MailID","ContactNo","Address","CGPA","Gender","Department","YearOfAdmission","PassingYear"});
        Object[] row2 = new Object[10];
        
        for(int i = 0; i < users3.size(); i++)
        {
            row2[0] = users3.get(i).getFullName();
            row2[1] = users3.get(i).getID();
            row2[2] = users3.get(i).getMailID();
            row2[3] = users3.get(i).getContactNo();
            row2[4] = users3.get(i).getAddress();
            row2[5] = users3.get(i).getCGPA();
            row2[6] = users3.get(i).getGender();
            row2[7] = users3.get(i).getDepartment();
            row2[8] = users3.get(i).getYearOfAdmission();
            row2[9] = users3.get(i).getPassingYear();
            model3.addRow(row2);
        }
       MainAlumniTableJframe.setModel(model3);
       
    }
    
    public ArrayList<User> ListUsers3(String DepartmentToSearch)
    {
        ArrayList<User> usersList4 = new ArrayList<User>();
        
        Statement st4;
        ResultSet rs4;
        if(combobox.getSelectedIndex()==2)
        {
        try{
            Connection con = getConnection();
            st4 = con.createStatement();
            String searchQuery3 = "SELECT * FROM MAINALUMNITABLE WHERE Department LIKE '%"+DepartmentToSearch+"%'";
            rs4= st4.executeQuery(searchQuery3);
            
            User user4;
            
            while(rs4.next())
            {
                user4 = new User(
                                 rs4.getString("FullName"),
                                 rs4.getInt("ID"),
                                 rs4.getString("MailID"),
                                 rs4.getString("ContactNo"),
                                 rs4.getString("Address"),
                                 rs4.getString("CGPA"),
                                 rs4.getString("Gender"),
                                 rs4.getString("Department"),
                                 rs4.getString("YearOfAdmission"),
                                 rs4.getString("PassingYear"),
                                 rs4.getString("Password")
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
        ArrayList<User> users4 = ListUsers3(searchdata.getText());
        DefaultTableModel model4 = new DefaultTableModel();
        model4.setColumnIdentifiers(new Object[]{"FullName","ID","MailID","ContactNo","Address","CGPA","Gender","Department","YearOfAdmission","PassingYear"});
        Object[] row3 = new Object[10];
        
        for(int i = 0; i < users4.size(); i++)
        {
            row3[0] = users4.get(i).getFullName();
            row3[1] = users4.get(i).getID();
            row3[2] = users4.get(i).getMailID();
            row3[3] = users4.get(i).getContactNo();
            row3[4] = users4.get(i).getAddress();
            row3[5] = users4.get(i).getCGPA();
            row3[6] = users4.get(i).getGender();
            row3[7] = users4.get(i).getDepartment();
            row3[8] = users4.get(i).getYearOfAdmission();
            row3[9] = users4.get(i).getPassingYear();
            model4.addRow(row3);
        }
       MainAlumniTableJframe.setModel(model4);
       
    }
    public ArrayList<User> ListUsers4()
    {
        ArrayList<User> usersList5 = new ArrayList<User>();
        
        Statement st5;
        ResultSet rs5;
        if(combobox2.getSelectedIndex()==1)
        {
        try{
            Connection con = getConnection();
            st5 = con.createStatement();
            String searchQuery4 = "SELECT * FROM MAINALUMNITABLE WHERE CGPA BETWEEN 3.00 and 4.00";
            rs5= st5.executeQuery(searchQuery4);
            
            User user5;
            
            while(rs5.next())
            {
                user5 = new User(
                                 rs5.getString("FullName"),
                                 rs5.getInt("ID"),
                                 rs5.getString("MailID"),
                                 rs5.getString("ContactNo"),
                                 rs5.getString("Address"),
                                 rs5.getString("CGPA"),
                                 rs5.getString("Gender"),
                                 rs5.getString("Department"),
                                 rs5.getString("YearOfAdmission"),
                                 rs5.getString("PassingYear"),
                                 rs5.getString("Password")
                                );
                usersList5.add(user5);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        }
        
        return usersList5;
    }
    public void AboveCG()
    {
        ArrayList<User> users5 = ListUsers4();
        DefaultTableModel model5 = new DefaultTableModel();
        model5.setColumnIdentifiers(new Object[]{"FullName","ID","MailID","ContactNo","Address","CGPA","Gender","Department","YearOfAdmission","PassingYear"});
        Object[] row4 = new Object[10];
        
        for(int i = 0; i < users5.size(); i++)
        {
            row4[0] = users5.get(i).getFullName();
            row4[1] = users5.get(i).getID();
            row4[2] = users5.get(i).getMailID();
            row4[3] = users5.get(i).getContactNo();
            row4[4] = users5.get(i).getAddress();
            row4[5] = users5.get(i).getCGPA();
            row4[6] = users5.get(i).getGender();
            row4[7] = users5.get(i).getDepartment();
            row4[8] = users5.get(i).getYearOfAdmission();
            row4[9] = users5.get(i).getPassingYear();
            model5.addRow(row4);
        }
       MainAlumniTableJframe.setModel(model5);
       
    }
    public ArrayList<User> ListUsers5()
    {
        ArrayList<User> usersList6 = new ArrayList<User>();
        
        Statement st6;
        ResultSet rs6;
        if(combobox2.getSelectedIndex()==0)
        {
        try{
            Connection con = getConnection();
            st6 = con.createStatement();
            String searchQuery5 = "SELECT * FROM MAINALUMNITABLE";
            rs6= st6.executeQuery(searchQuery5);
            
            User user6;
            
            while(rs6.next())
            {
                user6 = new User(
                                 rs6.getString("FullName"),
                                 rs6.getInt("ID"),
                                 rs6.getString("MailID"),
                                 rs6.getString("ContactNo"),
                                 rs6.getString("Address"),
                                 rs6.getString("CGPA"),
                                 rs6.getString("Gender"),
                                 rs6.getString("Department"),
                                 rs6.getString("YearOfAdmission"),
                                 rs6.getString("PassingYear"),
                                 rs6.getString("Password")
                                );
                usersList6.add(user6);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        }
        
        return usersList6;
    }
    public void AllCG()
    {
        ArrayList<User> users6 = ListUsers5();
        DefaultTableModel model6 = new DefaultTableModel();
        model6.setColumnIdentifiers(new Object[]{"FullName","ID","MailID","ContactNo","Address","CGPA","Gender","Department","YearOfAdmission","PassingYear"});
        Object[] row5 = new Object[10];
        
        for(int i = 0; i < users6.size(); i++)
        {
            row5[0] = users6.get(i).getFullName();
            row5[1] = users6.get(i).getID();
            row5[2] = users6.get(i).getMailID();
            row5[3] = users6.get(i).getContactNo();
            row5[4] = users6.get(i).getAddress();
            row5[5] = users6.get(i).getCGPA();
            row5[6] = users6.get(i).getGender();
            row5[7] = users6.get(i).getDepartment();
            row5[8] = users6.get(i).getYearOfAdmission();
            row5[9] = users6.get(i).getPassingYear();
            model6.addRow(row5);
        }
       MainAlumniTableJframe.setModel(model6);
       
    }
  public ArrayList<User> ListUsers6()
    {
        ArrayList<User> usersList7 = new ArrayList<User>();
        
        Statement st7;
        ResultSet rs7;
        if(combobox2.getSelectedIndex()==2)
        {
        try{
            Connection con = getConnection();
            st7 = con.createStatement();
            String searchQuery6 = "SELECT * FROM MAINALUMNITABLE WHERE CGPA<3.00";
            rs7= st7.executeQuery(searchQuery6);
            
            User user7;
            
            while(rs7.next())
            {
                user7 = new User(
                                 rs7.getString("FullName"),
                                 rs7.getInt("ID"),
                                 rs7.getString("MailID"),
                                 rs7.getString("ContactNo"),
                                 rs7.getString("Address"),
                                 rs7.getString("CGPA"),
                                 rs7.getString("Gender"),
                                 rs7.getString("Department"),
                                 rs7.getString("YearOfAdmission"),
                                 rs7.getString("PassingYear"),
                                 rs7.getString("Password")
                                );
                usersList7.add(user7);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        }
        
        return usersList7;
    }
    public void BelowCG()
    {
        ArrayList<User> users7 = ListUsers6();
        DefaultTableModel model7 = new DefaultTableModel();
        model7.setColumnIdentifiers(new Object[]{"FullName","ID","MailID","ContactNo","Address","CGPA","Gender","Department","YearOfAdmission","PassingYear"});
        Object[] row6 = new Object[10];
        
        for(int i = 0; i < users7.size(); i++)
        {
            row6[0] = users7.get(i).getFullName();
            row6[1] = users7.get(i).getID();
            row6[2] = users7.get(i).getMailID();
            row6[3] = users7.get(i).getContactNo();
            row6[4] = users7.get(i).getAddress();
            row6[5] = users7.get(i).getCGPA();
            row6[6] = users7.get(i).getGender();
            row6[7] = users7.get(i).getDepartment();
            row6[8] = users7.get(i).getYearOfAdmission();
            row6[9] = users7.get(i).getPassingYear();
            model7.addRow(row6);
        }
       MainAlumniTableJframe.setModel(model7);
       
    }
    FUllView2 jtRowData = new FUllView2();  //Je Frame e dekhabe Row click er por//
    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        MainAlumniTableJframe = new javax.swing.JTable();
        back_btn = new javax.swing.JButton();
        combobox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        searchdata = new javax.swing.JTextField();
        combobox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Curlz MT", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("ALUMNI TABLE");

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

        back_btn.setBackground(new java.awt.Color(0, 204, 255));
        back_btn.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        back_btn.setForeground(new java.awt.Color(255, 0, 0));
        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name", "Department", "CGPA" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search By: ");

        searchdata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchdataKeyReleased(evt);
            }
        });

        combobox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Above 3.00(including 3.00)", "Below 3.00" }));
        combobox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(399, 399, 399)
                                .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchdata, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
         this.setVisible(false);
         new AdminMenu().setVisible(true);
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
        if(combobox.getSelectedIndex()==3)
            {
              //combobox2.setVisible(true);
                System.out.println("Hello");
            }
    }//GEN-LAST:event_searchdataKeyReleased

    private void combobox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox2ActionPerformed
           if(combobox2.getSelectedIndex()==0)
            {
              AllCG();
            }
       if(combobox2.getSelectedIndex()==1)
            {
              AboveCG();
            }
       if(combobox2.getSelectedIndex()==2)
            {
              BelowCG();
            }
    }//GEN-LAST:event_combobox2ActionPerformed

    public static void main(String args[]) {
            }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MainAlumniTableJframe;
    private javax.swing.JButton back_btn;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JComboBox<String> combobox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchdata;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
       if(searchdata.getText().isEmpty())
        {
            //Show_MainForm();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if(searchdata.getText().isEmpty())
        {
            //Show_MainForm();
        }
 }

    @Override
    public void changedUpdate(DocumentEvent e) {
    if(searchdata.getText().isEmpty())
        {
           // Show_MainForm();
        }
}
}
