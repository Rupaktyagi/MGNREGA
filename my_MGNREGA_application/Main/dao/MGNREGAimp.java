package com.mgnrega.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.been.BDO;
import com.mgnrega.been.Employee;
import com.mgnrega.been.GPM;
import com.mgnrega.been.ListofEmployeeUnderProject;
import com.mgnrega.been.Project;
import com.mgnrega.conn.DBconnection;
import com.mgnrega.exception.BDOException;
import com.mgnrega.exception.EmployeeException;
import com.mgnrega.exception.GPMException;
import com.mgnrega.exception.ProjectException;


public class MGNREGAimp implements MGNREGA{

	@Override
	public BDO loginbdo(String usename, String password) throws BDOException {
		
		BDO bdo=null;
		
		try(Connection conn=DBconnection.provideConnection())
		{
		
			PreparedStatement ps=conn.prepareStatement("select*from bdo where username=? And password =?");
			ps.setString(1, usename);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				int id=rs.getInt("id");
				String n=rs.getString("username");
				String p=rs.getString("password");
				
				bdo=new BDO(id, n, password);
			}else {
				throw new BDOException("Invalid Username or password");
			}
			
			
		} catch (SQLException e) {
			throw new BDOException(e.getMessage());
		}
		
		return bdo;
	}

	@Override
	public GPM loginGPM(String usename, String password) throws GPMException {
		
		GPM gpm=null;
		
		try(Connection conn=DBconnection.provideConnection())
		{
		
			PreparedStatement ps=conn.prepareStatement("select * from gpm where name=? And password =?");
			ps.setString(1, usename);
			ps.setString(2, password);
			

			ResultSet	rs=ps.executeQuery();
			
			if(rs.next())
			{
				int id=rs.getInt("id");
				String n=rs.getString("name");
				String p=rs.getString("password");
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				
				gpm=new GPM(id, n, p, address, phone);
			}else {
				throw new GPMException("Invalid Username or password");
			}
			
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return gpm;
	}

	@Override
	public String createproject(Project project) {
		String massage="Not Inserted";
		try(Connection conn=DBconnection.provideConnection()){
		PreparedStatement ps=conn.prepareStatement("insert into project(name,no_of_employee,total_wages) value(?,?,?)");
		
		
		
		ps.setString(1, project.getName());
		ps.setInt(2, project.getNoOfEmployee());
		ps.setString(3, project.getTotalWages());
		
		int x=ps.executeUpdate();
		if(x>0)
		{
			massage="Project added successfully......";
		}
		
		
		}catch (SQLException e) {
			massage=e.getMessage();
		}
		return massage;
	}

	@Override
	public String createnewGPM(GPM gpm) {
		String massage="Not created..";
		
		try (Connection conn=DBconnection.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into gpm(name,password,address,phone) value(?,?,?,?)");
			ps.setString(1,gpm.getName() );
			ps.setString(2, gpm.getPassword());
			ps.setString(3, gpm.getAddress());
			ps.setString(4, gpm.getPhone());
			int x=ps.executeUpdate();
			if(x>0)
			{
				massage="Gram Panchayet member created..";
			}
			
			
		} catch (SQLException e) {
			massage=e.getMessage();
		}
		
		return massage;
	}

	@Override
	public String allocateprojecttoGPM(int pid, int gpmid) throws ProjectException, GPMException {
		String massage="Not Allocated..";
		
		try (Connection conn=DBconnection.provideConnection()){
			PreparedStatement ps1=conn.prepareStatement("select * from project where id=?");
			
			ps1.setInt(1, pid);
			ResultSet rs1=	ps1.executeQuery();
			
			if(rs1.next())
			{
				PreparedStatement ps2=conn.prepareStatement("select * from GPM where id=?");
				ps2.setInt(1, gpmid);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next())
				{
					PreparedStatement ps3=conn.prepareStatement("insert into project_gpm value(?,?);");
					ps3.setInt(1,pid);
					ps3.setInt(2, gpmid);
					
					int x=ps3.executeUpdate();
					if(x>0)
					{
						massage="Project Allocated to the Gram Panchayet member ...";
						
					}else {
						throw new ProjectException("Techanical error...");
					}
					
				}else {
					throw new GPMException("Invalid Gram Panchayet member id...");
				}
			}else {
				throw new ProjectException("Invalid Project id..");
			}
			
		} catch (SQLException e) {
			massage=e.getMessage();
		}
		
		
		return massage;
	}

	@Override
	public List<Project> listofProject() throws ProjectException {

		List<Project> projectlist=new ArrayList<>();
		
		try(Connection conn=DBconnection.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from project");
			
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{  
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int no=rs.getInt("no_of_employee");
				String wages=rs.getString("total_wages");
				
				Project project=new Project(id, name, no, wages);
				projectlist.add(project);
			}
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		if(projectlist.size()==0)
		{
			throw new ProjectException("No project Found...");
		}
		
		return projectlist;
	}

	@Override
	public List<GPM> listofGPM() throws GPMException {
        List<GPM> gpmlist=new ArrayList<>();
		
		try(Connection conn=DBconnection.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from gpm");
			
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				
				String pass=rs.getString("password");
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				
				GPM gpm=new GPM(id, name, pass, address, phone);
				gpmlist.add(gpm);
			}
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		if(gpmlist.size()==0)
		{
			throw new GPMException("No Gram Panchayet member Found...");
		}

		return gpmlist;
	}

	@Override
	public String createemployee(Employee emp) {
		String massage="Not created..";
		
		try (Connection conn=DBconnection.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into employee(name,address,phone,no_of_days,amount) value(?,?,?,?,?)");
			ps.setString(1,emp.getName() );
			ps.setString(2, emp.getAddress());
			ps.setString(3, emp.getPhone());
			ps.setInt(4, emp.getNo_of_days());
			ps.setInt(5, emp.getWages());
			int x=ps.executeUpdate();
			if(x>0)
			{
				massage=" New Employee created..";
			}
			
			
		} catch (SQLException e) {
			massage=e.getMessage();
		}
		
		return massage;
	}

	@Override
	public List<ListofEmployeeUnderProject> employeeUnderProject() throws ProjectException {
		List<ListofEmployeeUnderProject> listemployeeunderproject = new ArrayList<>();
		
		
		
		try (Connection conn = DBconnection.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select e.name,p.name,e.amount from employee e inner join project p inner join project_employee pe on e.empid=pe.empid and p.id=pe.pid");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				String empname=rs.getString("empname");
				String projectname=rs.getString("projectname");
				int amount=rs.getInt("amount");
				
				ListofEmployeeUnderProject lep = new ListofEmployeeUnderProject(empname, empname, amount);
				
				listemployeeunderproject.add(lep);
	
			}	
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		if(listemployeeunderproject.isEmpty()) {
			throw new ProjectException("No Employee Allocated to  the Project");
		}
		
		return listemployeeunderproject;
		
	}

	@Override
	public List<Employee> listofEmployee() throws  EmployeeException {
		List<Employee> emplist=new ArrayList<>();
		
		try(Connection conn=DBconnection.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from employee");
			
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt("empid");
				String name=rs.getString("name");
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				int noofady=rs.getInt("no_of_days");
				int amount=rs.getInt("amount");
				
				Employee emp=new Employee(id, name, address, phone, noofady, amount);
				emplist.add(emp);
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		if(emplist.size()==0)
		{
			throw new EmployeeException("No Employee Found...");
		}

		return emplist;
	}

	@Override
	public String assignemptoproject(int pid, int empid) throws ProjectException, EmployeeException {
			String massage="Not Allocated..";
		
		try (Connection conn=DBconnection.provideConnection()){
			PreparedStatement ps1=conn.prepareStatement("select * from project where id=?");
			
			ps1.setInt(1, pid);
			ResultSet rs1=	ps1.executeQuery();
			
			if(rs1.next())
			{
				PreparedStatement ps2=conn.prepareStatement("select * from employee where empid=?");
				ps2.setInt(1, empid);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next())
				{
					PreparedStatement ps3=conn.prepareStatement("insert into project_employee value(?,?)");
					ps3.setInt(1,pid);
					ps3.setInt(2, empid);
					
					int x=ps3.executeUpdate();
					if(x>0)
					{
						massage="Asign Employee to the Project ...";
						
					}else {
						throw new ProjectException("Techanical error...");
					}
					
				}else {
					throw new EmployeeException("Invalid Employee id...");
				}
			}else {
				throw new ProjectException("Invalid Project id..");
			}
			
		} catch (SQLException e) {
			massage=e.getMessage();
		}
		
		
		return massage;
	}
	

}
