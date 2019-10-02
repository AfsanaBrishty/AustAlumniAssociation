package austalumniassociationnb;
public class User2 {
    private int ID;
private String FullName,CGPA,Gender,Department,YearOfAdmission,PassingYear,Password;

public User2(String FullName,int ID,String CGPA,String Gender,String Department,String YearOfAdmission,String PassingYear)
{
    this.FullName=FullName;
    this.ID=ID;
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
}
