import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {},
    department: {}
  },
  plugins: [createPersistedState()],
  mutations: {
    set (state, payload) {
      state[payload.type] = payload.item
    }
  },
  actions: {
    setUser (context, payload) {
      context.commit('set', payload)
    },
    setCurrentDepartment (context, payload) {
      context.commit('set', payload)
    }
  },
  getters: {
    token: state => {
      return state.user.token
    },
    departments: state => {
      return state.user.accessible_departments
    },
    user: state => {
      return state.user
    },
    currentDepartment: state => {
      return state.department
    },
    role: state => {
      return state.user.role
    }
  }
})
