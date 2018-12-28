package edu.aspire.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.aspire.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
		Employee e = new Employee();
		e.setEno(rs.getInt(1));
		e.setEname(rs.getString(2));
		e.setDesig(rs.getString(3));
		e.setSal(rs.getDouble(4));
		return e;
	}
}
