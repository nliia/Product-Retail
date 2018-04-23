<template>
    <div>
      <md-app-content>
          <div class="titles">
            <p>Сотрудники</p>
            <p>Главная / Магазины / Магазин 1 / Сотрудники</p>
            <md-button class="md-raised add-btn">ДОБАВИТЬ</md-button>
          </div>
          <section class="blocks">
              <div v-for="worker in workers" :key="worker.id" class="block">
                  <div class="worker-info">
                      <div class="worker">
                          <img src="../../static/photo.png">
                          <p>{{ worker.role }}</p>
                      </div>
                      <div class="info">
                          <p class="name">{{ worker.name }} {{ worker.surname }} {{ worker.username }}</p>
                          <br>
                          <p>Магазин 1</p>
                          <p>Адрес магазина</p>
                          <p>{{ worker.phoneNumber }}</p>
                      </div>
                  </div>
                  <md-divider></md-divider>
                  <div class="btns">
                      <md-button>Редактировать</md-button>
                      <md-button>Удалить</md-button>
                  </div>
              </div>
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
