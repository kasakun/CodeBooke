/**
 * @author Zeyu Chen
 */
const express = require('express');
const router = express.Router();
const commentsTable = require('../src/comments');

/* Add user. */
router.post('/addComment', function(req, res, next) {
	commentsTable.add(req, res, next);
});

module.exports = router;