const express = require('express');
const router = express.Router();
const userTable = require('../src/users');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

/* Add user. */
router.get('/addUser', function(req, res, next) {
	userTable.add(req, res, next);
});
module.exports = router;
