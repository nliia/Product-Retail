import api from '@/services/api'

export default {
  removeItem (id) {
    return api().post(`item/delete/${id}`)
  },
  addItem (credentials) {
    return api().post('item', credentials)
  }
}
