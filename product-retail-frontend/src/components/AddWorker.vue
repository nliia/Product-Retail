<template>
    <div>
        <md-app-content>
            <div class="breadcrumbs">
                <div class="breadcrumbs__item">
                    <p class="breadcrumbs__item-large">Добавление сотрудника</p>
                    <div>
                        <router-link to="/" class="breadcrumbs__link">Главная</router-link> /
                        <span v-if="currentDepartment.warehouse">Склады</span>
                        <span v-else>Магазины</span>
                        / {{ currentDepartment.name }} /
                        <span class="breadcrumbs__item-bold">Добавление сотрудника</span>
                    </div>
                </div>
                <md-button class="md-raised button" @click="addUser">СОХРАНИТЬ</md-button>
            </div>
            <div class="form-container">
                <!-- <div class="photo-download">
                    <img src="../assets/images/person.svg"><br>
                    <div class="upload">
                        <button class="upload__button md-raised button download-button md-theme-default">ЗАГРУЗИТЬ ФОТО</button>
                        <input type="file" @change="imagePreview"/>
                    </div>
                    <md-button class="button delete-button">УДАЛИТЬ ФОТО</md-button>
                </div> -->
              <md-field>
                <label>Имя</label>
                <md-input v-model="user.name" ></md-input>
              </md-field>
              <md-field>
                <label>Фамилия</label>
                <md-input v-model="user.surname" ></md-input>
              </md-field>
              <md-field>
                <label>Должность</label>
                <md-select v-model="user.role">
                  <md-option value="STUFF_MANAGER" v-show="!currentDepartment.warehouse">Менеджер магазина</md-option>
                  <md-option value="SELLER" v-show="!currentDepartment.warehouse">Продавец</md-option>
                  <md-option value="WAREHOUSE_WORKER" v-show="currentDepartment.warehouse">Работник склада</md-option>
                </md-select>
              </md-field>
              <md-field>
                <label>Логин</label>
                <md-input v-model="user.username" ></md-input>
              </md-field>
               <md-field :class="{'md-invalid': errors.has('password')}">
                <label>Пароль</label>
                <md-input name="password" type="password" v-model="user.password" v-validate="'required|min:6'"></md-input>
              </md-field>
              <md-field>
                <label>Номер телефона</label>
                <md-input v-model="user.phone" ></md-input>
              </md-field>
            </div>
        </md-app-content>
    </div>
</template>

<script>
import store from '../store/store'
import usersService from '../services/usersService'

export default {
  data: () => ({
    user: {
      name: '',
      password: '',
      phone: '',
      role: '',
      surname: '',
      username: ''
    }
  }),
  computed: {
    currentDepartment: () => {
      return store.getters.currentDepartment
    }
  },
  methods: {
    async addUser () {
      try {
        let credentials = {
          department_id: +this.$route.params.id,
          name: this.user.name,
          password: this.user.password,
          phoneNumber: this.user.phone,
          role: this.user.role,
          is_superuser: false,
          superuser: false,
          surname: this.user.surname,
          username: this.user.username,
          status: 'working'
        }
        const response = await usersService.addUser(credentials)
        if (response.status === 200) {
          this.$router.push({name: 'workers', params: { id: +this.$route.params.id }})
        }
      } catch (error) {
        console.log(error)
      }
    }
  }
}
</script>
