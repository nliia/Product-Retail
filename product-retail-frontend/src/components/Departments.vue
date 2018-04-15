<template>
  <transition name="slide">
    <div>
      <md-table md-card>
        <md-table-row v-for="dep in departments" :key="dep.id">
          <md-table-cell>
            <md-icon v-if="dep.warehouse">local_shipping</md-icon>
            <md-icon v-else>shopping_cart</md-icon>
            </md-table-cell>
          <md-table-cell class="text-left">
            <span class="md-body-1">{{ dep.name }}</span><br/>
            <span class="md-caption">{{ dep.address }}</span>
            </md-table-cell>
          <md-table-cell>
            <md-button class="md-primary">Сотрудники</md-button>
            <md-button class="md-primary">График работы</md-button>
            <md-button class="md-primary">Товары</md-button>
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
