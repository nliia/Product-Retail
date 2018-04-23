<template>
  <div id="app">
    <div class="page-container">
      <md-app>
        <md-app-toolbar class="toolbar" v-if="$route.path != '/login'">
          <md-icon class="toolbar__item toolbar__icon fa fa-envelope"></md-icon>
          <md-icon class="toolbar__item toolbar__icon fa fa-bell"></md-icon>
          <div class="toolbar__item" @click="logout()">
            <md-icon class="toolbar__icon fa fa-sign-out"></md-icon>
            <span class="toolbar__text">Выйти</span>
          </div>
        </md-app-toolbar>
        <md-app-drawer md-permanent="full" class="menu" v-if="$route.path != '/login'">
          <sidebar/>
        </md-app-drawer>
        <md-app-content>
          <router-view/>
        </md-app-content>
      </md-app>
    </div>
  </div>
</template>

<script>
import Sidebar from '@/components/Sidebar'

export default {
  name: 'App',
  components: {
    Sidebar
  },
  methods: {
    logout () {
      this.$store.dispatch('setUser', { type: 'user', item: {} })
      this.$router.push({ name: 'login' })
    }
  }
}
</script>

<style lang='scss'>
@import './assets/styles/app.scss';
</style>
