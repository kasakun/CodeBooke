import ReactDOM from 'react-dom';
import './index.css';
import 'antd/dist/antd.css';
import registerServiceWorker from './registerServiceWorker';
import { Provider } from 'react-redux';
import Store from './store';
import React from 'react';

import App from './App'

const StoreInstance = Store();


ReactDOM.render(
  <Provider store={StoreInstance}>
    <App />
  </Provider>,
  document.getElementById('root')
 );
  
  
registerServiceWorker();
