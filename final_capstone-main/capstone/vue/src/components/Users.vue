<template>
    <div class = "container">
            
            <h1 class = "text-center"> Users List</h1>

            <table>
                <thead>
                    <tr>
                        <th> User Id</th>
                        <th> User First Name</th>
                        <th> User Last</th>
                        <th> User Email</th>
                    </tr>

                </thead>
                <tbody>
                    <tr v-for="user in Users" v-bind:key="user.id">
                        <td> {{user.id }}</td>
                        <td> {{user.firstName }}</td>
                        <td> {{user.lastName}}</td>    
                        <td> {{user.email}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
</template>

<script>

import AuthService from '../services/AuthService.js';

export default {
    name: 'Users',
    data(){
        return {
            users: []
        }
    },
    methods: {
        getUsers(){
            AuthService.getUsers().then((response) => {
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