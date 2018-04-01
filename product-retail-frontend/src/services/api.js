import axios from 'axios'

export default() => {
  return axios.create({
    baseURL: 'https://productretaill.herokuapp.com/',
    headers: {
      'Content-Type': 'application/json',
      'token': localStorage.token
    }
  })
}
