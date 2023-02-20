package Dao;

import java.util.List;

import Model.member;

public interface memberDao {
	
	//新增
	void add(member m);
	
	//查詢
	String queryAll1();
	List<member> queryAll2();
	member queryMember(String username,String password);
	member queryMember2(String username);
	member queryId(int id);
	boolean queryUser(String username);

	//更新
	void update(member m);
	//刪除
	void delete(int id);
	
}
