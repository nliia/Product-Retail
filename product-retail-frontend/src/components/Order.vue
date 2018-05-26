<template>
  <div class="dialog">
    <md-dialog :md-active.sync="showDialog">
      <md-dialog-title>
        Заказ товара
        <span @click="showDialog = false">
            <md-icon class="fa fa-times dialog__close"></md-icon>
        </span>
      </md-dialog-title>
      <div class="dialog__content">
        <md-field>
          <label>Название</label>
          <md-select v-model="item.id">
            <md-option  v-for="i in items" :key="i.d" :value="i.id">{{ i.name }}</md-option>
          </md-select>
        </md-field>
        <md-field>
            <label>Количество</label>
            <md-input v-model="item.count" type="number" min="1"></md-input>
        </md-field>
      </div>
      <md-dialog-actions>
        <md-button class="md-raised md-green" @click="orderItem">Сохранить</md-button>
      </md-dialog-actions>
    </md-dialog>
  </div>
</template>

<script>
import { eventBus } from '../main'
import departmentsService from '../services/departmentsService'
import itemsService from '../services/itemsService'

export default {
  data: () => ({
    showDialog: false,
    item: {
      id: '',
      count: ''
    },
    items: []
  }),
  created () {
    eventBus.$on('showDialog', (showDialog) => {
      this.showDialog = showDialog
    })
    this.fetchData()
  },
  methods: {
    async fetchData () {
      const response = await departmentsService.getItemsByDepartment(this.$route.params.id)
      this.items = response.data.responseData
    },
    async orderItem () {
      try {
        var credentials = [{
          item_id: this.item.id,
          count: this.item.count
        }]
        const response = await itemsService.orderItem(credentials)
        if (response.status === 200) {
          this.showDialog = false
        }
      } catch (error) {
        console.log(error)
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.md-dialog {
    width: 40%;
    overflow-y: auto;
}

.md-dialog-actions {
    padding: 8px 24px;
}

.md-button .md-ripple {
    padding: 0 20px !important;
}
</style>
