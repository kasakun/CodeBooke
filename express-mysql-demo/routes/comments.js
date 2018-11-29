/**
 * @author Zeyu Chen
 */
const express = require('express');
const router = express.Router();
const commentsTable = require('../src/comments');

/* Add comment. */
router.post('/addComment', function(req, res, next) {
	commentsTable.add(req, res, next);
});

/* Update comment */
router.post('/updateComment', function(req, res, next) {
    commentsTable.update(req, res, next);
});

/* Delete comment */
router.post('/deleteComment', function(req, res, next) {
    commentsTable.delete(req, res, next);
});

module.exports = router;