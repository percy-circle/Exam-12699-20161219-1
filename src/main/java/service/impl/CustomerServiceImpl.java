package service.impl;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
     CustomerDao dao=new CustomerDaoImpl();
	public int findCustomerByFirst_name(String name) {
		
		return dao.findCustomerByFirst_name(name);
	}

}
