/**
 * @author Zeyu Chen
 * @version 1.0
 */
// type
export const FETCH_LIST = "FETCH_LIST";
export const FETCH_LIST_SUCCESS = "FETCH_LIST_SUCCESS";
export const FETCH_LIST_ERROR = "FETCH_LIST_ERROR";

export const CACHE_SET = "CACHE_SET";

// action
export const fetchList = search => ({ type: FETCH_LIST, search });
export const fetchListSuccess = (data, search) => ({ type: FETCH_LIST_SUCCESS, data });
export const fetchListError = (error, search) => ({ type: FETCH_LIST_ERROR, error });

export const cacheSet = (key, value) => ({ type: CACHE_SET, key, value });
