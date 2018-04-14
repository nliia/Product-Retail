import axios from 'axios'
import store from '../store/store'

export default() => {
  return axios.create({
    baseURL: 'https://productretailapi.herokuapp.com/',
    headers: {
      'Authorization': store.getters.token
    }
  })
}
