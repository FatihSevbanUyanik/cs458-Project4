/* eslint-disable no-unused-vars */
import axios, { URL }  from '@/config/AxiosConfig.js';

const state = {
    accessToken: localStorage.getItem('accessToken') || null,
    user: localStorage.getItem('user') || null,
}

const mutations = {
    setAccessToken(state, payload) {
        state.accessToken = payload;
    }, 
    signOut(state) {
        state.user = null
        state.accessToken = null
        localStorage.removeItem('user')
        localStorage.removeItem('accessToken')
    },
    setCurrentUser(state, payload) {
        state.user = payload;
        localStorage.setItem('user', JSON.stringify(state.user));
    },
    initialiseAuth(state) {
        if (state.user) {
            state.user = JSON.parse(state.user);
        }
    }
}

const actions = {
    signInUser({ commit }, payload) {
        return new Promise((resolve, reject) => {
            axios.post(URL.SIGN_IN, { 
                usernameOrEmail: payload.usernameOrEmail, 
                password: payload.password
            })
            .then(response => {
                const data = response.data
                const accessToken = data.accessToken
                const user = {
                    id: data.id,
                    name: data.name,
                    username: data.username,
                    email: data.email,
                }

                localStorage.setItem('accessToken', accessToken);
                localStorage.setItem('user', JSON.stringify(user));
                commit('setAccessToken', accessToken);
                commit('setCurrentUser', user);
                resolve(response);
            })
            .catch(error => {
                reject(error.response.data);
            });
        });
    },
    signUpUser({ commit }, payload) {
      return new Promise((resolve, reject) => {
         console.log('Register çalıştı')
         axios.post(URL.SIGN_UP, payload)
            .then(response => {
               console.log('Response gelidi')
                resolve(response.data);           
            })
            .catch(error => {
                reject(error);           
            })  
      })
    },
    sendResetPasswordEmail({ commit }, payload) {
        return new Promise((resolve, reject) => {
            axios.post(URL.REQUEST_PASSWORD_RESET, payload)
            .then(response => {
                resolve(response.data);           
            })
            .catch(error => {
                reject(error);           
            })  
        });
    },
    resetPassword({ commit }, payload) {
        return new Promise((resolve, reject) => {
            axios.post(URL.RESET_PASSWORD, { 
                passwordToken: payload.passwordToken,
                password: payload.password,
            })
            .then(response => {
                resolve(response);
            })
            .catch(error => {
                reject(error);
            });
        });
    }
}

const getters = {
    isUserSignedIn(state) {
        return state.accessToken !== null;
    },
    getCurrentUser(state) {
        return state.user;
    }
}

export default {
    state,
    mutations,
    actions,
    getters
}