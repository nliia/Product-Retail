<template>
  <div>
    <md-app-content>
      <div class="breadcrumbs">
        <div class="breadcrumbs__item">
          <p class="breadcrumbs__item-large">Товары</p>
          <div>
            <router-link to="/" class="breadcrumbs__link">Главная</router-link> /
            <span v-if="currentDepartment.warehouse">Склады</span>
            <span v-else>Магазины</span>
            / {{ currentDepartment.name }} /
            <span class="breadcrumbs__item-bold">Товары</span>
          </div>
        </div>
        <md-button class="md-raised button" @click="openDialog">ДОБАВИТЬ</md-button>
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
                <div class="md-body-1">Цена: {{ item.price }} руб.</div>
              </md-card-header-text>
            </md-card-header>
            <md-divider></md-divider>
            <md-card-actions>
              <md-button class="card__button" @click="removeItem(item.id)">Удалить</md-button>
            </md-card-actions>
          </md-card>
        </section>
      </div>
      <add-item-dialog v-if="currentDepartment.warehouse"/>
      <order-item-dialog v-else/>
    </md-app-content>
  </div>
</template>

<script>
import departmentsService from '../services/departmentsService'
import itemsService from '../services/itemsService'
import addItemDialog from '../components/AddItem'
import orderItemDialog from '../components/Order'
import store from '../store/store'
import { eventBus } from '../main'

export default {
  components: {
    addItemDialog,
    orderItemDialog
  },
  data: () => ({
    items: {},
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
      const response = await departmentsService.getItemsByDepartment(this.$route.params.id)
      this.loading = false
      this.items = response.data.responseData
    },
    // @todo: доделать, когда бд заработает
    async removeItem (id) {
      const response = await itemsService.removeItem(id)
      console.log(response)
    },
    openDialog () {
      eventBus.$emit('showDialog', true)
    }
  }
}
</script>
