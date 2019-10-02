package austalumniassociationnb;
class User {
private int ID;
private String FullName,MailID,ContactNo,Address,CGPA,Gender,Department,YearOfAdmission,PassingYear,Password;

public User(String FullName,int ID,String MailID,String ContactNo,String Address,String CGPA,String Gender,String Department,String YearOfAdmission,String PassingYear, String Password)
{
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
}
public String getFullName()
{
    return FullName;
}
public int getID()
{
    return ID;
}
public String getMailID()
{
    return MailID;
}
public String getContactNo()
{
    return ContactNo;
}
public String getAddress()
{
    return Address;
}
public String getCGPA()
{
    return CGPA;
}
public String getGender()
{
    return Gender;
}
public String getDepartment()
{
    return Department;
}
public String getYearOfAdmission()
{
    return YearOfAdmission;
}
public String getPassingYear()
{
    return PassingYear;
}
public String getPassword()
{
    return Password;
}
}
