import Vue from 'vue'
import Vuex from 'vuex'
import auth from '@/store/modules/auth'
import track from '@/store/modules/track'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    auth,
    track
  }
})
