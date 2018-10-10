export const updateForm = (values) => {
    console.log("updating form values", values);
    return {
        type: 'update',
        values
    };
}