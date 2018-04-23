<template>
    <div>
        <md-app-content>
            <div class="titles">
                <p>Товары</p>
                <p>Главная / Магазины / Магазин 1 / Товары</p>
                <md-button class="md-raised add-btn">ДОБАВИТЬ</md-button>
            </div>
            <section class="blocks">
                <div v-for="item in items" :key="item.id" class="block">
                    <div class="product-info">
                        <div class="product">
                            <img src="../../static/product.png">
                        </div>
                        <div class="info">
                            <p class="name">{{ item.name }}</p>
                            <br>
                            <p>Количество: <span>{{ item.count }}</span></p>
                            <p>Цена: <span>150</span> руб.</p>
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
      console.log(this.items)
    }
  }
}
</script>
