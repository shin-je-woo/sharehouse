import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Button, Form,Checkbox } from 'semantic-ui-react'

const HousesBase = () => {
    
    //입력변수
    const [name, setName] = useState("");
    const [sex, setSex] = useState("");
    //아이디
    const [userName, setUserName] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [address, setAddress] = useState("");
    const [phone, setPhone] = useState("");
    //validation 체크
    const [userNameError, setUserNameError] = useState(false);
    const [passwordError, setPasswordError] = useState(false);
    const [confirmPasswordError, setConfirmPasswordError] = useState(false);
    
    //API호출
    const onChangeUserName = (e) => {
        const userIdRegex = /^[A-Za-z0-9+]{5,}$/;
        if ((!e.target.value || (userIdRegex.test(e.target.value)))) setUserNameError(false);
        else setUserNameError(true);
        setUserName(e.target.value);
    };

    const onChangePassword = (e) => {
        const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
        if ((!e.target.value || (passwordRegex.test(e.target.value)))) setPasswordError(false);
        else setPasswordError(true);

        if (!confirmPassword || e.target.value === confirmPassword) setConfirmPasswordError(false);
        else setConfirmPasswordError(true);
        setPassword(e.target.value);
    };
    const onChangeConfirmPassword = (e) => {
        if (password === e.target.value) setConfirmPasswordError(false);
        else setConfirmPasswordError(true);
        setConfirmPassword(e.target.value);
    };
    const handleSubmit = (event) => {
        event.preventDefault();
        fetch('/houses', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json;charset=utf-8' },
            body: JSON.stringify({
                username:userName,
                sex:sex,
                name:name,
                address:address,
                password:password,
                phone:phone,
            }),
        })
            .then(res => res.json())
            .then(data => console.log(data));
    };

    return (
        <Form onSubmit={handleSubmit} >
                <Form.Field>
                    <label htmlFor="name">사용자 이름</label>
                    <input type="text" id="name" value={name} onChange={(e) => setName(e.target.value)} />
                </Form.Field>
                    <Form.Field>
                        <Checkbox
                            radio
                            label='남성'
                            name='checkboxRadioGroup'
                            value='m'
                            checked={sex === 'm'}
                            onChange={(e, data) => setSex(data.value)}
                        />
                        <Checkbox
                            radio
                            label='여성'
                            name='checkboxRadioGroup'
                            value='w'
                            checked={sex === 'w'}
                            onChange={(e, data) => setSex(data.value)}
                        />
                    </Form.Field>
                <Form.Field>
                    <label htmlFor="id">아이디</label>
                    <input type="text" id="userName" value={userName} onChange={onChangeUserName} maxLength={20} />
                    {userNameError && <div style={{color:'red'}} class="invalid-input">아이디는 최소 5글자 이상 20글자 이하의 영문 및 숫자가 포함되어야 합니다.</div>}
                </Form.Field>
                <Form.Field>
                    <label htmlFor="address">주소</label>
                    <input type="text" id="address" value={address} onChange={(e) => setAddress(e.target.value)} />
                </Form.Field>
                <Form.Field>
                    <label htmlFor="password">비밀번호</label>
                    <input type="password" id="password" value={password} onChange={onChangePassword} maxLength={20} />
                    {passwordError && <div style={{color:'red'}} class="invalid-input">비밀번호는 최소 8글자 이상이여야 하고 최소 한글자 이상의 영문 및 숫자가 포함되어야 합니다. </div>}
                </Form.Field>
               <Form.Field>
                <label htmlFor="password">비밀번호 확인</label>
                <input type="password" id="confirmPassword" value={confirmPassword} onChange={onChangeConfirmPassword} maxLength={20} />
                   {confirmPasswordError && <div style={{color:'red'}} class="invalid-input">비밀번호가 맞지 않습니다.</div>}
                </Form.Field>
                <Form.Field>
                    <label htmlFor="phone">휴대전화</label>
                    <input type="text" id="phone" value={phone} onChange={(e) => setPhone(e.target.value)} />
                    <div style={{color: 'grey'}} className="invalid-input">" - "제외 휴대전화 번호 입력</div>
               </Form.Field>
                <br/>
                <Button type="submit">가입하기</Button>
            <p>
                이미 계정이 있으신가요? <Link to="/login">로그인</Link>
            </p>
        </Form>
    );
};

export default HousesBase;