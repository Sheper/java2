package deitel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class usuarioQueries {
  private static final String URL = "jdbc:mysql://localhost/mysql_db";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "";

  private Connection connection = null; // manages connection

  private PreparedStatement selectAllPeople = null;
  private PreparedStatement selectPeopleByLastName = null;
  private PreparedStatement insertNewPerson = null;

  // constructor
  public usuarioQueries() {
    try {
      connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      // create query that selects all entries in the AddressBook
      selectAllPeople = connection.prepareStatement("SELECT * FROM Usuario");
      // create query that selects entries with a specific last name
      selectPeopleByLastName = connection.prepareStatement("SELECT * FROM Usuario WHERE nombre = ?");
      // create insert that adds a new entry into the database
      insertNewPerson = connection.prepareStatement(
          "INSERT INTO Usuario " + "( nombre, password, email, sexo, pais ) " + "VALUES ( ?, ?, ?, ?, ? )");
    } // end try
    catch (SQLException sqlException) {
      sqlException.printStackTrace();
      System.exit(1);
    } // end catch
  } // end PersonQueries constructor

  // select all of the addresses in the database
  public List<Usuario> getAllPeople() {
    List<Usuario> results = null;
    ResultSet resultSet = null;
    try {
      // executeQuery returns ResultSet containing matching entries
      resultSet = selectAllPeople.executeQuery();
      results = new ArrayList<Usuario>();
      while (resultSet.next()) {
        results.add(new Usuario(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("password"),
            resultSet.getString("email"), resultSet.getString("sexo"), resultSet.getString("pais")));
      } // end while
    } // end try
    catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } // end catch
    finally {
      try {
        resultSet.close();
      } // end try
      catch (SQLException sqlException) {
        sqlException.printStackTrace();
        close();
      } // end catch
    } // end finally
    return results;
  } // end method getAllPeople

  public List<Usuario> getPeopleByLastName(String name) {
    List<Usuario> results = null;
    ResultSet resultSet = null;
    try {
      selectPeopleByLastName.setString(1, name); // specify last name
      // executeQuery returns ResultSet containing matching entries
      resultSet = selectPeopleByLastName.executeQuery();
      results = new ArrayList<Usuario>();
      while (resultSet.next()) {
        results.add(new Usuario(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("password"),
            resultSet.getString("email"), resultSet.getString("sexo"), resultSet.getString("pais")));
      } // end while
    } // end try
    catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } // end catch
    finally {
      try {
        resultSet.close();
      } // end try
      catch (SQLException sqlException) {
        sqlException.printStackTrace();
        close();
      } // end catch
    } // end finally
    return results;
  }// end method getPeopleByName

  // add an entry
  public int addPerson(String nombre, String pass, String email, String sexo, String pais) {
    int result = 0;
    // set parameters, then execute insertNewPerson
    try {
      insertNewPerson.setString(1, nombre);
      insertNewPerson.setString(2, pass);
      insertNewPerson.setString(3, email);
      insertNewPerson.setString(4, sexo);
      insertNewPerson.setString(5, pais);
      // insert the new entry; returns # of rows updated
      result = insertNewPerson.executeUpdate();
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
      close();
    } // end catch
    return result;
  } // end method addPerson

  // close the database connection
  public void close() {
    try {
      connection.close();
    } // end try
    catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } // end catch
  } // end method close

}
