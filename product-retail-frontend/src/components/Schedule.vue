<template>
    <div>
      <md-app-content>
        <div class="breadcrumbs">
          <div class="breadcrumbs__item">
            <p class="breadcrumbs__item-large">График работы</p>
            <breadcrumbs/>
          </div>
        </div>
          <section class="calendar-container">
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

export default {
  name: 'Normal',
  data: () => {
    return {
      showDate: new Date()
    }
  },
  components: {
    CalendarView
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
