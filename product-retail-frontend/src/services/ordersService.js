import api from '@/services/api'

export default {
  createOrder (credentials) {
    return api().post('order', credentials)
  }
}
