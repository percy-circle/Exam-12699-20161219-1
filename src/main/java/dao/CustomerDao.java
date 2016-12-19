package dao;

public interface CustomerDao {
	//通过findCustomerByFirst_name获取用户并返回id
    public int findCustomerByFirst_name(String name);
}
