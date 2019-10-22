package deitel;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Conexion {
  //database URL
  static final String DATABASE_URL = "jdbc:mysql://localhost/mysql_db";
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Connection connection = null; // manages connection
    Statement statement = null; // query statement
    ResultSet resultSet = null; // manages results
    
    // connect to database books and query database
    try {
   // establish connection to database
      connection = DriverManager.getConnection(DATABASE_URL, "root", "" );
      // create Statement for querying database
      statement = connection.createStatement();
      // query database
      resultSet = statement.executeQuery("SELECT nombre, password, email FROM usuario" );
      ResultSetMetaData metaData = resultSet.getMetaData();
      int numberOfColumns = metaData.getColumnCount();
      System.out.println( "Tabla Usuario Database:\n" );
      for ( int i = 1; i <= numberOfColumns; i++ )
        System.out.printf( "%-8s\t",metaData.getColumnName( i ) );
      System.out.println();
      while (resultSet.next()) 
      {
        for (int i = 1; i < numberOfColumns; i++)
          System.out.printf("%-8s\t",resultSet.getObject(i));
        System.out.println();
      } // end while
      
    } // end try
    catch (SQLException sqlException) 
    {
      sqlException.printStackTrace();
    } // end catch
    finally // ensure resultSet, statement and connection are closed 
    {
      try {
        resultSet.close();
        statement.close();
        connection.close();
      } //end try 
      catch (Exception exception) 
      {
        exception.printStackTrace();
      }//end catch
    }//end finally    
  } //end main
}// end class Conexion

/*
 *MySQL jdbc:mysql://hostname:portNumber/databaseName
 *ORACLE jdbc:oracle:thin:@hostname:portNumber:databaseName
 *DB2 jdbc:db2:hostname:portNumber/databaseName
 *PostgreSQL jdbc:postgresql://hostname:portNumber/databaseName
 *Java DB/Apache Derby jdbc:derby:dataBaseName (embedded) jdbc:derby://hostname:portNumber/databaseName (network)
 *Microsoft SQL Server jdbc:sqlserver://hostname:portNumber;databaseName=dataBaseName
 *Sybase jdbc:sybase:Tds:hostname:portNumber/databaseName
 * */