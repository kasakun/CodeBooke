/**
 * @author Zeyu Chen
 * @version 1.0
 */
import apiDataParser from "../utils/apiDataParser";
import { getCachedData } from "../selectors";
import {
  FETCH_LIST,
  fetchListSuccess,
  fetchListError,
  cacheSet
} from "../actions";

const BASE_URL = "http://czy-kasakun.com:8080/DizasterX/webapi/data";
const BASE_PARAMS = "list";

const apiGet = url => {
  return fetch(url)
    .then(response => {
      if (response.ok) {
        return response.json();
      }
      throw new Error(response.status);
    })
    .then(json => apiDataParser(json));
};

// currying
export const fetchMiddleware = store => next => action => {
  if (action.type === FETCH_LIST) {
    const { search } = action;

    //return cached data if available
    const data = getCachedData(store.getState(), search);
    if (data) {
      return next(fetchListSuccess(data));
    }

    const url = `${BASE_URL}/${BASE_PARAMS}${search}`;

    apiGet(url)
      .then(data => {
        console.log(data);
        next(cacheSet(search, data)); //key=search, value={entries, size}
        return next(fetchListSuccess(data));
      })
      .catch(error => {
        return next(fetchListError(error));
      });
  }

  return next(action);
};
