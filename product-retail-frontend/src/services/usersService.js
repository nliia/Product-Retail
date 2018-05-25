import api from '@/services/api'

export default {
  addUser () {
    return api().post('user')
  }
}
