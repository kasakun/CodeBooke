// type
export const FETCH_POSTS = "FETCH_POSTS";
export const FETCH_POSTS_SUCCESS = "FETCH_POSTS_SUCCESS";
export const FETCH_POSTS_ERROR = "FETCH_POSTS_ERROR";

export const CACHE_SET = "CACHE_SET";

// action
export const fetchPosts = subreddit => ({ type: FETCH_POSTS, data });
export const fetchPostsSuccess = (data, subreddit) => ({ type: FETCH_POSTS_SUCCESS, data });
export const fetchPostsError = (error, subreddit) => ({ type: FETCH_POSTS_ERROR, error });

export const cacheSet = (key, value) => ({ type: CACHE_SET, key, value });
