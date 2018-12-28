package edu.aspire.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import edu.aspire.model.Employee;

@Repository("empdao")
public class EmployeeDaoImpl implements EmployeeDao {
	//Default value is true. In case of 'true' the attribute is injected forcefully to bean in Spring Configuration file 
	//In case of false, spring will leave the reference null if no qualifying bean is found.
	@Autowired(required=true)
	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl() {}

	@Override
	public void save(final Employee emp) {
		//Anonymous approach
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String query = "INSERT INTO employee(eno, ename, desig, sal) VALUES (?,?,?,?)";
				PreparedStatement pstmt =con.prepareStatement(query);
				pstmt.setInt(1, emp.getEno());
				pstmt.setString(2, emp.getEname());
				pstmt.setString(3, emp.getDesig());
				pstmt.setDouble(4, emp.getSal());
				return pstmt;
			}
		});
		
		//Short cut approach
		/*String query = "INSERT INTO employee(eno, ename, desig, sal) VALUES (?,?,?,?)";
		Object[] data = {emp.getEno(), emp.getEname(), emp.getDesig(), emp.getSal()};
		jdbcTemplate.update(query, data);*/
	}
	@Override
	public Employee get(int eno) {
		String query = "SELECT * FROM EMPLOYEE WHERE ENO=?";
		Employee emp = jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), eno); 
		return emp;
	}
	
	@Override
	public void delete(int eno) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(Employee e) {
		// TODO Auto-generated method stub
	}
}

