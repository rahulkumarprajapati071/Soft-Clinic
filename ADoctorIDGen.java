package softclinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ADoctorIDGen {
	
	int getValue;
	Connection connection = null;
	public void generatingInvo(String passQuery)
	{
		connection = AdminLoginDBConnection.connectAdminLoginDB();
		try {
			PreparedStatement statement = connection.prepareStatement(passQuery);
			ResultSet rSet = statement.executeQuery();
			if(rSet.next())
			{
				getValue = Integer.parseInt(rSet.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void insertSerialno()
	{
		generatingInvo("select count(sid)+1 from autoID");
		String inseString = "insert into autoID values(?)";
		
		String invoicNumString = "ID"+new SimpleDateFormat("ddyyyy").format(new Date())+getValue;
//		String invoicNumString = "RH"+new SimpleDateFormat("MMyyyy").format(new Date())+getValue;
//		String invoicNumString = "INO"+new SimpleDateFormat("ddMMyyyy").format(new Date())+getValue;
//		String invoicNumString = "BGI"+new SimpleDateFormat("ddMM").format(new Date())+getValue;
		System.out.println(invoicNumString);
		
		try {
			PreparedStatement statement = connection.prepareStatement(inseString);
			statement.setString(1,invoicNumString);
			statement.execute();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ADoctorIDGen().insertSerialno();
	}
}
