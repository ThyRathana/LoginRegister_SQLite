package demo.app.com.sqlite_db.model;

public class UserModel {
//    private int id;
    private String email, password;

    public UserModel(){

    }

    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
