<template>
  <div>
    <md-app-content>
      <div class="titles">
        <p>Товары</p>
        <p>Главная / Магазины / Магазин 1 / Товары</p>
        <md-button class="md-raised add-btn">ДОБАВИТЬ</md-button>
      </div>
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
    </md-app-content>
  </div>
</template>

<script>
import departmentsService from '../services/departmentsService'

export default {
  data: () => ({
    items: {}
  }),
  created () {
    this.fetchData()
  },
  watch: {
    '$route': 'fetchData'
  },
  methods: {
    async fetchData () {
      const response = await departmentsService.getItemsByDepartment(this.$route.params.id)
      this.items = response.data.responseData
    }
  }
}
</script>
