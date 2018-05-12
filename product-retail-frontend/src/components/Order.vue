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
        <md-autocomplete v-model="item.name" :md-options="items">
            <label>Название</label>
        </md-autocomplete>
        <md-field>
            <label>Количество</label>
            <md-input v-model="item.count" type="number"></md-input>
        </md-field>
      </div>
      <md-dialog-actions>
        <md-button class="md-raised md-green" @click="showDialog=false">Сохранить</md-button>
      </md-dialog-actions>
    </md-dialog>
  </div>
</template>

<script>
export default {
  data: () => ({
    showDialog: false,
    item: {
      name: '',
      count: '',
    },
    items: [
        'Огурец',
        'Помидор'
    ]
  }),
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
