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

/*POST*/
router.post('/', function(req, res, next) {
  let r = req.param('Red');
  let g = req.param('Green');
  let b = req.param('Blue');

  res.json({status:'success', Red: r, Green: g, Blue: b});
  console.log(JSON.stringify(req.body));

});

module.exports = router;
