import React from 'react';
import CategoryForm from './Componentes/CategoryForm';
import Form from './Componentes/Form';
import List from './Componentes/List';
import { StoreProvider } from './Componentes/Store';

function App() {
  return <StoreProvider>
    <h3>To-Do List</h3>
    {/*<Form />
    <List />*/}
    <CategoryForm/>
  </StoreProvider>
};
export default App;