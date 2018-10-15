import apiDataParser from "../utils/apiDataParser";
import { getCacheExpDate, getCachedData } from "../selectors";
import {
  FETCH_POSTS,
  fetchPostsSuccess,
  fetchPostsError,
  cacheSet
} from "../actions";

const BASE_URL = "https://www.reddit.com";
const BASE_PARAMS = "raw_json=1";

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

export const fetchMiddleware = store => next => action => {
  if (action.type === FETCH_POSTS) {
    const { subreddit } = action;

    //return cached data if available
    const expires = getCacheExpDate(store.getState(), subreddit);
    if (expires && expires > Date.now()) {
      const data = getCachedData(store.getState(), subreddit);
      return next(fetchPostsSuccess(data));
    }
    // hardcode test
    const url = `http://czy-kasakun.com:8080/DizasterX/webapi/data/list?date1=19530908&date2=19540808&states=CA,MS}`;

    apiGet(url)
      .then(data => {
        next(cacheSet(subreddit, data)); //cache response
        return next(fetchPostsSuccess(data));
      })
      .catch(error => {
        return next(fetchPostsError(error));
      });
  }

  return next(action);
};
