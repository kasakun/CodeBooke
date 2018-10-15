import { createStore, applyMiddleware, compose } from "redux";
import rootReducer from "./reducers/rootReducer";
import { fetchMiddleware } from "./middleware/fetchMiddleware";
// import { subsPersist } from "./middleware/subsPersist";

const initStore = () => {
  const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

  return createStore(
    rootReducer,
    applyMiddleware(fetchMiddleware)
    // composeEnhancers(applyMiddleware(fetchMiddleware, subsPersist))
  );
};

export default initStore;
