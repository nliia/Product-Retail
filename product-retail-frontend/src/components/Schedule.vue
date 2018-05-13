<template>
    <div>
      <md-app-content>
        <div class="breadcrumbs">
          <div class="breadcrumbs__item">
            <p class="breadcrumbs__item-large">График работы</p>
            <div>
              <router-link to="/" class="breadcrumbs__link">Главная</router-link> /
              <span v-if="currentDepartment.warehouse">Склады</span>
              <span v-else>Магазины</span>
              / {{ currentDepartment.name }} /
              <span class="breadcrumbs__item-bold">График работы</span>
            </div>
          </div>
        </div>
          <section class="calendar">
            <calendar-view
                :show-date="showDate"
                @show-date-change="setShowDate"
                class="holiday-us-traditional holiday-us-official">
            </calendar-view>
        </section>
      </md-app-content>
    </div>
</template>

<script>
import CalendarView from 'vue-simple-calendar'
import store from '../store/store'

export default {
  data: () => ({
    showDate: new Date()
  }),
  components: {
    CalendarView
  },
  computed: {
    currentDepartment: () => {
      return store.getters.currentDepartment
    }
  },
  methods: {
    setShowDate (d) {
      this.showDate = d
    }
  }
}
</script>

<style lang='scss' scoped>
    @import url('vue-simple-calendar/dist/static/css/default.css');
    @import url('vue-simple-calendar/dist/static/css/holidays-us.css');
</style>
