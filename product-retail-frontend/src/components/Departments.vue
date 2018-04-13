<template>
  <transition name="slide">
    <div class="container">
      <div class="row">
        <div v-for="dep in departments" :key="dep.id" class="col-xs-12 col-sm-3">
          <md-card md-with-hover>
            <md-ripple>
              <md-card-header>
                <div class="md-title">{{ dep.name }}</div>
                <div class="md-subhead">{{ dep.address }}</div>
              </md-card-header>
              <md-card-content>
                <span v-if="dep.warehouse">Склад</span>
                <span v-else>Магазин</span>
              </md-card-content>
            </md-ripple>
          </md-card>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
import departmentsService from '../services/departmentsService.js'

export default {
  data: () => ({
    departments: []
  }),
  mounted: async function () {
    try {
      const response = await departmentsService.getUserDepartments()
      this.departments = response.data.responseData
    } catch (error) {
      // @todo: alert
      console.log(error.response.data.message)
    }
  }
}
</script>

<style scoped>
</style>
