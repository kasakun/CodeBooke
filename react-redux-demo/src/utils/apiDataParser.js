/**
 * @author Zeyu Chen
 * @version 1.0
 */
const apiDataParser = data => {
  let result = {};
  if (data) {
    const { size, entries } = data;
    console.log(data)
    result.entries = entries.map(entry => entry)
    result.size = size;
  }

  return result;
};

export default apiDataParser;
