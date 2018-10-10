import React, { Component } from 'react';


class UrlConcat extends Component {
  constructor(props) {
    super(props);
    console.log(props);
    this.state = {
        encounters:[]
    };
    // In ES6, need binding
    this.setState = this.setState.bind(this)
}
  render(){
    console.log('In Url render')
    return(
        <div><h1>URL Component</h1></div>
    );
  }
    
  componentWillReceiveProps(newProps) {
    console.log('In Url ReceiveProps');
    console.log(newProps);
      
    if (this.props.values === newProps.values){
      return;
    } 
      
    let values = newProps.values;
    let state = values.statePicker === undefined ? '':values.statePicker;
    let date = values.datePicker === undefined ? '':values.datePicker;
    let type = values.disasterPicker === undefined ? '':values.disasterPicker;

    // local test :let url = "http://localhost:8080/DizasterX/data/";
    let url = "http://czy-kasakun.com:8080/DizasterX/webapi/data/list?";
    let len = url.length;
    if (date.length !== 0) {
      let temp = 'date1=' + date[0]+ '&date2='+ date[1];
      url += temp;
    }

    if (state.length !== 0){
      let temp = len === url.length ? ('states=' + state[0]):('&states=' + state[0]);
      url = url + temp;
      for(let i = 1; i < state.length; ++i){
        url = url + ',' + state[i];
      }
    }
          
    if (type.length !== 0){
      let temp = len === url.length ? ('incidentTypes=' + type[0]):('&incidentTypes=' + type[0]);
      url = url + temp;
      for(let i = 1; i < type.length; ++i){
        url = url + ',' + type[i];
      }
    }

    console.log(url);
        
    fetch(url)
      .then(res => {
        if (JSON.stringify(res.ok)){console.log("Response success");return res.json();}
      })
      .then(data => {
        let Encounters = [];
        if (data.entries === undefined) {
          this.setState({
              encounters: [],
          });
          return;
        }

        for (let i = 0; i < data.entries.length; ++i) {
          if (data.entries[i] === undefined) break;
          let entries = data.entries[i];
          
          let startDate = entries.incidentBeginDate;
          let endDate = entries.incidentEndDate;
          let title = entries.title;
          let state = entries.state;
          let type = entries.incidentType;
          Encounters[i] = {title: title, state: state, type: type, startdate: startDate, enddate: endDate };
        }
        console.log('Encounters:',Encounters);
        this.setState({
          encounters: Encounters,
        });
          // console.log(this.state.encounters);
      });
    }
}

export default UrlConcat;