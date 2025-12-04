public class User extends Person implements MenuInterface {

    protected String email;
    protected String password;

    public User(String email, String password, String nama) {
        super(nama);
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public void menu() {
        // Kosong → nanti di-override
    }
}