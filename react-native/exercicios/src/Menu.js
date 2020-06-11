import React, { Component } from 'react';

import { createDrawerNavigator } from '@react-navigation/drawer';
import { NavigationContainer } from '@react-navigation/native';

import ParImpar from './componentes/ParImpar';
import Inverter, { MegaSena } from './componentes/Multi';
import Simples from './componentes/Simples';
import Evento from './componentes/Evento';


const Drawer = createDrawerNavigator();

const megaSenaScreen = () => <MegaSena numero={8} />
const inverterScreen = () => <Inverter texto='React Nativo!'/>
const parImparScreen = () => <ParImpar numero={30}/>
const simplesScreen = () => <Simples texto='Texto simples'/>
const eventoScreen = () => <Evento/>


export default class Menu extends Component {
    

    render(){
        return (
            <NavigationContainer>
              <Drawer.Navigator>
                <Drawer.Screen name="Evento" component={eventoScreen} />
                <Drawer.Screen name="Mega Sena" component={megaSenaScreen} />
                <Drawer.Screen name="Inverter" component={inverterScreen} />
                <Drawer.Screen name="Par & Impar" component={parImparScreen} />
                <Drawer.Screen name="Simples" component={simplesScreen} />
              </Drawer.Navigator>
            </NavigationContainer>
          );
    }
}




/*
export default createDrawerNavigator({
    MegaSena: {
        screen: () => {return (<MegaSena numero={8} />)},
        navigationOptions: { title: 'Mega Sena'}
    },
    Inverter: {
        screen: () => <Inverter texto='React Nativo!'/>,
        navigationOptions: { title: 'Inverter'}
    },
    ParImpar: {
        screen: () => <ParImpar numero={30}></ParImpar>,
        navigationOptions: {title: 'Par & Impar'}
    },
    Simples: {
        screen: () => <Simples texto='Texto simples'/>
    }

}, { drawerWidth: 300} ) 
*/