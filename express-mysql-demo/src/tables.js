/**
 * @author Zeyu Chen
 * 
 * MySQL tables
 */
const users = {
	insert:'insert into users(id, username, password, class, email) values(?,?,?,?,?);',
	update:'update users set username=?, password=?, class=?, email=? where id=?;',
	delete: 'delete from users where id=?;',
	queryById: 'select * from users where id=?;',
	queryAll: 'select * from users;'
};
 
module.exports = users;
