package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {
		
	}

	//新增
	@Override
	public void add(member m) {
		Connection conn=DbConnection.getDB();
		String sQL="insert into member(username,password) "
				+ "values(?,?)";	
		try {
			PreparedStatement ps=conn.prepareStatement(sQL);
			ps.setString(1, m.getUsername());
			ps.setString(2, m.getPassword());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//查詢
	@Override
	public String queryAll1() {
		Connection conn=DbConnection.getDB();
		String SQL="select * from member";
		String show="";
		try {
			PreparedStatement ps =conn.prepareCall(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				show=show+"id:"+rs.getInt("id")+
						"\t帳號:"+rs.getString("username")+
						"\t密碼:"+rs.getString("password")+"\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return show;
	}

	@Override
	public List<member> queryAll2() {
		Connection conn=DbConnection.getDB();
		String SQL="select * from member";
		List<member> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				member m =new member();
				m.setId(rs.getInt("id"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				l.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public member queryId(int id) {
		/*
		 * 1.連線->Connection
		 * 2.SQL-->where id=?
		 * 3.ResultSet
		 * 4.if->rs.next()
		 * 5.true-->rs-->new member()
		 * 6.false-->null
		 */
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where id=?";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				m=new member();
				m.setId(rs.getInt("id"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	@Override
	public member queryMember2(String username) {
		/*
		 * 1.先連線-->Connection
		 * 2.SQL-->where username=? 
		 * 3.if(rs.next())
		 * 4.true--->new member()-->rs填入
		 * 5.false-->null
		 */
		
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=? ";
		member m=null;
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				m=new member();
				m.setId(rs.getInt("id"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return m;
	}

	@Override
	public boolean queryUser(String username) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=?";
		boolean m=false;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) m=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public member queryMember(String username, String password) {
		
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=? and password=?";
		member m=null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				m=new member();
				m.setId(rs.getInt("id"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return m;
	}
	
	//更新
	@Override
	public void update(member m) {
		Connection conn=DbConnection.getDB();
		String SQL="update member set username=?, password=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getUsername());
			ps.setString(2, m.getPassword());
			ps.setInt(3, m.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//刪除
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDB();
		String SQL="delete from member where id=?";
		try {
			PreparedStatement ps =conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}