package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pack.DBUtility;
import com.pack.model.Login;
import com.pack.model.Product;
import com.pack.model.Profile;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Profile verifyAdmin(Login lo) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null,ps1=null;
		try
		{
			/*con=DBUtility.getConnection();*/
			con=DBUtility.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select username,password,status from login");
			ResultSet rs=ps.executeQuery();
			rs.next();
			if(lo.getUsername().equals(rs.getString("username")) && lo.getPassword().equals(rs.getString("password")) && rs.getString("status").equals("Valid"))
			{
				ps1=con.prepareStatement("select id,name,designation,office from profile where id like ?");
				ps1.setString(1, lo.getUsername());
				ResultSet rs1=ps1.executeQuery();
				rs1.next();
				Profile p=new Profile();
				p.setId(rs1.getString("ID"));
				p.setName(rs1.getString("NAME"));
				p.setDesignation(rs1.getString("DESIGNATION"));
				p.setOffice(rs1.getString("OFFICE"));
				return p; 
			}
			/*else
			{
				if(lo.getUsername()==rs.getString("username"))
				{
					return 2;
				}
				else if(lo.getPassword()==rs.getString("password"))
				{
					return 3;
				}
				else
					return 0;
					
			}*/
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return null;
	}

	@Override
	public List<Product> listAllProducts() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		List<Product> l=null;
		try{
			//con=DBUtility.getConnection();
			con=DBUtility.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select pid,pname,brand,category,rating,price from product");
			ResultSet rs=ps.executeQuery();
			l=new ArrayList<>();
			while(rs.next()){
				Product p=new Product();
				p.setPid(rs.getString("PID"));
				p.setPname(rs.getString("PNAME"));
				p.setBrand(rs.getString("BRAND"));
				p.setCategory(rs.getString("CATEGORY"));
				p.setRating(rs.getFloat("RATING"));
				p.setPrice(rs.getFloat("PRICE"));
				l.add(p);
			}
			con.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
		return l;
	}

	@Override
	public int removeProductById(String pid) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		int i=0;
		try{
			//con=DBUtility.getConnection();
			con=DBUtility.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("delete from product where pid=?");
			ps.setString(1, pid);
			i=ps.executeUpdate();
			con.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
		return i;
	}

	@Override
	public Product fetchProductById(String pid) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		Product p=null;
		try{
			//con=DBUtility.getConnection();
			con=DBUtility.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select pid,pname,brand,category,rating,price,description from product where pid=?");
			ps.setString(1, pid);
			ResultSet rs=ps.executeQuery();
			rs.next();
			p=new Product();
			p.setPid(rs.getString("PID"));
			p.setPname(rs.getString("PNAME"));
			p.setBrand(rs.getString("BRAND"));
			p.setCategory(rs.getString("CATEGORY"));
			p.setRating(rs.getFloat("RATING"));
			p.setPrice(rs.getFloat("PRICE"));
			p.setDescription(rs.getString("DESCRIPTION"));
			con.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
		return p;
	}

	@Override
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		int i=0;
		try{
			//con=DBUtility.getConnection();
			con=DBUtility.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("insert into product values(seq1.nextval,?,?,?,?,?,?)");
			//ps.setString(1, p.getPid());
			ps.setString(1, p.getPname());
			ps.setString(2, p.getBrand());
			ps.setString(3, p.getCategory());
			ps.setFloat(4, (float) 4.0);
			ps.setFloat(5, p.getPrice());
			ps.setString(6, p.getDescription());
			i=ps.executeUpdate();
			con.commit();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
		return i;
	}

	@Override
	public int updateStatus(String username) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		int i=0;
		try
		{
			/*con=DBUtility.getConnection();*/
			con=DBUtility.getDataSource().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("update login set status='Invalid' where username like ?");
			ps.setString(1, username);
			i=ps.executeUpdate();
			con.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return i;
	}

}
