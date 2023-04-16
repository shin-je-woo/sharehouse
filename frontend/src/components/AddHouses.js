import React, { Component,useState } from "react";
import {Button, Form, Menu} from 'semantic-ui-react'






const AddHouses = () => {

    const [menu, setMenu] = useState("base");
    const [name, setName] = useState("");
    const [acceptedGender, setAcceptedGender] = useState("");
    const [address, setAddress] = useState("");
   const handleClick = (menuName) => {
        setMenu(menuName);
    };
    const buttonClick = (gender) => {
        setAcceptedGender(gender);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        fetch('/houses', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json;charset=utf-8' },
            body: JSON.stringify({
                name:name,
                acceptedGender:acceptedGender,
                address:address,
            }),
        })
            .then(res => res.json())
            .then(data => console.log(data));
    };

    return(
        <div>
                <Menu widths={3} converted style={{fontFamily: 'TheJamsil5Bold'}}>
                    <Menu.Item
                        name='기본정보'
                        onClick={() =>  handleClick("base")}
                    />

                    <Menu.Item name='상세정보'
                               onClick={() =>  handleClick("detail")}
                    />
                    <Menu.Item name='방정보'
                               onClick={() =>  handleClick("rooms")}
                    />
                </Menu>
            {/*기본정보*/}
                {menu === "base" && (

                    <Form >
                        <Form.Field>
                            <label htmlFor="name">하우스이름</label>
                            <input type="text" id="name" value={name} onChange={(e) => setName(e.target.value)} />
                        </Form.Field>
                        <Form.Field>
                            <label htmlFor="name">수용 성별</label>
                            <Button
                                label='남성'
                                value='male'
                                onClick={(e, data) => buttonClick(data.value)}
                            />
                            <Button
                                label='여성'
                                value='female'
                                onClick={(e, data) => buttonClick(data.value)}
                            />
                            <Button
                                label='혼성'
                                value='all'
                                onClick={(e, data) => buttonClick(data.value)}
                            />
                        </Form.Field>
                        <Form.Field>
                            <label htmlFor="address">주소</label>
                            <input type="text" id="address" value={address} onChange={(e) => setAddress(e.target.value)} />
                        </Form.Field>
                        <Button onClick={() =>  handleClick("detail")}>다음</Button>
                    </Form>
                )}
            {/*상세정보*/}
                {menu === "detail" && (
                    <Form >
                        <Form.Field>
                            <label htmlFor="name">상세 정보</label>
                        </Form.Field>
                            <Button onClick={() =>  handleClick("base")}>이전</Button>
                            <Button onClick={() =>  handleClick("rooms")}>다음</Button>
                    </Form>
                )}
            {/*방정보*/}
                {menu === "rooms" && (
                    <Form onSubmit={handleSubmit} >
                        <Form.Field>
                            <label htmlFor="name">방 정보</label>
                        </Form.Field>
                            <Button onClick={() =>  handleClick("detail")}>이전</Button>
                            <Button color = "blue" type="submit">등록하기</Button>
                    </Form>
                )}

        </div>

    )

};

export default AddHouses;