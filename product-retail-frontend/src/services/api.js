import axios from 'axios'

export default() => {
  return axios.create({
    baseURL: 'https://productretailapi.herokuapp.com/',
    headers: {
      'Authorization': localStorage.token
    }
  })
}
