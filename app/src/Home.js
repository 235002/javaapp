import React, {Component} from 'react';
import {Button} from 'reactstrap';
import {withRouter} from 'react-router-dom';
import { Link } from 'react-router-dom';
import './Home.css';

class Home extends Component{

    render() {
        const loginButton = withRouter(({ history }) => (
            <Button
                className='button'
                onClick={() => { history.push('/login') }}
            >
                Click Me!
            </Button>
        ))

        return(
            <div>
                <p>Application</p>
                <Button className="button"><Link to="/login" className="button">Sign in!</Link></Button>
                <Button className="button">Sign up!</Button>
            </div>
        );
    }
}

export default Home;