import logo from './logo.svg';
import './App.css';
import {Component} from "react";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import HoneyBlendsList from "./HoneyBlendsList";
import HoneyBlendEdit from "./HoneyBlendEdit";
import Home from "./Home";

class App extends Component {
  state = {
    honeyBlends: []
  };

  async componentDidMount(){
    const response = await fetch('/honeyBlends');
    const body = await response.json();
    this.setState({honeyBlends: body});
  }

  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/honeyBlends' exact={true} component={HoneyBlendsList}/>
            <Route path='/honeyBlend/:id' component={HoneyBlendEdit}/>
          </Switch>
        </Router>
    )
  }
}


export default App;
