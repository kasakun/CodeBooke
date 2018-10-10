export const fetchData = (url) => {
  console.log("in fetchData action");
  let Encounters = [];
  console.log('Encounters before fetching:',Encounters);
  fetch(url)
    .then(res => {
        if (JSON.stringify(res.ok)){console.log("Response success");return res.json();}
    }) 
    .then(data => {
      console.log("fetching...")
      if (data.entries === undefined) {
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
        Encounters[i] = {
          title: title, 
          state: state, 
          type: type, 
          startdate: startDate, 
          enddate: endDate 
        };
      }
      console.log('Encounters after fetching:',Encounters);
    });

    return {
        type: 'fetch',
        Encounters
    };
}