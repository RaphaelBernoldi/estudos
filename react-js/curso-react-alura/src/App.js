import React, { Component, Fragment } from 'react';
import 'materialize-css/dist/css/materialize.min.css';
import Header from './header';
import './App.css';

class App extends Component {

render(){
  return (
    <Fragment>
      <Header />
      <div className="container mb-10">
        <h1>Bem Vindo à maior biblioteca do Brasil!</h1>
      </div>
    </Fragment>
  );
}
  
}

export default App;
