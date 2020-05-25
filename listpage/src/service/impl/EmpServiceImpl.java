package service.impl;

import java.util.List;

import dao.face.EmpDao;
import dao.impl.EmpDaoImpl;
import dto.Emp;
import service.face.EmpService;

public class EmpServiceImpl implements EmpService {

	private EmpDao empDao = new EmpDaoImpl();

	@Override
	public List<Emp> list() {

		// EMP 테이블, DB 조회 결과 얻어오기 - Dao 이용
		List<Emp> empList = empDao.selectAll();

		// 결과 반환
		return empList;
	}

	@Override
	public Emp detail() {
		// TODO Auto-generated method stub
		return null;
	}

}
