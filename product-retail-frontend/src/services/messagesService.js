import api from '@/services/api'

export default {
  getUsersToSend () {
    return api().get('can-write')
  },
  getMessages (userId) {
    return api().get(`messages/${userId}`)
  },
  sendMessage (credentials) {
    return api().post('send', credentials)
  }
}
