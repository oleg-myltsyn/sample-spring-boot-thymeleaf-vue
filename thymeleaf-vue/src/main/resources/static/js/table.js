const table = {
    name: 'custom-table',
    template: `<table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>username</th>
                        <th>email</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr v-for="user in users">
                        <td>{{ user.id }}</td>
                        <td>{{ user.username }}</td>
                        <td>{{ user.email }}</td>
                    </tr>
                    </tbody>
                </table>`,
    data() {
        return {
            users: null
        }
    },
    props: {
        url: String
    },
    mounted() {
        axios
            .get(this.url)
            .then(response => (this.users = response.data.response))
    }
};

export default table;

