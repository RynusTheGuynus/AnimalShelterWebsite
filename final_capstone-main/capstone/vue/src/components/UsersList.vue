<template>
    <div class = "container">
            
            <h1 class = "text-center"> Users List</h1>

            <table class = "table table-striped" >
                <thead>
                    <tr>
                        <th> User Role</th>
                        <th> User First Name</th>
                        <th> User Last Name</th>
                        <th> User Email</th>
                    </tr>

                </thead>
                <tbody>
                    <tr v-for="user in Users" v-bind:key="user.id">
                        <td> {{user.id }}</td>
                        <td> {{user.username }}</td>
                        <td> {{user.lastName}}</td>    
                        <td> {{user.email}}</td>
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
            users: []
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

