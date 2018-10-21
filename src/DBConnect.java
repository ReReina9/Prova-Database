import java.sql.*;

public class DBConnect {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb?useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","Comingsoon9.9");
			st = con.createStatement();
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}		
	}
	
	public void getData() {
		try {
			String query = "select * from mydb.Studente";
			rs = st.executeQuery(query);
			rs.next();
			System.out.println(rs.getString("nome"));
			while(rs.next()) {
				String id = rs.getString("ID");
				String nome = rs.getString("nome");
				String cognome = rs.getString("cognome");
				System.out.println("nome: " + nome + " cognome: " + cognome + " ID: " + id);
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	
}
