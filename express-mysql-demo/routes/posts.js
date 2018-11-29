/**
 * @author Zeyu Chen
 */
const express = require('express');
const router = express.Router();
const commentsTable = require('../src/posts');

/* Add comment. */
router.post('/addPost', function(req, res, next) {
	commentsTable.add(req, res, next);
});

/* Update comment */
router.post('/updatePost', function(req, res, next) {
    commentsTable.update(req, res, next);
});

/* Delete comment */
router.post('/deletePost', function(req, res, next) {
    commentsTable.delete(req, res, next);
});

/* Query by Id */
router.post('/queryById', function(req, res, next) {
    commentsTable.queryById(req, res, next);
});

/* Query by status */
router.post('/queryByStatus', function(req, res, next) {
    commentsTable.queryByStatus(req, res, next);
});

/* Query by title */
router.post('/queryByTitle', function(req, res, next) {
    commentsTable.queryByStatus(req, res, next);
});

/* Query all */
router.post('/queryAll', function(req, res, next) {
    commentsTable.queryAll(req, res, next);
});

module.exports = router;