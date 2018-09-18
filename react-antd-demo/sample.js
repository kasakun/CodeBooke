import React , { Component }from 'react';
import './SearchPatient.css';
import { Form, Row, Col, Input, Button, Icon, DatePicker, Radio } from 'antd';

import PatientGroup from './PatientGroup';
const RadioButton = Radio.Button;
const RadioGroup = Radio.Group;


class SearchPatient extends Component {
    state = {
        expand: false,
        values:[],
    };

    handleSearch = (e) => {
        e.preventDefault();
        this.props.form.validateFields((err, Values) => {
            // console.log('Received values of form: ', Values);
            // console.log(this.state.values);
            this.setState({values: Values});
        });
    };

    handleReset = () => {
        this.props.form.resetFields();
    };

    toggle = () => {
        const { expand } = this.state;
        this.setState({ expand: !expand });
    };

    // To generate mock Form.Item
    getFields() {
        const expand = this.state.expand;
        const { getFieldDecorator } = this.props.form;
        const children = [];

        children.push(
            <Col span={5} key={0} style={{ display: 'block' }}>
                <Form.Item label={`ID`}>
                    {getFieldDecorator(`ID`, {
                        rules: [{required: false, message: 'Please input ID.',}],
                    })(
                        <Input placeholder="Patient ID" />
                    )}
                </Form.Item>
            </Col>
        );
        children.push(
            <Col span={8} key={1} style={{ display: 'block' }}>
                <Form.Item label={`Given Name`}>
                    {getFieldDecorator(`Given`, {
                        rules: [{required: false, message: 'Please input given name.',}],
                    })(
                        <Input placeholder="Given Name" />
                    )}
                </Form.Item>
            </Col>
        );
        children.push(
            <Col span={8} key={2} style={{ display: 'block' }}>
                <Form.Item label={`Family Name`}>
                    {getFieldDecorator(`Family`, {
                        rules: [{required: false, message: 'Please input family name.',}],
                    })(
                        <Input placeholder="Family Name" />
                    )}
                </Form.Item>
            </Col>
        );
        children.push(
            <Col span={7} key={3} style={{ display: expand ? 'block':'none' }}>
                <Form.Item label="Gender">
                    {getFieldDecorator('Gender')(
                        <RadioGroup>
                            <RadioButton value="Male">M</RadioButton>
                            <RadioButton value="Female">F</RadioButton>
                            <RadioButton value="Non-binary">None</RadioButton>
                        </RadioGroup>
                    )}
                </Form.Item>
            </Col>
        );
        children.push(
            <Col span={8} key={4} style={{ display: expand ? 'block':'none' }}>
                <Form.Item label="Birth Date">
                    {getFieldDecorator('Birth', {
                        rules: [{ type: 'object', required: false, message: 'Please select time!' }],
                    })(
                        <DatePicker />
                    )}
                </Form.Item>
            </Col>
        );
        return children;
    };

    render() {
        return (
            <div>
                <Form
                    className="ant-advanced-search-form"
                    onSubmit={this.handleSearch}
                >
                    <Row gutter={24}>
                        {this.getFields()}
                    </Row>
                    <Row>
                        <Col span={24} style={{ textAlign: 'right' }}>
                            <Button type="primary" htmlType="submit">Search</Button>
                            <Button style={{ marginLeft: 8 }} onClick={this.handleReset}>
                                Clear
                            </Button>
                            <a style={{ marginLeft: 8, fontSize: 12 }} onClick={this.toggle}>
                                More <Icon type={this.state.expand ? 'up' : 'down'} />
                            </a>
                        </Col>
                    </Row>
                </Form>
                <hr/>
                <div className="search-result-list">
                    <PatientGroup values={this.state.values}/>
                </div>
            </div>
        );
    }
}


SearchPatient = Form.create({})(SearchPatient);
// export default SearchPatient;
export default SearchPatient;