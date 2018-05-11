<template>
  <div>
    <md-app-content>
      <div class="breadcrumbs">
        <div class="breadcrumbs__item">
          <p class="breadcrumbs__item-large">Товары</p>
          <breadcrumbs/>
        </div>
        <md-button class="md-raised button">ДОБАВИТЬ</md-button>
      </div>
      <md-progress-spinner md-mode="indeterminate" v-if="loading" class="spinner"></md-progress-spinner>
      <div v-else>
        <section class="cards">
          <md-card v-for="item in items" :key="item.id" class="card">
            <md-card-header>
              <md-card-media>
                <img src="../assets/images/item.svg" class="card__photo">
              </md-card-media>
              <md-card-header-text class="card__header">
                <div class="md-body-2">{{ item.name }}</div>
                <br/>
                <div class="md-body-1">Количество: {{ item.count }}</div>
                <div class="md-body-1">Цена: 150 руб.</div>
              </md-card-header-text>
            </md-card-header>
            <md-divider></md-divider>
            <md-card-actions>
              <md-button class="card__button">Удалить</md-button>
              <md-button class="card__button">Редактировать</md-button>
            </md-card-actions>
          </md-card>
        </section>
      </div>
    </md-app-content>
  </div>
</template>

<script>
import departmentsService from '../services/departmentsService'

export default {
  data: () => ({
    items: {},
    loading: false
  }),
  created () {
    this.fetchData()
  },
  watch: {
    '$route': 'fetchData'
  },
  methods: {
    async fetchData () {
      this.loading = true
      const response = await departmentsService.getItemsByDepartment(this.$route.params.id)
      this.loading = false
      this.items = response.data.responseData
    }
  }
}
</script>
