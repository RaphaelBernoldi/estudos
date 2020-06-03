import React, { Component } from 'react';
import { View, Text } from 'react-native';
import Padrao from '../estilo/Padrao';


export default props => {
    return(
          <Text style={Padrao.ex} >{props.texto}</Text>
        )
}