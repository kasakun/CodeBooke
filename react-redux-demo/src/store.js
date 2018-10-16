import { createStore, applyMiddleware, compose  } from "redux";
import rootReducer from "./reducers/rootReducer";
import { fetchMiddleware } from "./middleware/fetchMiddleware";

const initStore = () => {

  return createStore(
    rootReducer,
    compose(applyMiddleware(fetchMiddleware))
  );
};

export default initStore;
