import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class HoneyBlendsList extends Component{

    constructor(props) {
        super(props);
        this.state = {honeyBlends: []};
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch("/honeyBlends")
            .then(response => response.json())
            .then(data => this.setState({honeyBlends: data}));
    }

    async remove(id) {
        await fetch(`/honeyBlend/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedClients = [...this.state.clients].filter(i => i.id !== id);
            this.setState({clients: updatedClients});
        });
    }

    render() {
        const {honeyBlends, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const honeyBlendsList = honeyBlends.map(honeyBlend => {
            return <tr key={honeyBlend.id}>
                <td style={{whiteSpace: 'nowrap'}}>{honeyBlend.name}</td>
                <td>{honeyBlend.description}</td>
                <td>{honeyBlend.quantity}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" tag={Link} to={"/honeyBlend/" + honeyBlend.id}>Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(honeyBlend.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" tag={Link} to="/honeyBlend/new">Add Honey Blend</Button>
                    </div>
                    <h3>Honey Blends</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="20%">Name</th>
                            <th width="40%">Description</th>
                            <th width="20%">Quantity</th>
                            <th width="20%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {honeyBlendsList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default HoneyBlendsList;

