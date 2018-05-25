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
            </div>
            <div class="form-container">
                <div class="photo-download">
                    <img src="../assets/images/person.svg"><br>
                    <div class="upload">
                        <button class="upload__button md-raised button download-button md-theme-default">ЗАГРУЗИТЬ ФОТО</button>
                        <input type="file" @change="imagePreview"/>
                    </div>
                    <md-button class="button delete-button">УДАЛИТЬ ФОТО</md-button>
                </div>
                <div class="form-worker">
                    <div>
                        <form novalidate class="md-layout" @submit.prevent="validateUser">
                            <md-field>
                                <label>Имя</label>
                                <md-input/>
                           </md-field>

                            <md-field>
                                <label>Фамилия</label>
                                <md-input/>
                            </md-field>

                            <md-field>
                                <label>Должность</label>
                                <md-input/>
                            </md-field>

                            <md-field>
                                <label>Email</label>
                                <md-input type="email"/>
                            </md-field>

                            <md-field>
                                <label>Номер телефона</label>
                                <md-input/>
                            </md-field>
                        </form>
                    </div>
                    <md-button class="md-raised button" @click="openDialog">СОХРАНИТЬ</md-button>
                </div>
            </div>
        </md-app-content>
    </div>
</template>

<script>
import addItemDialog from '../components/AddItem'
import orderItemDialog from '../components/Order'
import store from '../store/store'
import {required, email, minLength, maxLength} from 'vuelidate/lib/validators'
import itemsService from '../services/itemsService'

export default {
  components: {
    addItemDialog,
    orderItemDialog
  },
  data: () => ({
    items: {},
    loading: false,
    form: {
      firstName: null,
      lastName: null,
      gender: null,
      age: null,
      email: null
    },
    userSaved: false,
    sending: false,
    lastUser: null,
    showDialog: false,
    item: {
      name: '',
      price: '',
      image: ''
    }
  }),
  created () {
    this.fetchData()
  },
  computed: {
    currentDepartment: () => {
      return store.getters.currentDepartment
    }
  },
  validations: {
    form: {
      firstName: {
        required,
        minLength: minLength(3)
      },
      lastName: {
        required,
        minLength: minLength(3)
      },
      age: {
        required,
        maxLength: maxLength(3)
      },
      gender: {
        required
      },
      email: {
        required,
        email
      }
    }
  },
  methods: {
    getValidationClass (fieldName) {
      const field = this.$v.form[fieldName]

      if (field) {
        return {
          'md-invalid': field.$invalid && field.$dirty
        }
      }
    },
    clearForm () {
      this.$v.$reset()
      this.form.firstName = null
      this.form.lastName = null
      this.form.age = null
      this.form.gender = null
      this.form.email = null
    },
    saveUser () {
      this.sending = true

      // Instead of this timeout, here you can call your API
      window.setTimeout(() => {
        this.lastUser = `${this.form.firstName} ${this.form.lastName}`
        this.userSaved = true
        this.sending = false
        this.clearForm()
      }, 1500)
    },
    validateUser () {
      this.$v.$touch()

      if (!this.$v.$invalid) {
        this.saveUser()
      }
    },
    imagePreview (event) {
      let input = event.target
      if (input.files && input.files[0]) {
        let reader = new FileReader()
        reader.onload = (e) => {
          this.item.image = e.target.result
        }
        reader.readAsDataURL(input.files[0])
      }
    },
    // @todo: доделать, когда бд заработает
    async addItem () {
      try {
        var credentials = {
          name: this.item.name,
          price: this.item.price
        }
        const response = await itemsService.addItem(credentials)
        console.log(response)
      } catch (error) {
        // @todo: alert
        console.log(error.response.data.message)
      }
    }
  }
}
</script>
