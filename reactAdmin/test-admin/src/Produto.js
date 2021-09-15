import * as React from "react";
import { List, Datagrid, TextField, SimpleForm, NumberInput, Create, Edit, TextInput } from 'react-admin';

export const Produto = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField source="id" />
            <TextField source="nome" />
            <TextField source="preco" />
        </Datagrid>
    </List>
);

export const ProdutoEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput source="nome"/>
            <TextInput source="preco" />
        </SimpleForm>
    </Edit>
);


export const ProdutoCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="nome" />
            <TextInput source="preco" />
        </SimpleForm>
    </Create>
);
