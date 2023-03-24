import React from "react";
import logo from "../images/shareHouseLogo.jpg";
import "../css/Header.css";

function Logo() {
    return (
        <header>
            <nav>
                <div className="logo-container">
                    <img src={logo} alt="logo" className="logo-image"/>
                </div>
            </nav>
        </header>
    );
}

export default Logo;