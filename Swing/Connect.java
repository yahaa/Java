
import java.sql.Connection;//java包  
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connect{  
        private String dbDriver="com.mysql.jdbc.Driver";   
        private String dbUrl="jdbc:mysql://localhost:3306/study";//根据实际情况变化  
        private String dbUser="root";  
        private String dbPass="  ";  
        public Connection getConn(){  
            Connection conn=null;  
            try{  
                Class.forName(dbDriver);  
            }  
            catch (ClassNotFoundException e){  
                e.printStackTrace(); 
                System.out.println("xxxxxxxxxxxx");
            }  
            try{  
                conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);//注意是三个参数  
            }  
            catch (SQLException e){  
                e.printStackTrace();  
            }
            return conn;  
        }
        
        public static void main(String[]args){
        	Connect nn=new Connect();
        	Connection s=nn.getConn();
        	//System.out.println(s);
        }
    }  