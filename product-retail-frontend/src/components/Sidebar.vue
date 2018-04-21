<template id="sidebar-template">
    <div>
        <img class="user-info__photo" src="../../static/photo.png">
        <p id="username">{{ user.name }} {{ user.surname }}</p>
        <select class="role">
            <option selected>Владелец</option>
            <option>Сотрудник</option>
        </select>
        <div class="container full-control">
            <md-list>
                <md-list-item md-expand :md-expanded.sync="expandNews">
                    <span class="md-list-item-text">Магазины</span>

                    <md-list slot="md-expand">
                        <md-list-item md-expand>
                            <span class="md-list-item-text md-secondary">Магазин 1</span>

                            <md-list slot="md-expand">
                                <md-list-item class="md-inset">Сотрудники</md-list-item>
                                <md-list-item class="md-inset">График работы</md-list-item>
                                <md-list-item class="md-inset">Товары</md-list-item>
                            </md-list>
                        </md-list-item>

                        <md-list-item md-expand>
                            <span class="md-list-item-text md-secondary">Магазин 2</span>

                            <md-list slot="md-expand">
                                <md-list-item class="md-inset">Сотрудники</md-list-item>
                                <md-list-item class="md-inset">График работы</md-list-item>
                                <md-list-item class="md-inset">Товары</md-list-item>
                            </md-list>
                        </md-list-item>
                    </md-list>
                </md-list-item>

                <md-list-item md-expand>
                    <span class="md-list-item-text">Склады</span>

                    <md-list slot="md-expand">
                        <md-list-item class="md-inset">Склад 1</md-list-item>
                        <md-list-item class="md-inset">Склад 2</md-list-item>
                    </md-list>
                </md-list-item>

            </md-list>
        </div>
    </div>
</template>

<script>
import store from '../store/store'

export default {
  name: 'Sidebar',
  computed: {
    user: () => {
      return store.getters.user
    }
  },
  data () {
        return {
            expandNews: false
        }
  }
}
</script>
