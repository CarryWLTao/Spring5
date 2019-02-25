package com.wlt.dbAssit;
import java.sql.Connection;
import javax.sql.DataSource;
public class DataSourceUtils {
	private static ThreadLocal<Connection> tl = new ThreadLocal();
	  
	  public static Connection getCurrentConnection(DataSource dataSource, boolean useCurrentConnection)
	  {
	    try
	    {
	      if (!useCurrentConnection) {
	        return dataSource.getConnection();
	      }
	      Connection conn = (Connection)tl.get();
	      if (conn == null)
	      {
	        conn = dataSource.getConnection();
	        
	        tl.set(conn);
	      }
	      return (Connection)tl.get();
	    }
	    catch (Exception e)
	    {
	      throw new RuntimeException(e);
	    }
	  }
	  
	  public static void releaseConnection(Connection currentConnection)
	  {
	    if (currentConnection != null) {
	      try
	      {
	        currentConnection.close();
	        
	        tl.remove();
	      }
	      catch (Exception e)
	      {
	        throw new RuntimeException(e);
	      }
	    }
	  }

}
