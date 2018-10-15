import React, { Component, Fragment } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";


class List extends Component {
  static propTypes = {
    posts: PropTypes.array,
    isLoading: PropTypes.bool,
    dispatch: PropTypes.func.isRequired,
    history: PropTypes.object.isRequired,
    match: PropTypes.object.isRequired
  };
  render() {
    const { posts, isLoading, match, error } = this.props;
    match.params.sub = 'ss';
    console.log(this.props)
    return (
      <div>
          List
          
          <a></a>
      </div>
    );
  }
}

const mapState = state => ({
  posts: state.posts.data.posts,
  error: state.posts.error,
  isLoading: state.posts.isLoading
});

export default connect(mapState)(List);
