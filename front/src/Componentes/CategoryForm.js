import React, { useRef, useState, useContext } from 'react';
import Store from './Store';

const HOST_API = "http://localhost:8080/api";

const CategoryForm = () => {
    const formRef = useRef(null);
    const { dispatch, state: { category } } = useContext(Store);
    const item = category.item;
    const [state, setState] = useState(item);

    const onAdd = (event) => {
      event.preventDefault();
  
      const request = {
        groupname: state.groupname,
        id: null
      };
  
  
      fetch(HOST_API + "/categorylist", {
         method: "POST",
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json',
        }
        
      })
        .then(response => response.json())
        .then((category) => {
          dispatch({ type: "add-item", item: category });
          setState({ groupname: "" });
          formRef.current.reset();
        });
    }

    return (
        <div>
            <form ref={formRef}>
                <input
                    type="text"
                    groupname="name"
                    placeholder="Lista de TO-DO"
                    onChange={(event) => {
                        setState({ ...state, groupname: event.target.value })
                    }}
                ></input>
                <button onClick={onAdd}>Nueva Lista</button>
            </form>
        </div >
    )
}

export default CategoryForm;