import React, {Component} from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Home from './Home';
import Login from './Login';
import StudentView from './StudentView';

class App extends Component {
  render() {
    return (
    <Router>
     <Switch>
      <Route path = '/' exact = {true} component = {Home}/>
      <Route path = '/login' component={Login}/>
      <Route path ='/student' component={StudentView}/>
     </Switch>
    </Router>
   );
  }
}

export default App;
