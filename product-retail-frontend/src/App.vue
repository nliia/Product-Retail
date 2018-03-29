<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
@import './assets/styles/common.css';

#app {
  font-family: 'PT Sans', sans-serif !important;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  height: 100%;
}

.slide-enter-active {
  transition: all .5s ease;
}
.slide-leave-active {
  transition: all .5s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slide-enter, .slide-leave-to {
  transform: translateX(30px);
  opacity: 0;
}
</style>
