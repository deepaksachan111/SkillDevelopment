package quaere.deepak.skilldevelopment.database;

/**
 * Created by intex on 4/14/2016.
 */
public class Member {
    String name;
    String mobileNo;
    String email;
    String pswd;


    // Empty constructor
    public Member(){

    }
    // constructor
    public Member(String name, String mobileNo, String email, String pswd){
       this.name = name;
       this.mobileNo = mobileNo;
       this.email = email;
       this.pswd = pswd;

    }

    // constructor
    public Member(String name, String email, String pswd){
        this.name = name;
        this.email = email;
        this.pswd = pswd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }


}
