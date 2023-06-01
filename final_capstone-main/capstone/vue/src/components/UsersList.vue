<template>
    <div>
        <h1> Users Lists: </h1>
            <table>
                <thead>
                    <tr>
                        <th> User Role</th>
                        <th> User First Name</th>
                        <th> User Last Name</th>
                        <th> User Email</th>
                        <th> User Phone Number </th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="user in users" v-bind:key="user.id">
                        <td> {{user.role }}</td>
                        <td> {{user.username }}</td>
                        <td> {{user.password }}</td>    
                        <td> {{user.emailAddress}}</td>
                        <td> {{user.phoneNumber}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
</template>

<script>

import UserService from '../services/UserService.js';


export default {
    name: 'Users',
    data(){
        return {
            users: [],
        }
    },
    methods: {
        getUsers(){
            UserService.getUsers().then((response) => {
                this.users = response.data;   
            });
        }
    },
    created() {
        this.getUsers();
    }
}

</script>

<style>

</style>

