import React, {useEffect, useState} from "react";
import {Button, Form, Menu} from 'semantic-ui-react'
import axios from "axios";






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

    const [image, setImage] = useState({
        image_file: "",
        preview_URL: "img/default_image.png",
    });

    let inputRef;

    const saveImage = (e) => {
        e.preventDefault();
        if(e.target.files[0]){
            // 새로운 이미지를 올리면 createObjectURL()을 통해 생성한 기존 URL을 폐기
            URL.revokeObjectURL(image.preview_URL);
            const preview_URL = URL.createObjectURL(e.target.files[0]);
            setImage(() => (
                {
                    image_file: e.target.files[0],
                    preview_URL: preview_URL
                }
            ))
        }
    }

    const deleteImage = () => {
        // createObjectURL()을 통해 생성한 기존 URL을 폐기
        URL.revokeObjectURL(image.preview_URL);
        setImage({
            image_file: "",
            preview_URL: "../images/shareHouseLogo.jpg",
        });
    }

    useEffect(()=> {
        // 컴포넌트가 언마운트되면 createObjectURL()을 통해 생성한 기존 URL을 폐기
        return () => {
            URL.revokeObjectURL(image.preview_URL)
        }
    }, [])

    const sendImageToServer = async () => {
        console.log(image.image_file);
        if (image.image_file) {
            const formData = new FormData()
            formData.append('file', image.image_file);
            await axios.post('/api/image/upload', formData);
            alert("서버에 등록이 완료되었습니다");
            setImage({
                image_file: "",
                preview_URL: "../images/shareHouseLogo.jpg",
            });
        } else {
            alert("사진을 등록하세요!")
        }
    }

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
                        <div style={{float:"left", width:"50%" , padding: "10px 15px"}}>
                            <input type="file" accept="image/*"
                                   onChange={saveImage}
                                // 클릭할 때 마다 file input의 value를 초기화 하지 않으면 버그가 발생할 수 있다
                                // 사진 등록을 두개 띄우고 첫번째에 사진을 올리고 지우고 두번째에 같은 사진을 올리면 그 값이 남아있음!
                                   onClick={(e) => e.target.value = null}
                                   ref={refParam => inputRef = refParam}
                                   style={{display: "none"}}
                            />
                            <img style={{width:"100%"}} src={image.preview_URL}/>
                            <Button style={{float:"right"}} color="blue" variant="contained" onClick={sendImageToServer}>
                                업로드
                            </Button>
                            <Button style={{float:"right"}} color="red" variant="contained" onClick={deleteImage}>
                                삭제
                            </Button>
                            <Button style={{float:"right"}} type="primary" variant="contained" onClick={() => inputRef.click()}>
                                미리보기
                            </Button>


                        </div>
                        <div style={{float:"right" , width:"50%" , padding: "10px 30px"}}>
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
                        </div>
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