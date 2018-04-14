import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {}
  },
  plugins: [createPersistedState()],
  mutations: {
    set (state, payload) {
      state[payload.type] = payload.item
    }
  },
  actions: {
    signIn (context, payload) {
      context.commit('set', payload)
    }
  },
  getters: {
    token: state => {
      return state.user.token
    }
  }
})
