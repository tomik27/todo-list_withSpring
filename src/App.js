import './App.css';
import {useState} from "react";

function App() {
    const thingsToDo =  [   {
        "id": 1,
        "value": "Udelat neco hodne duleziteho"
    },
        {
            "id": 2,
            "value": "Nedelat nic"
        }
    ]

    const [data, setData] = useState(thingsToDo)
    const [value, setValue] = useState("")



    const addHandler = function () {
        //kopie objektu

        const todo = {
            id: new Date().getTime(),
            value: value
        }
        const newData = [...data]
        newData.push(todo)
        console.log(newData)
        setData(newData)
    }
    const removeHandler = function (id) {
        //kopie objektu
      /*  data.remove(item)
        const newData = [...data]
        setData(newData)*/
        const filteredData = data.filter(item => item.id !== id)
        setData(filteredData)
    }
  return (
    <div className="App">
        <div id="myDIV" className="header">
            <h2>To-do List</h2>

            <input type={"text"}value={value} id="myInput" placeholder={"Todoo"} onChange={(e)=>setValue(e.target.value)}/>

            <span onClick={addHandler} className="addBtn">Add</span>
        </div>
        <ul id="myUL">
             {data.map(item=><li>{item.value} <button className="align-right" onClick={()=>removeHandler(item.id)}>DONE</button> </li>)}
        </ul>
    </div>
  );
}

export default App;
