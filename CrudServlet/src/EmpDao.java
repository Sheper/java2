import java.util.*;
import java.sql.*;

public class EmpDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_db", "root", "root");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static int save(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into usuario(nombre,password,email,sexo,pais) values (?,?,?,?,?)");
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getSexo());
			ps.setString(5, e.getPais());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Emp e){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update usuario set nombre=?,password=?,email=?,sexo=?,pais=? where id=?");
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getSexo());
			ps.setString(5, e.getPais());
			ps.setInt(6,e.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from usuario where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Emp getEmployeeById(int id){
		Emp e=new Emp();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from usuario where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setSexo(rs.getString(5));
				e.setPais(rs.getString(6));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Emp> getAllEmployees(){
		List<Emp> list=new ArrayList<Emp>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from usuario");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setSexo(rs.getString(5));
				e.setPais(rs.getString(6));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
