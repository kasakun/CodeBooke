import React, { Component} from 'react';
import { Link }from 'react-router-dom'
import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Home from './contents/Home/Home'
import Apple from './contents/Apple/Apple';
import Boy from './contents/Boy/Boy'
import Cat from './contents/Cat/Cat'


import { Layout, Menu } from 'antd';
import 'antd/dist/antd.css';
const { Header, Footer } = Layout;

class App extends Component {
  render() {
    return (
      <div className="App">
          <Router>
            <Layout className="layout">
              <Header style={{ width: '100%' }}>
                  <div className="logo" />
                  <Menu
                    theme="dark"
                    mode="horizontal"
                    style={{ lineHeight: '64px' }}
                  >
                      <Menu.Item key="1"><Link to='/'>Home</Link ></Menu.Item>
                      <Menu.Item key="2"><Link to='/Apple'>Apple</Link ></Menu.Item>
                      <Menu.Item key="3"><Link to='/Boy'>Boy</Link ></Menu.Item>
                      <Menu.Item key="4"><Link to='/Cat'>Cat</Link ></Menu.Item>
                  </Menu>
              </Header>
              <div>
                  <Route exact path ="/" component={Home}/>
                  <Route path = "/Apple" component={Apple}/>
                  <Route path = "/Boy" component={Boy}/>
                  <Route path = "/Cat" component={Cat}/>
              </div>
              <Footer style={{  textAlign: 'center' }}>
                ©Copyright 2018 Created by Zeyu Chen
              </Footer>
            </Layout>
          </Router>
      </div>
    );
  }
}

export default App;