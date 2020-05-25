package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.EmpDao;
import dbutil.DBConn;
import dto.Emp;

public class EmpDaoImpl implements EmpDao {

	// OJDBC 관련 객체

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Emp> selectAll() {

		// DB 연결
		conn = DBConn.getConnection();

		// SQL 작성
		String sql = "";
		sql += "SELECT * FROM EMP ORDER BY EMPNO";

		// 쿼리 결과 저장할 List
		List<Emp> list = new ArrayList<>();

		// SQL 수행
		try {
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql);

			// resultSet - SQL 수행 및 결과 반환
			rs = ps.executeQuery();

			while (rs.next()) {
				Emp emp = new Emp();

				// ResultSet 에서 데이터를 꺼내 Emp 객체에 삽입
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));

				// 결과 처리
				list.add(emp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 자원 해제
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 최종 결과 반환
		return list;
	}

}
