package com.pack.service;

import java.util.List;

import com.pack.dao.AdminDaoImpl;
import com.pack.model.Login;
import com.pack.model.Product;
import com.pack.model.Profile;

public class AdminServiceImpl implements AdminService {

	@Override
	public Profile verifyAdmin(Login lo) {
		// TODO Auto-generated method stub
		AdminDaoImpl a1=new AdminDaoImpl();
		Profile p=a1.verifyAdmin(lo);
		return p;
	}

	@Override
	public List<Product> listAllProducts() {
		// TODO Auto-generated method stub
		AdminDaoImpl a=new AdminDaoImpl();
		List<Product> l=a.listAllProducts();
		return l;
	}

	@Override
	public int removeProductById(String pid) {
		// TODO Auto-generated method stub
		AdminDaoImpl a=new AdminDaoImpl();
		int i=a.removeProductById(pid);
		return i;
	}

	@Override
	public Product fetchProductById(String pid) {
		// TODO Auto-generated method stub
		AdminDaoImpl a=new AdminDaoImpl();
		Product p=a.fetchProductById(pid);
		return p;
	}

	@Override
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		AdminDaoImpl s=new AdminDaoImpl();
		int i=s.addProduct(p);
		return i;
	}

	@Override
	public int updateStatus(String username) {
		// TODO Auto-generated method stub
		AdminDaoImpl s=new AdminDaoImpl();
		int i=s.updateStatus(username);
		return i;
	}

}
