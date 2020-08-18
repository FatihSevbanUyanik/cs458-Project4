import axios, { URL }  from '@/config/AxiosConfig.js';

const mutations = {}
const getters = {}
const state = {}

const actions = {
   createTrack({ rootState }, payload) {
      return new Promise((resolve, reject) => {
          axios.post(URL.CREATE_TRACK, payload, {
              headers: { 'Authorization': `Bearer ${rootState.auth.accessToken}` }
          })
          .then(response => {
              resolve(response.data);
          })
          .catch(error => {
              reject(error.response);
          });
      });
   },
   retrieveTracks({ rootState }) {
      return new Promise((resolve, reject) => {
         axios.get(URL.RETRIEVE_TRACKS, {
            headers: { 'Authorization': `Bearer ${rootState.auth.accessToken}` }
         })
         .then(response => {
            resolve(response.data);
         })
         .catch(error => {
            reject(error.response);
         });
      });
   },
   deleteTrack({ rootState }, payload) {
      return new Promise((resolve, reject) => {
         axios.delete(URL.DELETE_TRACK, {
            data: payload,
            headers: { 'Authorization': `Bearer ${rootState.auth.accessToken}` }
         })
         .then(response => {
            console.log(response.data)
            resolve(response.data);
         })
         .catch(error => {
            reject(error.response);
         });
      });
   }
}

export default {
   state,
   mutations,
   actions,
   getters
}