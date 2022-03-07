user = SELECT l.role FROM empdb_login_master l WHERE l.user_id=? AND l.password=?;
Employee.getEmployeeList = SELECT e.emp_id id, e.first_name firstName, e.last_name lastName, e.dob dob, e.email email, e.department_id departmentId, d.department_nm department FROM empdb_employees e LEFT JOIN empdb_department d ON e.department_id = d.department_id;
Department.getDepartmentList=SELECT d.department_id id, d.department_nm department FROM empdb_department d;
Employee.addNewEmployee=INSERT INTO empdb_employees(first_name,last_name,dob,email,department_id)VALUES (?,?,?,?,?);
Employee.getEmployeeDetail=SELECT e.emp_id id, e.first_name firstName, e.last_name lastName, e.dob dob, e.email email, e.department_id departmentId, d.department_nm department FROM empdb_employees e LEFT JOIN empdb_department d ON e.department_id = d.department_id WHERE e.emp_id = ?;
Employee.editDetail=UPDATE empdb_employees SET first_name = ?,last_name = ?,dob = ?,email = ?,department_id = ? WHERE emp_id = ?;
Employee.deleteEmployee=DELETE FROM empdb_employees WHERE emp_id = ?;
Employee.countEmployee=SELECT COUNT(e.emp_id) AS empCount FROM empdb_employees e;