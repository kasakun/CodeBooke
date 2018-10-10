console.log("in fetchData reducer");

export default(state = [], payload) => {
  switch(payload.type){
    case 'fetch':
      return payload.Encounters;
    default:
      return state;
  }
};