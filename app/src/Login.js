import React, {Component} from 'react';
import {Button, FormGroup, FormControl} from 'react-bootstrap';

export default class Login extends Component{
    constructor(props) {
        super(props);

        this.state = {
            data: [],
            nickname: "",
            password: ""
        };

        this.validateForm = this.validateForm.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    validateForm() {
        return this.state.nickname.length > 0 && this.state.password.length > 0;
    }

    handleChange = event => {
        this.setState({
            [event.target.id]: event.target.value
        });
    }

    handleSubmit = (event, {history}) => {
        this.state.data.map( function (user ) {
            if (user.nick === this.state.nickname && user.password === this.state.password)
                history.push('/student');
        });
    }

    componentDidMount(){
        fetch('http://localhost:8080/api/users')
            .then(response => response.json())
            .then(data=>{
                console.log(data);
                this.setState({data});
            })
    }

    render() {
        return (
            <div className="Login">
                <form onSubmit={this.handleSubmit}>
                    <FormGroup controlId="text">
                        <p>Username</p>
                        <FormControl
                            autoFocus
                            type="text"
                            value={this.state.nickname}
                            onChange={this.handleChange}
                        />
                    </FormGroup>
                    <FormGroup controlId="password">
                        <p>Password</p>
                        <FormControl
                            value={this.state.password}
                            onChange={this.handleChange}
                            type="password"
                        />
                    </FormGroup>
                    <Button
                        block
                        bsSize="large"
                        disabled={!this.validateForm()}
                        type="submit"
                    >
                        Login
                    </Button>
                </form>
            </div>
        );
    }
}