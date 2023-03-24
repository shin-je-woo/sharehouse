// Header.js

import React, { useState } from "react";
import "../css/Header.css";
import { Dropdown, Menu,Grid } from 'semantic-ui-react'



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
    function handleDropdownChange(selected) {
        setSelectedOption(selected);
    }

    return (
        <Menu pointing secondary >
            <Menu.Item
                name='블랑 소개'
                active={activeItem === 'introduce'}
                onClick={handleItemClick}
            />
            <Menu.Menu position='left'>
                <Dropdown item text='지점안내'>
                    <Dropdown.Menu>
                        {dropdownOptions.map(({ key, text, value }) => (
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
        </Menu>
    );
}

export default Header;
