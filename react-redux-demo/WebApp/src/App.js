import React, { Component } from 'react';
import { BrowserRouter as Router, Link } from 'react-router-dom';

import WrappedList from './Components/WrappedList';
import WrappedForm from './Components/WrappedForm';
//import Cart from './Components/cart'
import { Layout, Menu, Form } from 'antd';
const { Header, Footer, Sider, Content } = Layout;

class App extends Component {
  render() {
    console.log("in App render");
    return (
      <div className="Index">
        <Router>
          <Layout className = "IndexLayout">
            <Header className = "header">
              <Menu 
                theme="dark"
                mode="horizontal"
                defaultSelectedKeys={['1']}
                style={{ lineHeight: '64px' }}
              >
                <Menu.Item key="1"><Link to='/'>Home</Link ></Menu.Item>
                
              </Menu>
            </Header>
            <Layout>
              <Sider width={300} style={{ background: '#fff' }}>
                  <div style={{marginTop: 16, marginLeft: 16}}> <WrappedFiltrateForm /> </div>
              </Sider>
              <Content id="HomeContent" style={{ textAlign: 'center', minHeight: 500 }}>
                  <div> <WrappedList/> </div>
              </Content>
            </Layout>
            <Footer style={{ textAlign: 'center' }}>
              my-fisrt-try©2018 Created by LSJ
            </Footer>
          </Layout>          
        </Router>
      </div>
    );
  }
}

export default App;

const WrappedFiltrateForm = Form.create()(WrappedForm);