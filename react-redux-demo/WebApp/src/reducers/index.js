//import cart from './cart';
import formValues from './formValues';
import url from './url';
import fetchData from './fetchData';
import { combineReducers } from 'redux';
console.log("in index reducer");
const rootReducer = combineReducers({
    formValues,
    url,
    fetchData
});

export default rootReducer;