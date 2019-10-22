package deitel;

public class Usuario {
  private int ID;
  private String nombre;
  private String password;
  private String email;
  private String sexo;
  private String pais;
  
  
  public Usuario() {
  }
  public Usuario(int iD, String nombre, String password, String email, String sexo, String pais) {
    super();
    ID = iD;
    this.nombre = nombre;
    this.password = password;
    this.email = email;
    this.sexo = sexo;
    this.pais = pais;
  }
  public int getID() {
    return ID;
  }
  public void setID(int iD) {
    ID = iD;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getSexo() {
    return sexo;
  }
  public void setSexo(String sexo) {
    this.sexo = sexo;
  }
  public String getPais() {
    return pais;
  }
  public void setPais(String pais) {
    this.pais = pais;
  }
  
  
}
