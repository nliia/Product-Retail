<template>
  <transition name="slide">
    <div>
      <md-table md-card>
        <md-table-row v-for="dep in departments" :key="dep.id">
          <md-table-cell>
            <md-icon class="fa fa-truck" v-if="dep.warehouse"></md-icon>
            <md-icon class="fa fa-shopping-cart" v-else></md-icon>
            </md-table-cell>
          <md-table-cell class="text-left">
            <span class="md-body-1">{{ dep.name }}</span><br/>
            <span class="md-caption">{{ dep.address }}</span>
            </md-table-cell>
          <md-table-cell>
            <router-link :to="{ name: 'workers', params: { id: dep.id }}"><md-button class="md-primary">Сотрудники</md-button></router-link>
            <router-link :to="{ name: 'schedule', params: { id: dep.id }}"><md-button class="md-primary">График работы</md-button></router-link>
            <router-link :to="{ name: 'goods', params: { id: dep.id }}"><md-button class="md-primary">Товары</md-button></router-link>
            <router-link :to="{ name: 'tasks', params: { id: dep.id }}"><md-button class="md-primary">Задачи</md-button></router-link>
          </md-table-cell>
        </md-table-row>
      </md-table>
    </div>
  </transition>
</template>

<script>
import store from '../store/store'

export default {
  computed: {
    departments: () => {
      return store.getters.departments
    }
  }
}
</script>

<style lang='scss' scoped>
  .text-left {
    text-align: left
  }
</style>
