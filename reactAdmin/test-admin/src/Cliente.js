import * as React from "react";
import { List, Datagrid, TextField, SimpleForm, Create, Edit, TextInput } from 'react-admin';


export const Cliente = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField label="Cliente" source="nome" />
            <TextField label="CPF" source="cpf" />
            <TextField label="Bairro" source="endereco.bairro" />
            <TextField label="Rua" source="endereco.rua" />
        </Datagrid>
    </List>
);

export const ClienteEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextField label="Cliente" source="nome" />
            <TextField label="CPF" source="cpf" />
            <TextField label="Bairro" source="endereco.bairro" />
            <TextField label="Rua" source="endereco.rua" />
        </SimpleForm>
    </Edit>
);


export const ClienteCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <TextInput label="CPF" source="cpf" />
            <TextInput label="Cliente" source="nome" />
            <TextInput label="Bairro" source="endereco.bairro" />
            <TextInput label="Rua" source="endereco.rua" />
        </SimpleForm>
    </Create>
);