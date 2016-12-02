import java.sql.* ;
public class Mysqljava{
    public static void main(String[] arg){
    	String user="yahaa";
    	String pass="123456";
        try{
        	Class.forName("com.mysql.jdbc.Driver") ;
            System.out.println("³É¹¦¼ÓÔØMySQLÇý¶¯³ÌÐò");
            String u ="jdbc:mysql://115.29.146.79:3306/study";
            Connection conn = DriverManager.getConnection(u,"yahaa","Asd147258") ;
            Statement sta=conn.createStatement();
            String sql="select name from charRoomUser where name=\""+user+"\" and "+"pass=\""+pass+"\"";
            ResultSet result=sta.executeQuery(sql);
            while(result.next()){
            	System.out.println(result.getString(1));
            }
            conn.close();
        }catch(Exception e){
            System.out.println("failure!!!") ;
        }
       
    }
}


