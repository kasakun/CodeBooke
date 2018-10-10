import React, { Component } from 'react'
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as FormAction from '../actions/updateForm';
import * as UrlAction from '../actions/urlConcat';
import * as FetchAction from '../actions/fetchData';
import 'antd/dist/antd.css';
import { Form, DatePicker, Button } from 'antd';
import { Select } from 'antd';
//import UrlConcat from './UrlConcat';

const FormItem = Form.Item;
const { RangePicker } = DatePicker;

class FiltrateForm extends Component {
  constructor(props){
    super(props);
  }
  
  handleSubmit = (e) => {
    e.preventDefault();

    this.props.form.validateFields((err, fieldsValue) => {
      if (err) {
        return;
      }

      // Should format date value before submit.
      if (fieldsValue['datePicker'] !== undefined && fieldsValue.datePicker.length !== 0){
        const rangeValue = fieldsValue['datePicker'];
        const values = {
          ...fieldsValue,
          'datePicker': [rangeValue[0].format('YYYYMMDD'), rangeValue[1].format('YYYYMMDD')]
        };
        this.props.action1.updateForm(values);
        let URL = this.props.action2.urlConcat(values);
        //console.log("URL=",URL.url)
        this.props.action3.fetchData(URL.url);
        //console.log('Received values of form: ', values); 
      }
      else {
        const values = {
          ...fieldsValue
        };
        this.props.action1.updateForm(values);
        let URL = this.props.action2.urlConcat(values); 
        this.props.action3.fetchData(URL.url);
        //console.log('Received values of form: ', values); 
      }
    });
    console.log("form.handleSubmit ended, form.props:",this.props)
    //
    //this.props.action3.fetchData(this.props.url);
  }

  render() {
    console.log("in form render, form.props =", this.props);
    const { getFieldDecorator } = this.props.form;
    const formItemLayout = {
      labelCol: {
        xs: { span: 24 },
        sm: { span: 8 },
      },
      wrapperCol: {
        xs: { span: 24, offset: 0 },
        sm: { span: 16, offset: 4 },
      },
    };
    //const config = {
    //  rules: [{ type: 'object', required: true, message: 'Please select time!' }],
    //};
    const dateConfig = {
      rules: [{ type: 'array', required: false, message: 'Please select Time!' }],
    };
    const stateConfig = {
      rules: [{ type: 'array', required: false, message: 'Please select State!' }],
    };
    const disasterConfig = {
        rules: [{ type: 'array', required: false, message: 'Please select Disaster Type!' }],
      };
    return (
      <div>
  
      <Form onSubmit={this.handleSubmit}>
        <FormItem
          {...formItemLayout}
          //label="DatePicker"
        >
          {getFieldDecorator('datePicker', dateConfig)(
            <RangePicker />
          )}
        </FormItem>

        <FormItem
          {...formItemLayout}
          //label="StatePicker"
        >
          {getFieldDecorator('statePicker', stateConfig)(
            <Select
            mode="multiple"
            style={{ width: '100%' }}
            placeholder="Please select States"
          >
            {stateChildren}
          </Select>
          )}
        </FormItem>

        <FormItem
          {...formItemLayout}
          //label="StatePicker"
        >
          {getFieldDecorator('disasterPicker', disasterConfig)(
            <Select
            mode="multiple"
            style={{ width: '100%' }}
            placeholder="Please select Disaster Types"
          >
            {disasterChildren}
          </Select>
          )}
        </FormItem>
      
        <FormItem
          wrapperCol={{
            xs: { span: 24, offset: 0 },
            sm: { span: 16, offset: 8 },
          }}
        >
          <Button type="primary" htmlType="submit">Submit</Button>
        </FormItem>
      </Form>
        
      </div>
    );
  }
}

function mapStateToProps(state, prop){
  console.log("in form component mapStateToProps, state=",state);
  return{
      formValues: state.formValues,
      url: state.url,
      fetchData: state.fetchData
  }
}

function mapDispatchToProps(dispatch){
  return{
      action1: bindActionCreators(FormAction, dispatch), 
      action2: bindActionCreators(UrlAction, dispatch),
      action3: bindActionCreators(FetchAction, dispatch),
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(FiltrateForm);



const Option = Select.Option;

const States = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 
                'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia',
                'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas',
                'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts',
                'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana',
                'Nebraska', 'Nevada', 'New Hampshire','New Jersey', 'New Mexico',
                'New York', 'North Carolina', 'North Dakota', 'Ohio', 'Oklahoma',
                'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 
                'South Dakota','Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 
                'Washington','West Virginia', 'Wisconsin', 'Wyoming'];

const stateAbvr = ['AL','AK','AZ','AR','CA',
              'CO','CT','DE','FL','GA',
              'HI','ID','IL','IN','IA',
              'KS','KY','LA','ME','MD',
              'MA','MI','MN','MS','MO',
              'MT','NE','NV','NH','NJ',
              'NM','NY','NC','ND','OH',
              'OK','OR','PA','RI','SC',
              'SD','TN','TX','UT','VT',
              'VA','WA','WV','WI','WY'];

const disasterType = ['Drought', 'Earthquake', 'Flood', 'Hurricane',
                     'Severe Storm', 'Snow', 'Tornado', 'Toxic Substance', 'Typhoon'];

const stateChildren = [];
for (let i = 0; i < 50; i++) {
  stateChildren.push(<Option key={stateAbvr[i]}>{States[i]}</Option>);
}

const disasterChildren = [];
for (let i = 0; i < 9; i++){
    disasterChildren.push(<Option key={disasterType[i]}>{disasterType[i]}</Option>)
}



