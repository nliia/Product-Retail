import api from '@/services/api'

export default {
  fetchEvents () {
    return api().get('schedule')
  }
}
