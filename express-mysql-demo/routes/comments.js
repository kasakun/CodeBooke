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

/* Query by Id */
router.post('/queryById', function(req, res, next) {
    commentsTable.queryById(req, res, next);
});

/* Query by postId */
router.post('/queryByPostId', function(req, res, next) {
    commentsTable.queryByPostId(req, res, next);
});

/* Query all */
router.post('/queryAll', function(req, res, next) {
    commentsTable.queryAll(req, res, next);
});

module.exports = router;