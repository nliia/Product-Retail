<template>
  <div>
    <md-app-content>
        <div class="breadcrumbs">
        <div class="breadcrumbs__item">
          <p class="breadcrumbs__item-large">Сотрудники</p>
          <div>
            Главная /
            <span v-if="currentDepartment.warehouse">Склады</span>
            <span v-else>Магазины</span>
            / {{ currentDepartment.name }} /
            <span class="breadcrumbs__item-bold">Сотрудники</span>
          </div>
        </div>
        <md-button class="md-raised button">ДОБАВИТЬ</md-button>
      </div>
      <md-progress-spinner md-mode="indeterminate" v-if="loading" class="spinner"></md-progress-spinner>
      <div v-else>
        <section class="cards">
          <md-card v-for="worker in workers" :key="worker.id" class="card">
            <md-card-header>
              <md-card-media>
                <img src="../assets/images/person.svg" class="card__photo">
              </md-card-media>
              <md-card-header-text class="card__header">
                <div class="md-body-2">{{ worker.name }} {{ worker.surname }}</div>
                <br/>
                <div class="md-body-1">{{ worker.role }}</div>
                <div class="md-body-1">Тел.: {{ worker.phoneNumber }}</div>
              </md-card-header-text>
            </md-card-header>
            <md-divider></md-divider>
            <md-card-actions>
              <md-button class="card__button">Удалить</md-button>
            </md-card-actions>
          </md-card>
        </section>
      </div>
    </md-app-content>
  </div>
</template>

<script>
import departmentsService from '../services/departmentsService'
import store from '../store/store'

export default {
  data: () => ({
    workers: {},
    loading: false
  }),
  created () {
    this.fetchData()
  },
  computed: {
    currentDepartment: () => {
      return store.getters.currentDepartment
    }
  },
  watch: {
    '$route': 'fetchData'
  },
  methods: {
    async fetchData () {
      this.loading = true
      const response = await departmentsService.getDepartmentWorkers(this.$route.params.id)
      this.loading = false
      this.workers = response.data.responseData
    }
  }
}
</script>
