import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route, Redirect } from "react-router-dom";

import List from "./containers/List";
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Router>
          <div className="main-content">
            <Switch>
              <Route exact path="/" component={List} />
            </Switch>
          </div>
        </Router>
      </div>
    );
  }
}

export default App;
