import React, {Component} from 'react';
import {Button} from 'react-bootstrap';

export default class Login extends Component{
    constructor(props){
        super(props);
        this.state = { username: '', password: '', data:[] };
    }

    handleChange = ({ target }) => {
        this.setState({ [target.name]: target.value });
    };


    validateForm() {
        return this.state.username.length > 0 && this.state.password.length > 0;
    }


    handleSubmit = (event) => {
        this.state.data.map( (user) => {
            if (user.email === this.state.username && user.password === this.state.password)
            {
               this.props.history.push("/student");
            }
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
            <React.Fragment>
                <h3>Enter your data</h3>
                <form>
                    <label htmlFor="username">Email:</label>
                    <input
                        type="text"
                        name="username"
                        value={this.state.username}
                        onChange={this.handleChange}
                    />

                    <label htmlFor="password">Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={this.state.password}
                        onChange={this.handleChange}
                    />
                </form>

                <Button type="submit" disabled={!this.validateForm()} onClick={this.handleSubmit}>Login</Button>
            </React.Fragment>
        );
    }
}