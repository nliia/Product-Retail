import api from '@/services/api'

export default {
  addUser (credentials) {
    return api().post('user', credentials)
  }
}
