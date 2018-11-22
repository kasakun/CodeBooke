const express = require('express');
const router = express.Router();
const userTable = require('../src/users');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

/* Add user. */
router.post('/addUser', function(req, res, next) {
	userTable.add(req, res, next);
});

/* Update user. */
router.post('/updateUser', function(req, res, next) {
	userTable.update(req, res, next);
});

/* Delete user. */
router.post('/delUser', function(req, res, next) {
	userTable.delete(req, res, next);
});

/* Query by Id. */
router.post('/queryById', function(req, res, next) {
	userTable.queryById(req, res, next);
});

/* Query All. */
router.post('/queryAll', function(req, res, next) {
	userTable.queryAll(req, res, next);
});

module.exports = router;
