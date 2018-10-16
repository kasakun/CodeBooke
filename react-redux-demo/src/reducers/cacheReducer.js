/**
 * @author Zeyu Chen
 * @version 1.0
 */
import { CACHE_SET } from "../actions";

//stores key-value pairs and expiration date
export const cacheReducer = (state = { data: {}, exp: {} }, action) => {
  switch (action.type) {
    case CACHE_SET: {
      const { key, value } = action;
      const result = { ...state };
      result.data[key] = value;
      return result;
    }
    default:
      return state;
  }
};
