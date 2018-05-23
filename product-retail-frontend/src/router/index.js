import Vue from 'vue'
import Router from 'vue-router'
import SignIn from '@/components/SignIn'
import Departments from '@/components/Departments'
import Workers from '@/components/Workers'
import Schedule from '@/components/Schedule'
import Goods from '@/components/Goods'
import Tasks from '@/components/Tasks'
import Messages from '@/components/Messages'
import AddWorker from '@/components/AddWorker'
import store from '../store/store'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'departments',
      component: Departments,
      beforeEnter (to, from, next) {
        if (store.getters.token === undefined) {
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
        if (store.getters.token === undefined) {
          next()
        } else {
          next('/')
        }
      }
    },
    {
      path: '/:id/workers',
      name: 'workers',
      component: Workers,
      beforeEnter (to, from, next) {
        if (store.getters.token === undefined) {
          next('/login')
        } else {
          next()
        }
      }
    },
    {
      path: '/:id/schedule',
      name: 'schedule',
      component: Schedule,
      beforeEnter (to, from, next) {
        if (store.getters.token === undefined) {
          next('/login')
        } else {
          next()
        }
      }
    },
    {
      path: '/:id/goods',
      name: 'goods',
      component: Goods,
      beforeEnter (to, from, next) {
        if (store.getters.token === undefined) {
          next('/login')
        } else {
          next()
        }
      }
    },
    {
      path: '/:id/tasks',
      name: 'tasks',
      component: Tasks,
      beforeEnter (to, from, next) {
        if (store.getters.token === undefined) {
          next('/login')
        } else {
          next()
        }
      }
    },
    {
      path: '/im',
      name: 'messages',
      component: Messages,
      beforeEnter (to, from, next) {
        if (store.getters.token === undefined) {
          next('/login')
        } else {
          next()
        }
      }
    },
    {
      path: '/addworker',
      name: 'addworker',
      component: AddWorker,
      beforeEnter (to, from, next) {
        if (store.getters.token === undefined) {
          next('/login')
        } else {
          next()
        }
      }
    }
  ]
})
