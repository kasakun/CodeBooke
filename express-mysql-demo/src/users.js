/**
 * @author Zeyu Chen
 */

const mysql = require('mysql');
const db = require('../conf/db');
const tables = require('./tables');
const pool = mysql.createPool(db.mysql);

const SUCCESS_MSG = { code: 200, msg:'Success' };

/**
 * This method is a json wrapper
 * 
 */
const jsonHelper = (res, ret) => {
	if(typeof ret === 'undefined') {
		res.json({
			code:'504',
			msg: 'Server Internal Error'
		});
	} else {
		res.json(ret);
	}
};

/**
 * Add a user
 */
const add = (req, res, next) => {
    pool.getConnection(function(err, connection) {

        const param = [req.body.id, 
                       req.body.username, 
                       req.body.password, 
                       req.body.class, 
                       req.body.email];
        
        connection.query(tables.users.insert, param, function(err, result) {
            if (result) {
                result = SUCCESS_MSG;    
            }

            jsonHelper(res, result);
            connection.release();
        });
    });
};

/**
 * Update a user
 * 
 * The request must include all elements. So the best way for front end is query
 * first and then update it.
 */
const update = (req, res, next) => {
    if (req.body.id === undefined) {
        jsonHelper(res, undefined); // change it to another error code
    }

    pool.getConnection(function(err, connection){
        const param = [req.body.username, 
                       req.body.password, 
                       req.body.class, 
                       req.body.email,
                       req.body.id];
        
        connection.query(tables.users.update, param, function(err, result) {
            if (result) {
                result = SUCCESS_MSG;    
            }

            jsonHelper(res, result);
            connection.release();
        });
    });
};

/**
 * Delete a user
 */
const del = (req, res, next) => {
    pool.getConnection(function(err, connection) {
        const id = req.body.id;
        connection.query(tables.users.delete, id, function(err, result) {
            if (result) {
                result = SUCCESS_MSG;
            }

            jsonHelper(res, result);
            connection.release();
        });
    });
};

/**
 * Query by Id
 */
const queryById = (req, res, next) => {
    pool.getConnection(function(err, connection) {
        const id = req.body.id;
        connection.query(tables.users.queryById, id, function(err, result) {
            jsonHelper(res, result);
            connection.release();
        });
    });
};

/**
 * Query all
 */
const queryAll = (req, res, next) => {
    pool.getConnection(function(err, connection) {
        connection.query(tables.users.queryAll, function(err, result) {
            jsonHelper(res, result);
            connection.release();
        });
    });
};

module.exports = { 
    add: add, 
    update: update,
    delete: del,
    queryById: queryById,
    queryAll: queryAll
};