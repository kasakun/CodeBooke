var express = require('express');
var router = express.Router();
var bodyParser = require("body-parser");

/* GET users listing. */
router.get('/', function(req, res, next) {
  let name = req.param('name');
  let password = req.param('password')

  if (name == undefined && password == undefined)
    res.send('Please send url with params(name and password)');
  else
    // res.send('Received. name:' + name + ' password:' + password);
    res.json({status: 'success', name: name, password: password});
});

module.exports = router;
