import './css/App.css';
import Header from "./components/Header";
import Login from "./components/Login";
import SignUp from "./components/SignUp";
import AddHouses from "./components/AddHouses";

import {BrowserRouter as Router,
    Routes,
    Route} from "react-router-dom";


function App() {

    return (
        <Router>
            <Header />
            <Routes>
                {/*<Route path="/" element={<Main />} />*/}
                <Route path="/houses" element={<AddHouses />} />
                <Route path="/signup" element={<SignUp />} />
                <Route path="/login" element={<Login />} />
            </Routes>
        </Router>
    );
}

export default App;
