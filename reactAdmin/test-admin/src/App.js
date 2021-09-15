import * as React from "react";
import { Admin, Resource } from 'react-admin';
import {NotaF, NotaFCreate, NotaFEdit} from './NotaF';
import { Cliente,ClienteCreate,ClienteEdit} from "./Cliente";
import {Produto,ProdutoCreate,ProdutoEdit} from './Produto'
import jsonServerProvider from 'ra-data-json-server';

const dataProvider = jsonServerProvider('http://localhost:8080');

const App = () => (
    <Admin dataProvider={dataProvider}>
        {/* <Resource name="Endereco" list={EnderecoList} /> */}
        <Resource name="Cliente"  list={Cliente} edit={ClienteEdit} create={ClienteCreate}/>
        <Resource name="Produto" list={Produto} edit={ProdutoEdit} create={ProdutoCreate}/>
		<Resource name="NotaNF" list={NotaF} edit={NotaFEdit} create={NotaFCreate}/>
    </Admin>
);

export default App;
