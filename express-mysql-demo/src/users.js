/**
 * @author Zeyu Chen
 */

const mysql = require('mysql');
const db = require('../conf/db');
const users = require('./tables');

let pool = mysql.createPool(db.mysql);

const jsonWrite = (res, ret) => {
	if(typeof ret === 'undefined') {
		res.json({
			code:'504',
			msg: 'Server Internal Error'
		});
	} else {
		res.json(ret);
	}
};

const add = (req, res, next) => {
    pool.getConnection(function(err, connection) {
        // 获取前台页面传过来的参数
        let param = req.query || req.params;

        let queryParam = [param.id, 
                          param.username, 
                          param.password, 
                          param.class, 
                          param.email];
        
        console.log(queryParam);
        connection.query(users.insert, queryParam, function(err, result) {
            if(result) {
                result = {
                    code: 200,
                    msg:'Success'
                };    
            }

            jsonWrite(res, result);

            connection.release();
        });
    });
};

module.exports = {add};