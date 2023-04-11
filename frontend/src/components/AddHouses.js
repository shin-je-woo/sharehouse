import React, { Component } from "react";
import { Link  } from "react-router-dom";
import {Menu} from 'semantic-ui-react'
import HousesBase from "./houses/HousesBase";


const colors = [
    'black',
]



class ExampleMenu extends Component {
    state = { activeItem: 'home' }

    handleItemClick = (e, { name }) => this.setState({ activeItem: name })
    handleClick = () => {
        // 클릭 이벤트 처리
    };
    render() {
        const { color } = this.props
        const { activeItem } = this.state


        return (
            <Menu color={color} widths={3} converted style={{fontFamily: 'TheJamsil5Bold'}}>
                <Menu.Item
                   /* name='기본정보'
                    active={activeItem === 'home'}
                    onClick={this.handleClick}*/
                >
                    <Link to="/housesBase" onClick={this.handleClick}>기본정보</Link>
                </Menu.Item>
                <Menu.Item
                    name='상세정보'
                    active={activeItem === 'messages'}
                    onClick={this.handleItemClick}
                />
                <Menu.Item
                    name='방정보'
                    active={activeItem === 'friends'}
                    onClick={this.handleItemClick}
                />
            </Menu>
        );
    }
}
const AddHouses = () => {
    
    const menus = colors.map((color) => <ExampleMenu color={color} key={color} />)

    return(
        <div>{menus}</div>
    )
    /*<p>
        이미 계정이 있으신가요? <Link to="/login">로그인</Link>
    </p>*/

};

export default AddHouses;