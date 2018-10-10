console.log("in url reducer");

export default(state = [], payload) => {
  switch(payload.type){
    case 'concat':
      return payload.url;
    default:
      return state;
  }
};