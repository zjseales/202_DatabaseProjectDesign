var studentsApi = '/api/students';
var majorsApi = '/api/majors';
var majorsFilterApi = ({major}) => `/api/majors/${major}`;

const app = Vue.createApp({

    data() {
        return {
            // models map (comma separated key/value pairs)
            students: new Array(),
            majors: new Array()
        };
    },

    mounted() {
        // (semicolon separated statements)
        // 
        //call the getStudents() method when the page is loaded/mounted
        this.getStudents();
		  this.getMajors();

    },

    methods: {
        // (comma separated function declarations)
        
        // retrieves the students from the students module
        getStudents() {

            axios.get(studentsApi)
                .then(response => {
                    this.students = response.data;
            })
            .catch(error => {
                console.error(error);
                alert("An error occurred - check the console for details.");
            });
        },
		  
        // click handler for the major filter buttons
	filterByMajor(major) {
            axios.get(majorsFilterApi({'major':major}))
            .then(response => {
                this.students = response.data;
            })
            .catch(error => {
                console.error(error);
                alert("An error occurred - check the console for details.");
            });
	},
		 
		  
        // retrieves the majors from the student module
        getMajors() {

            axios.get(majorsApi)
                .then(response => {
                    this.majors = response.data;
            })
            .catch(error => {
                console.error(error);
                alert("An error occurred - check the console for details.");
            });
        },
        
		  // Retrieves selected student and stores it in the session
        update(student) {
			  // alert(student.name);
           sessionStore.commit('selectStudent', student);
           window.location='view-student-details.html';
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
