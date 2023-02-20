package Dao;

import java.util.List;

import Model.gamerecord;

public interface recordDao {
	//新增
	void add(gamerecord r);
	//查詢
	List<gamerecord> select1();
	List<gamerecord> select2();
	List<gamerecord> select3();
	List<gamerecord> select4();
	List<gamerecord> selectALL();
	//更新
	
	//刪除
}
