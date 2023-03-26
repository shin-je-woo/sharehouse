import './css/App.css';
import Header from "./components/Header";
import Logo from "./components/Logo";
import Login from "./components/Login";
import SignUp from "./components/SignUp";
import {BrowserRouter as Router,
    Routes,
    Route} from "react-router-dom";

function App() {

    return (
        <Router>
            <Routes>
                <Route path="/signup" element={<SignUp />} />
                <Route path="/login" element={<Login />} />
                <Route path="/Logo" element={<Logo />} />
                <Route path="/" element={<Header />} />
            </Routes>
        </Router>
    );
}

export default App;
