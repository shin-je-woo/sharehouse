// Header.js

import React, { useState } from "react";
import "../css/Header.css";
import logo from "../images/shareHouseLogo.jpg";
import { Link, useNavigate } from 'react-router-dom';
import { Dropdown, Menu } from 'semantic-ui-react'



function Header() {
    const [activeItem, setActiveItem] = useState('home');

    const handleItemClick = (e, { name }) => setActiveItem(name) && console.log(name) ;

    const handleDropdownItemClick = (e, { name }) => console.log(name);

    const dropdownOptions  = [
        { key: 1, text: '홍제', value: 1 },
        { key: 2, text: '응암', value: 2 },
        { key: 3, text: '새절', value: 3 },
        { key: 4, text: '무악재', value: 4 },
    ]
    const [selectedOption, setSelectedOption] = useState(dropdownOptions[0]);

    const navigate  = useNavigate();

    function handleLogoClick() {
        navigate("/Logo");
    }
    function handleDropdownChange(selected) {
        setSelectedOption(selected);
    }

    return (
        <Menu  converted style={{ fontFamily: 'TheJamsil5Bold' }}   >
            <Link to="/" className="logo" onClick={handleLogoClick}>
                <img src={logo} alt="Logo" position='left' style={{ marginRight: '1.5em' }} />
            </Link>
            <Menu.Item
                name='블랑 소개'
                active={activeItem === 'introduce'}
                onClick={handleItemClick}
            />
            <Menu.Menu position='left'>
                <Dropdown item text='지점안내'>
                    <Dropdown.Menu>
                        {dropdownOptions.map(({key, text, value}) => (
                            <Dropdown.Item
                                key={key}
                                name={value}
                                onClick={handleDropdownItemClick}
                            >
                                {text}
                            </Dropdown.Item>
                        ))}
                    </Dropdown.Menu>
                </Dropdown>
            </Menu.Menu>
            <Menu.Item
                name='블랑EVENT'
                active={activeItem === 'event'}
                onClick={handleItemClick}
            />
            <Menu.Menu position='right'>
                <Menu.Item
                    name='LOGIN'
                    active={activeItem === 'LOGIN'}
                    onClick={() => window.location.href="/login"}
                    />
            </Menu.Menu>
        </Menu>
    );
}

export default Header;
