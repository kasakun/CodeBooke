/**
 * @author Zeyu Chen
 * @version 1.0
 */
import React, { Component } from "react";
import PropTypes from "prop-types";

class Entry extends Component {
  static propTypes = {
    entry: PropTypes.object.isRequired,
  };

  render() {
    const { entry } = this.props;

    return (
      <div className="Entry">
        {entry.title} | {entry.state} | {entry.dateNumber}
        <hr></hr>
      </div>
    );
  }
}

export default Entry;
