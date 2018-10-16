/**
 * @author Zeyu Chen
 * @version 1.0
 */
import React, { Component, Fragment } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";

import { fetchList } from "../actions";
import Entry from "../components/Entry/Entry"


class List extends Component {
  static propTypes = {
    entries: PropTypes.array,
    size: PropTypes.number,
    dispatch: PropTypes.func.isRequired,
    history: PropTypes.object.isRequired,
    location: PropTypes.object.isRequired
  };

  componentDidMount() {
    this.fetchData(this.props.location.search);
  }

  componentDidUpdate(prevProps, prevState) {
    const search = this.props.location.search;
    if (search !== prevProps.location.search) {
      this.fetchData(search);
    }
  }

  fetchData(search) {
    const { dispatch } = this.props;
    dispatch(fetchList(search));
  }

  render() {
    const { entries, size } = this.props;

    return (
      <div>
        Total: {size}
        <Fragment>
        <div>
          {entries && entries.map(entry => ( //Remeber we have to check because at first we dont have data
              <Entry
                key={entry.hash}
                entry={entry}
              />
            ))}
          </div>
      </Fragment>
      </div>
    );
  }
}

/*
 * Go to check rootReducer.js to check the state.
 */
const mapState = state => ({
  entries: state.entries.data.entries,
  size: state.entries.data.size
});

export default connect(mapState)(List);
