package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.gamerecord;


public class implRecord implements recordDao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<gamerecord> l=new implRecord().select1();
		for(gamerecord g:l) {
			System.out.println(g.show());
		}
	}

	@Override
	public void add(gamerecord r) {
		Connection conn=DbConnection.getDB();
		String SQL="insert into record(username,puzzle,time) values (?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,r.getUsername());
			ps.setString(2,r.getPuzzle());
			ps.setLong(3, r.getTime());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<gamerecord> select1() {
		Connection conn=DbConnection.getDB();
		String SQL="select username,time from record where puzzle=0 order by time asc";
		List<gamerecord> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				gamerecord g=new gamerecord();
				g.setUsername(rs.getString("username"));
				g.setPuzzle("0");
				g.setTime(rs.getLong("time"));
				l.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<gamerecord> select2() {
		Connection conn=DbConnection.getDB();
		String SQL="select username,time from record where puzzle=1 order by time asc";
		List<gamerecord> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				gamerecord g=new gamerecord();
				g.setUsername(rs.getString("username"));
				g.setPuzzle("1");
				g.setTime(rs.getLong("time"));
				l.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<gamerecord> select3() {
		Connection conn=DbConnection.getDB();
		String SQL="select username,time from record where puzzle=2 order by time asc";
		List<gamerecord> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				gamerecord g=new gamerecord();
				g.setUsername(rs.getString("username"));
				g.setPuzzle("2");
				g.setTime(rs.getLong("time"));
				l.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<gamerecord> select4() {
		Connection conn=DbConnection.getDB();
		String SQL="select username,time from record where puzzle=3 order by time asc";
		List<gamerecord> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				gamerecord g=new gamerecord();
				g.setUsername(rs.getString("username"));
				g.setPuzzle("3");
				g.setTime(rs.getLong("time"));
				l.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

	@Override
	public List<gamerecord> selectALL() {
		Connection conn=DbConnection.getDB();
		String SQL="select id,username,puzzle,time from record order by puzzle asc";
		List<gamerecord> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				gamerecord g=new gamerecord();
				g.setId(rs.getInt("id"));
				g.setUsername(rs.getString("username"));
				g.setPuzzle(rs.getString("puzzle"));
				g.setTime(rs.getLong("time"));
				l.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return l;
	}

}
