import Vue from 'vue'
import Router from 'vue-router'
import SignIn from '@/components/SignIn'
import SignUp from '@/components/SignUp'
import HelloUser from '@/components/HelloUser'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'hello',
      component: HelloUser,
      beforeEnter (to, from, next) {
        if (localStorage.token === undefined) {
          next('/login')
        } else {
          next()
        }
      }
    },
    {
      path: '/login',
      name: 'login',
      component: SignIn,
      beforeEnter (to, from, next) {
        if (localStorage.token === undefined) {
          next()
        } else {
          next('/hello')
        }
      }
    },
    {
      path: '/register',
      name: 'register',
      component: SignUp,
      beforeEnter (to, from, next) {
        if (localStorage.token === undefined) {
          next()
        } else {
          next('/hello')
        }
      }
    }
  ]
})
