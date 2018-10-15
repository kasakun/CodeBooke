const apiDataParser = data => {
  let result = {};
  if (data.data) {
    //subreddit data
    const { children, after, before } = data.data;
    result.posts = children.map(child => child.data);
    result.meta = { after, before };
  }
  return result;
};

export default apiDataParser;
