var studentsApi = '/api/students';

const app = Vue.createApp({

    data() {
        return {
            // models map (comma separated key/value pairs)

        };
    },
    
   computed: Vuex.mapState({
      student: 'selectStudent'
   }),
    
    mounted() {
        // semicolon separated statements

    },

    methods: {
        // (comma separated function declarations)
        
        // Performs the update function on the view-student-details page
        updateStudent() {
            axios.post(studentsApi, this.student)
                .then(() => {
                    window.location = 'view-students.html';
                })
                .catch(error => {
                    alert(error.response.data.message);
                });
        }
    },

    // other modules
    mixins: []

});

// other component imports go here

// import the navigation menu
import { navigationMenu } from './navigation-menu.js';
// register the navigation menu under the <navmenu> tag
app.component('navmenu', navigationMenu);

import { sessionStore } from './session-store.js';
app.use(sessionStore);  


// mount the page - this needs to be the last line in the file
app.mount("main");
