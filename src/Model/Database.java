package Model;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> userArrayList;

    public Database() {
        userArrayList = new ArrayList<>();
        
    }

    // adds user to our collection
    public void addUser(User user) {
        userArrayList.add(user);
    }

    // saves user to database file
    public void saveUser(File file) {
        try {
            // user model
            User user;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while( i < userArrayList.size()) {
                user = userArrayList.get(i);
                save_data = user.getFirstname() + ", " + user.getLastname()+ ", " + user.getID()+ ", " + user.getDepartment();
                i++;
                try{  
            	    Class.forName("com.mysql.cj.jdbc.Driver");  
            	    Connection con=DriverManager.getConnection(  
            	    "jdbc:mysql://localhost:3306/MVC_Project","gagan","password");  
            	    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            	       ResultSet.CONCUR_READ_ONLY);  
            	    stmt.executeUpdate("insert into Employee values(\""+user.getFirstname()+"\",\""+user.getLastname()+"\",\""+user.getID()+"\",\""+user.getDepartment()+"\");");
//            	    stmt.executeUpdate("insert into Employee values(\"Vani\",\"TP\",\"EMP_3\",\"EC\");");
            	    con.close();  
            	    }catch(Exception e){ System.out.println(e);}
            }
            bufferedWriter.write(save_data);
            bufferedWriter.newLine();
            // prevents memory leak
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }

    // reads user from database file
    public Object[] loadUsers(File file) {
    	String first_name,last_name,emp_id,dept_name;
    	try{  
    	    Class.forName("com.mysql.cj.jdbc.Driver");  
    	    Connection con=DriverManager.getConnection(  
    	    "jdbc:mysql://localhost:3306/MVC_Project","gagan","password");  
    	    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	       ResultSet.CONCUR_READ_ONLY);  
    	    ResultSet rs=stmt.executeQuery("select * from Employee");
    	    while(rs.next()) {
    	    	first_name = rs.getString(1);
    	    	last_name  = rs.getString(2);
    	    	emp_id  =  rs.getString(3);
    	    	dept_name = rs.getString(4);
    	    	System.out.println(first_name+last_name+emp_id+dept_name);
    	    }
    	    
    	    con.close();  
    	    }catch(Exception e){ System.out.println(e);}
    	
    	
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // each lines to array
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    	
    }


}
