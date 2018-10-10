console.log("in formValues reducer");

export default(state = [], payload) => {
    switch(payload.type){
        case 'update':
            return payload.values;
        default:
            return state;
    }
};