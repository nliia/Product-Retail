<template>
  <div>
    <md-app-content>
      <div class="titles">
        <p>Сотрудники</p>
        <p>Главная / Магазины / Магазин 1 / Сотрудники</p>
        <md-button class="md-raised add-btn">ДОБАВИТЬ</md-button>
      </div>
      <section class="cards">
        <md-card v-for="worker in workers" :key="worker.id" class="card">
          <md-card-header>
            <md-card-media>
              <img src="../assets/images/person.svg" class="card__photo">
              <span class="md-body-1">{{ worker.role }}</span>
            </md-card-media>
            <md-card-header-text class="card__header">
              <div class="md-body-2">{{ worker.name }} {{ worker.surname }} {{ worker.username }}</div>
              <br/>
              <div class="md-body-1">Магазин 1</div>
              <div class="md-body-1">Адрес магазина</div>
              <div class="md-body-1">Тел.: {{ worker.phoneNumber }}</div>
            </md-card-header-text>
          </md-card-header>
          <md-divider></md-divider>
          <md-card-actions>
            <md-button class="card__button">Удалить</md-button>
            <md-button class="card__button">Редактировать</md-button>
          </md-card-actions>
        </md-card>
      </section>
    </md-app-content>
  </div>
</template>

<script>
import departmentsService from '../services/departmentsService'

export default {
  data: () => ({
    workers: {}
  }),
  created () {
    this.fetchData()
  },
  watch: {
    '$route': 'fetchData'
  },
  methods: {
    async fetchData () {
      const response = await departmentsService.getDepartmentWorkers(this.$route.params.id)
      this.workers = response.data.responseData
    }
  }
}
</script>
