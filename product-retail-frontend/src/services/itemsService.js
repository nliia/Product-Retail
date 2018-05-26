import api from '@/services/api'

export default {
  removeItem (id) {
    return api().post(`item/delete/${id}`)
  },
  addItem (credentials) {
    return api().post('item', credentials)
  },
  addItemImage (image) {
    return api().post('image', image)
  },
  getItemImage (id) {
    return api().get(`image/${id}`)
  },
  orderItem (credentials) {
    return api().post('order', credentials)
  }
}
