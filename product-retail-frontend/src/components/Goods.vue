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
        <md-button class="md-raised button" @click="openDialog" v-show="(role === 'Менеджер магазина') || (role === 'Директор склада')">ДОБАВИТЬ</md-button>
      </div>
      <md-progress-spinner md-mode="indeterminate" v-if="loading" class="spinner"></md-progress-spinner>
      <div v-else>
        <section class="cards">
          <md-card v-for="item in items" :key="item.id" class="card">
            <md-card-header>
              <md-card-media>
                <!-- <img src="../assets/images/item.svg" class="card__photo" v-if="item.itemImageId"> -->
                <img src="../assets/images/no-image.svg" class="card__photo">
              </md-card-media>
              <md-card-header-text class="card__header">
                <div class="md-body-2">{{ item.name }}</div>
                <br/>
                <div class="md-body-1">Количество: {{ item.count }}</div>
                <div class="md-body-1">Цена: {{ item.price }} руб.</div>
              </md-card-header-text>
            </md-card-header>
            <md-card-actions v-show="role === 'Продавец'">
              <md-field>
                <md-input v-model="item.quantity" type="number" placeholder="Количество"></md-input>
              </md-field>
              <md-button class="card__button" @click="sellItem(item.id, item.quantity)">Продать</md-button>
            </md-card-actions>
            <md-card-actions class="ship__actions" v-show="role === 'Работник склада'">
              <select class="ship__select" v-model="item.depId">
                <option v-for="department in departments" :key="department.id" :value="department.id">{{ department.name }}</option>
              </select>
              <md-field>
                <md-input v-model="item.quantity" type="number" placeholder="Количество"></md-input>
              </md-field>
              <md-button class="card__button" @click="shipItem(item.id, item.quantity, item.depId)">Отгрузить</md-button>
            </md-card-actions>
            <md-card-actions v-show="role === 'Менеджер магазина'">
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
  name: 'Goods',
  components: {
    addItemDialog,
    orderItemDialog
  },
  data: () => ({
    items: {},
    departments: {},
    loading: false
  }),
  created () {
    this.fetchData()
    this.getAllDepartments()
  },
  computed: {
    currentDepartment: () => {
      return store.getters.currentDepartment
    },
    role: () => {
      return store.getters.role
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
      // for (let item of this.items) {
      //   if (item.itemImageId) {
      //     this.getItemImage(item.itemImageId)
      //   }
      // }
    },
    // async getItemImage (id) {
    //   const response = await itemsService.getItemImage(id)
    // },
    async getAllDepartments () {
      const response = await departmentsService.getAllDepartments()
      this.departments = response.data.responseData
    },
    async removeItem (id) {
      const response = await itemsService.removeItem(id)
      if (response.status === 200) {
        this.fetchData()
      }
    },
    async sellItem (itemId, quantity) {
      var credentials = {
        itemCount: quantity,
        itemId: itemId
      }
      const response = await itemsService.sellItem(credentials)
      if (response.status === 200) {
        this.fetchData()
      }
    },
    async shipItem (itemId, quantity, depId) {
      var credentials = {
        destinationDepartmentId: depId,
        itemCount: quantity,
        itemId: itemId
      }
      const response = await itemsService.shipItem(credentials)
      if (response.status === 200) {
        this.fetchData()
      }
    },
    openDialog () {
      eventBus.$emit('showDialog', true)
    }
  }
}
</script>

<style lang="scss" scoped>
.ship {
  &__actions {
    flex-wrap: wrap;
  }

  &__select {
    width: 100%;
  }
}
</style>
