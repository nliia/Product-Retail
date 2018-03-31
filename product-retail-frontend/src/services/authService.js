import api from '@/services/api'

export default {
  signUp (credentials) {
    return api().post('sign_up', credentials)
  },
  signIn (credentials) {
    return api().post('sign_in', credentials)
  }
}
