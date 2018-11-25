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
	queryByUsername: 'select * from users where username=?;',
	queryAll: 'select * from users;'
};

const posts = {
	insert:'insert into users(id, title, content, status, users, date) values(?,?,?,?,?,?);',
	update:'update users set title=?, content=?, status=?, users=?, date=? where id=?;',
	delete: 'delete from users where id=?;',
	queryById: 'select * from users where id=?;',
	queryByStatus: 'select * from users where status=?;',
	queryByTitle: 'select * from users where title=?;',
	queryAll: 'select * from users;'
}

const comments = {
	insert:'insert into users(id, content, postId, fromUid, toUid, date) values(?,?,?,?,?,?);',
	update:'update users set content=?, postId=?, fromUid=?, toUid=?, date=? where id=?;',
	delete: 'delete from users where id=?;',
	queryById: 'select * from users where id=?;',
	queryByPostId: 'select * from users where postId=?;',
	queryAll: 'select * from users;'
}

module.exports = {
	users: users,
	posts: posts,
	comments: comments
};
