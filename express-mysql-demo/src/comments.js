/**
 * @author Zeyu Chen
 */

const mysql = require('mysql');
const db = require('../conf/db');
const tables = require('./tables');
const pool = mysql.createPool(db.mysql);
const utils = require('./utils');

/**
 * Add a comment
 */
const add = (req, res, next) => {
    pool.getConnection(function(err, connection) {

        const param = [req.body.id,
                       req.body.content,
                       req.body.postId,
                       req.body.fromUid, 
                       req.body.toUid];
        
        connection.query(tables.comments.insert, param, function(err, result) {
            if (result) {
                result = utils.msg.SUCCESS_MSG;    
            }

            utils.jsonHelper(res, result);
            connection.release();
        });
    });
};

/**
 * Update a comment
 * 
 * The request must include all elements. So the best way for front end is query
 * first and then update it.
 */
const update = (req, res, next) => {
    if (req.body.id === undefined) {
        utils.jsonHelper(res, utils.msg.INVALID_REQ); // change it to another error code
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

            utils.jsonHelper(res, result);
            connection.release();
        });
    });
};

/**
 * Delete a comment
 */
const del = (req, res, next) => {
    pool.getConnection(function(err, connection) {
        const id = req.body.id;
        connection.query(tables.users.delete, id, function(err, result) {
            if (result) {
                result = SUCCESS_MSG;
            }

            utils.jsonHelper(res, result);
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
            utils.jsonHelper(res, result);
            connection.release();
        });
    });
};

/**
 * Query by username
 */
const queryByUsername = (req, res, next) => {
    pool.getConnection(function(err, connection) {
        const username = req.body.username;
        connection.query(tables.users.queryUsername, username, function(err, result) {
            utils.jsonHelper(res, result);
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
            utils.jsonHelper(res, result);
            connection.release();
        });
    });
};

module.exports = { 
    add: add, 
    update: update,
    delete: del,
    queryById: queryById,
    queryByUsername: queryByUsername,
    queryAll: queryAll
};