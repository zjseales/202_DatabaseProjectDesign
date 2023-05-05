export const sessionStore = Vuex.createStore({

    state () {
        selectedStudent: null;
    },

    mutations: {

        selectStudent(state, student) {
            state.selectStudent = student;
        }

    },

    plugins: [window.createPersistedState({storage: window.sessionStorage})]

});
