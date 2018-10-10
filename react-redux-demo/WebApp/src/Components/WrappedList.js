import React, { Component } from 'react'
import { bindActionCreators } from 'redux';
import * as FetchAction from '../actions/fetchData';
import { connect } from 'react-redux';
import { List } from 'antd';
import 'antd/dist/antd.css';

class WrappedList extends Component{
  constructor(props){
    super(props);
    console.log("in list constructor");
  }

  render(){
    console.log("in list render, list.props:",this.props);
    return(
      <div>
      <h3 style={{ marginBottom: 16 }}>DizasterX</h3>
      <List
        style={{ marginLeft: 16 }}
        dataSource={this.props.fetchData}
        renderItem={item => (
            <List.Item>
                <div>
                {item.title}, {item.state}, {item.type}, {item.startdate}, {item.enddate}
                </div>
            </List.Item>
        )}
        pagination={{
            onChange: (page) => {
                console.log(page);
            },
            pageSize: 10,
        }}
      />
      </div>
    );
  }
}

function mapStateToProps(state, prop){
  console.log("in list component mapStateToProps, state=",state);
  return{
    url: state.url,
    fetchData: state.fetchData
  }
}

function mapDispatchToProps(dispatch){
  return{
    action: bindActionCreators(FetchAction, dispatch)
  }
}

export default connect(mapStateToProps,mapDispatchToProps)(WrappedList);               