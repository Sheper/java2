
public class Emp {
	private int id;
	private String nombre, password, email, sexo, pais;
	public Emp(int id, String nombre, String password, String email, String sexo, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.sexo = sexo;
		this.pais = pais;
	}
	public Emp() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
