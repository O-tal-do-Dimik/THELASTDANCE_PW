import * as React from "react";
import {Produto} from './Produto'
import { TextInput, ArrayInput, SimpleFormIterator, ReferenceArrayInput, SelectArrayInput, List, Datagrid, TextField, SimpleForm, Create, Edit, SelectInput, ReferenceInput } from 'react-admin';
import { Cliente } from "./Cliente";


export const NotaF = props => (
    <List {...props}>
        <Datagrid rowClick="edit">
            <TextField label="Cliente" source="cliente.nome" />
            <TextField label="Produto" source="produtos[0].nome" />
            <TextField label="Rua" source="cliente.endereco.rua" />

        </Datagrid>
    </List>
);

export const NotaFEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            {/* <TextInput label="ID Cliente" source="cliente_id" />
            <TextInput label="ID produto" source="produtos[0].id" /> */}

            <ReferenceInput source="cliente_id" reference="Cliente">
                <SelectInput source="cliente" optionText="nome" />
            </ReferenceInput>

            <ArrayInput source="Produto" >
                <SimpleFormIterator>
                    <SelectArrayInput  source="produtos" optionText="nome" />
                </SimpleFormIterator>
            </ArrayInput>

        </SimpleForm>
    </Edit>
);


export const NotaFCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <ReferenceInput source="cliente_id" reference="Cliente">
                <SelectInput source="cliente" optionText="nome" />
            </ReferenceInput>

            {/* <TextInput label="ID Cliente" source="cliente.id" /> */}
{/* 
            <ReferenceInput source="cliente" reference="Cliente">
                <SelectInput optionText="nome" />
            </ReferenceInput> */}

            <ArrayInput source="Produto" >
                <SimpleFormIterator>
                    <SelectArrayInput  source="produtos" optionText="nome" />
                </SimpleFormIterator>
            </ArrayInput>


            {/* <ReferenceInput source="produto_id" reference="Produto">
                <SelectInput optionText="nome" />
            </ReferenceInput> */}
            {/* <Resource name="Produto"  list={Produto} /> */}
        </SimpleForm>
    </Create>
);