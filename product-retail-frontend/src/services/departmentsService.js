import api from '@/services/api'

export default {
  getUserDepartments () {
    return api().get('department')
  },
  getItemsByDepartment (id) {
    return api().get(`department/${id}/items`)
  },
  getDepartmentTasks (id) {
    return api().get(`department/${id}/tasks`)
  },
  getDepartmentWorkers (id) {
    return api().get(`department/${id}/workers`)
  },
  getAllDepartments () {
    return api().get('')
  }
}
