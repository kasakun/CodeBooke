/**
 * @author Zeyu Chen
 * @version 1.0
 */
import { FETCH_LIST, FETCH_LIST_SUCCESS, FETCH_LIST_ERROR } from "../actions";

/**
 * The entriesReducer is mapped to entries in rootReducer
 * 
 * entries.data
 */
export const entriesReducer = (state = { data: {} }, action) => {
  switch (action.type) {
    case FETCH_LIST:
      return { data: {}, isLoading: true };
    case FETCH_LIST_SUCCESS:
      return { data: action.data, isLoading: false };
    case FETCH_LIST_ERROR:
      return { data: {}, error: action.error, isLoading: false };
    default:
      return state;
  }
};
