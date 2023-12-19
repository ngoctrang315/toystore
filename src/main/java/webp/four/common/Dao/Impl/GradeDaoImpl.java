package webp.four.common.Dao.Impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webp.four.common.Connection.DBConnection;
import webp.four.common.Dao.Interface.IGradeDao;
import webp.four.common.Model.Grade;
import webp.four.common.Model.Gunpla;
import webp.four.common.Model.User;

public class GradeDaoImpl extends DBConnection implements IGradeDao{
	@Override
	public Grade get(String id) {
		Grade grade = new Grade();
		String sql = "SELECT * FROM Grade where grade=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				grade.setGrade(rs.getString("grade"));
				grade.setGradeName(rs.getString("gradeName"));
			}
			conn.close();
			return grade;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(Grade grade) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Grade VALUES(?,?)";

		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, grade.getGrade());
			ps.setString(2,grade.getGradeName());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Grade grade) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Grade SET gradeName = ? where grade = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, grade.getGradeName());
			ps.setString(2, grade.getGrade());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Grade grade) {
		// TODO Auto-generated method stub
		String sql = "Delete from Grade where grade = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, grade.getGrade());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Grade> getAll() {
		// TODO Auto-generated method stub
		List<Grade> grades = new ArrayList<Grade>();
		String sql = "SELECT * FROM Grade";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Grade grade = new Grade();
				grade.setGrade(rs.getString("grade"));
				grade.setGradeName(rs.getString("gradeName"));
				grades.add(grade);
			}
			conn.close();
			return grades;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Grade> search(String keyword) {
		List<Grade> grades = new ArrayList<Grade>();
		String sql = "SELECT * FROM Grade where grade LIKE %?% or gradeName LIKE %?%";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, keyword);
			ps.setString(2, keyword);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Grade grade = new Grade();
				grade.setGrade(rs.getString("grade"));
				grade.setGradeName(rs.getString("gradeName"));
				grades.add(grade);
			}
			conn.close();
			return grades;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Grade> getAllGrade() {
	    List<Grade> list = new ArrayList<>();
	    String query = "select * from Grade";
	    try {
	        Connection conn = super.getConnection();
	        PreparedStatement ps = conn.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new Grade(
	                    rs.getString("grade"),
	                    rs.getString("gradeName")));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}	

	
}
