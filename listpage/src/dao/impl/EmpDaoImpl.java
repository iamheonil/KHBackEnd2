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

	@Override
	public Emp selectByEmpno(Emp emp) {

		// DB 연결
		conn = DBConn.getConnection();

		// SQL 작성
		String sql = "";

		sql += "SELECT * FROM EMP WHERE empno = ?";

		// 쿼리 결과 저장할 List
		List<Emp> list = new ArrayList<>();

		Emp result = null;

		// SQL 수행
		try {
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql); // SQL 수행 객체 생성

			ps.setInt(1, emp.getEmpno()); // 사원 번호 적용

			// resultSet - SQL 수행 및 결과 반환
			rs = ps.executeQuery();

			while (rs.next()) {

				result = new Emp(); // 이렇게 만든 이유는 위의 SQL문에서 오류가 발생하면 익셉션 처리 되는데
				// 그런 경우 객체를 만들지 않고, 정상적인 흐름으로 흘러왔을 때 객체를 만들기 위해서

				// ResultSet 에서 데이터를 꺼내 Emp 객체에 삽입
				result.setEmpno(rs.getInt("empno"));
				result.setEname(rs.getString("ename"));
				result.setJob(rs.getString("job"));
				result.setMgr(rs.getInt("mgr"));
				result.setHiredate(rs.getDate("hiredate"));
				result.setSal(rs.getDouble("sal"));
				result.setComm(rs.getDouble("comm"));
				result.setDeptno(rs.getInt("deptno"));

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
		return result;
	}

	@Override
	public void insert(Emp emp) {
		// DB 연결
		conn = DBConn.getConnection();

		// SQL 작성
		String sql = "";

		sql += "INSERT INTO EMP (empno, ename, job, mgr, hiredate, sal, comm, deptno)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		// SQL 수행
		try {
			// SQL 수행 객체 생성
			ps = conn.prepareStatement(sql); // SQL 수행 객체 생성

			ps.setInt(1, emp.getEmpno()); // 사원 번호 적용
			ps.setString(2, emp.getEname()); // 사원 이름 적용
			ps.setString(3, emp.getJob()); // 사원 직무 적용
			ps.setInt(4, emp.getMgr()); // 사원 매니져번호 적용

			// PreparedStatement 의 setDate() 메소드는
			// java.sql.Date 를 입력 받는다.

			// java.util.Date 타입의 정보를 java.sql.Date 로 변경해야함.
			// -> java.sql.Date(long millis) 생성자를 이용한다.

			java.sql.Date d = new java.sql.Date(emp.getHiredate().getTime());
			ps.setDate(5, d); // 사원 입사일 적용

			ps.setDouble(6, emp.getSal()); // 사원 월급 적용
			ps.setDouble(7, emp.getComm()); // 사원 보너스 적용
			ps.setInt(8, emp.getDeptno()); // 사원 부서번호 적용

			// resultSet - SQL 수행 및 결과 반환
			ps.executeUpdate();

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

	}

}
