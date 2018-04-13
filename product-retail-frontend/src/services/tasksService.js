import api from '@/services/api'

export default {
  createTask (credentials) {
    return api().post('task', credentials)
  },
  getWorkerTasks (id) {
    return api().get(`tasks${id}`)
  }
}
