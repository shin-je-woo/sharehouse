import './css/App.css';
import Header from "./components/Header";
import Login from "./components/Login";
import SignUp from "./components/SignUp";
import {BrowserRouter as Router,
    Routes,
    Route} from "react-router-dom";

function App() {

    return (
        <Router>
            <Header />
            <Routes>
                <Route path="/signup" element={<SignUp />} />
                <Route path="/login" element={<Login />} />
            </Routes>
        </Router>
    );
}

export default App;
