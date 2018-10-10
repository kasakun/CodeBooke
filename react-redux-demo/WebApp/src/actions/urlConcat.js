export const urlConcat = (values) => {
    console.log("updating url form values", values);
    let state = values.statePicker === undefined ? '':values.statePicker;
    let date = values.datePicker === undefined ? '':values.datePicker;
    let type = values.disasterPicker === undefined ? '':values.disasterPicker;
    //console.log(state);
    //console.log(date);
    //console.log(type);
        
    // server
    let url = "http://czy-kasakun.com:8080/DizasterX/webapi/data/list?";
    // local test
    // let url = "http://localhost:8080/DizasterX/data/";
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

    console.log("url:",url);
    
    return {
        type: 'concat',
        url
    };
}