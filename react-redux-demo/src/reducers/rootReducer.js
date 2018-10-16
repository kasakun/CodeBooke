/**
 * @author Zeyu Chen
 * @version 1.0
 */
import { combineReducers } from "redux";
import { entriesReducer } from "./entriesReducer";
import { cacheReducer } from "./cacheReducer";

/*
 * reducers maintaince the state values 
 *               state
 *               __|__
 *              |     |
 *         entries    cache
 */
export default combineReducers({
  entries: entriesReducer,
  cache: cacheReducer
});