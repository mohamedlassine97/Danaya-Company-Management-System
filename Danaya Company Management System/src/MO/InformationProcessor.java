package MO;

import java.sql.ResultSet;

import DA.Dataccess;

public class InformationProcessor extends Personel {
	
	
	public void Record(InformationProcessor c) throws Exception{
		
		Dataccess da = Dataccess.getDataccess();
		
		String query = " insert into informationProcessor(tc,name,surname,gender,post,department,cell,email,password,startDate,salary)"
				       + "values('"+c.getTc()+"','"+c.getName()+"','"+c.getSurname()+"','"+c.getGender()+"','"+c.getPost()+"',"
				       		+ "'"+c.getDepartement()+"','"+c.getCell()+"','"+c.getEmail()+"','"+c.getPassword()+"',"
				       + "GETDATE(),'"+c.getSalary()+"')";
		da.ExecuteUpdate(query);
	};
	
	
	
	
	public int  Update(InformationProcessor c) throws Exception{
		
		
		Dataccess da = Dataccess.getDataccess();
		String query = " update  informationProcessor set name = '"+c.getName()+"',surname = '"+c.getSurname()+"',gender='"
		+c.getGender()+"',post='"+c.getPost()+"',department='"+c.getDepartement()+"',"
				+" cell='"+c.getCell()+"',email='"+c.getEmail()+"',password='"+c.getPassword()+"'"
						+ ",startDate=GETDATE(),salary='"+c.getSalary()+"' where tc = " +c.getTc();
				return da.ExecuteUpdate(query);
		
	};	
	public int  Delete(int id) throws  Exception{
		
		Dataccess da = Dataccess.getDataccess();
		String query = "delete from informationProcessor where  tc = " + id;
		return  da.ExecuteUpdate(query);
		
	};
	public ResultSet ShowProfile(int id) throws Exception{
	
		Dataccess da = Dataccess.getDataccess();
		String sql="select *from informationProcessor where id =" + id;
		return da.ExecuteQuery(sql);
		
	};
	public ResultSet ShowProfiles() throws Exception{
		
		Dataccess da = Dataccess.getDataccess();
		String sql="select *from informationProcessor";
		return da.ExecuteQuery(sql);
	};
	public ResultSet SearchByName(String name) throws Exception{
		
		Dataccess da = Dataccess.getDataccess();
		String search = "select *from informationProcessor where name = " + name;
		return da.ExecuteQuery(search);
	};
	public Boolean Login(InformationProcessor c) throws Exception{
		
		Dataccess da = Dataccess.getDataccess();
		String query = "select id from informationProcessor where email = '"+c.getEmail()+"' and password= '"+c.getPassword()+"'";
		return da.ExecuteQuery(query).next();
	}
}
