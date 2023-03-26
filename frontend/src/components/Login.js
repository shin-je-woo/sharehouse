import React , { useState } from "react";
import { Link } from "react-router-dom";
import { Button, Form,Checkbox } from 'semantic-ui-react'

const Login = () => {
    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const handleSubmit = (event) => {
        event.preventDefault();
        fetch('/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json;charset=utf-8' },
            body: JSON.stringify({
                username:userName,
                password:password,
            }),
        })
            .then(res => res.json())
            .then(data => console.log(data));
    };

    return (
        <Form onSubmit={handleSubmit} >
            <Form.Field>
                <label htmlFor="id">아이디</label>
                <input type="text" id="userName" value={userName} onChange={(e) => setUserName(e.target.value)} maxLength={20} />
            </Form.Field>
            <Form.Field>
                <label htmlFor="password">비밀번호</label>
                <input type="password" id="password" value={password} onChange={(e) => setPassword(e.target.value)} maxLength={20} />
            </Form.Field>
            <Button type="submit">로그인</Button>
            <p>
                아이디가 없으신가요? <Link to="/signup">회원가입</Link>
            </p>
        </Form>
    );
};

export default Login;