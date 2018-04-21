<template>
  <div id="app">
    <div class="page-container">
      <md-app>
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
  }
}
</script>

<style lang='scss'>
@import './assets/styles/app.scss';
</style>
