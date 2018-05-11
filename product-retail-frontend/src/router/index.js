import Vue from 'vue'
import Router from 'vue-router'
import SignIn from '@/components/SignIn'
import Departments from '@/components/Departments'
import Workers from '@/components/Workers'
import Schedule from '@/components/Schedule'
import Goods from '@/components/Goods'
import Tasks from '@/components/Tasks'
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
      },
      meta: {
        breadcrumb: (routeParams) => `Главная / ${routeParams.parent} Сотрудники`
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
      },
      meta: {
        breadcrumb: (routeParams) => `Главная / ${routeParams.parent} График работы`
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
      },
      meta: {
        breadcrumb: (routeParams) => `Главная / ${routeParams.parent} Товары`
      }
    },
    {
      path: '/tasks',
      name: 'tasks',
      component: Tasks
    }
  ]
})
