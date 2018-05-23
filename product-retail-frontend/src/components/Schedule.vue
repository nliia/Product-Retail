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
          <section class="calendar" id="calendar">
            <calendar-view
                :show-date="showDate"
                @show-date-change="setShowDate"
                class="holiday-us-traditional holiday-us-official">
            </calendar-view>
        </section>
        <md-dialog :md-active.sync="showDialog">
          <md-dialog-title>Добавление смены</md-dialog-title>
          <md-field>
            <label>Сотрудник</label>
            <md-input v-model="worker"></md-input>
          </md-field>
          <md-button @click="addShift">Добавить</md-button>
        </md-dialog>
      </md-app-content>
    </div>
</template>

<script>
import CalendarView from 'vue-simple-calendar'
import store from '../store/store'
import { eventBus } from '../main'

var current = null

window.onload = function () {
  var body = document.getElementById('calendar')
  body.onclick = function (event) {
    current = event.target
    if (current.classList.value === 'content') {
      openDialog()
      current.innerHTML += '<div class="empty"></div>'
    }
  }
}

function openDialog () {
  eventBus.$emit('showDialog', true)
}

export default {
  data: () => ({
    showDate: new Date(),
    showDialog: false,
    worker: ''
  }),
  components: {
    CalendarView
  },
  created () {
    eventBus.$on('showDialog', (showDialog) => {
      this.showDialog = showDialog
    })
  },
  computed: {
    currentDepartment: () => {
      return store.getters.currentDepartment
    }
  },
  methods: {
    setShowDate (d) {
      this.showDate = d
    },
    openDialog () {
      eventBus.$emit('showDialog', true)
    },
    addShift () {
      current.innerHTML += '<div class="shift">' + this.worker + '</div>'
    }
  }
}
</script>

<style lang='scss' scoped>
    @import url('vue-simple-calendar/dist/static/css/default.css');
    @import url('vue-simple-calendar/dist/static/css/holidays-us.css');
</style>
