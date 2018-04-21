<template>
    <div>
        <md-app-content>
            <div class="toolbar">
                <md-icon class="md-inactive">email</md-icon>
                <md-icon>notifications</md-icon>
                <a><md-icon>forward</md-icon>Войти</a>
            </div>
            <div class="titles">
                <p>График работы</p>
                <p>Главная / Магазины / Магазин 1 / График работы</p>
            </div>
            <section class="calendar-container">
                <calendar-view
                        :show-date="showDate"
                        @show-date-change="setShowDate"
                        class="holiday-us-traditional holiday-us-official"
                ></calendar-view>
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
