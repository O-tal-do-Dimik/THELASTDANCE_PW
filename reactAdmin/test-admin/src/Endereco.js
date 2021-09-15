import * as React from "react";
import {TextField,List,Datagrid} from 'react-admin';

export const EnderecoList = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <TextField source="bairro" />
            <TextField label="Cliente" source="cliente.nome" />
            <TextField label="Cliente" source="cliente.email" />
        </Datagrid>
    </List>
);

