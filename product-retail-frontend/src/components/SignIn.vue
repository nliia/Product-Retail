<template>
  <transition name="slide">
    <div class="sign">
      <div class="container sign__form">
        <div class="row justify-content-md-center">
          <div class="col-xs-12 col-sm-8 col-md-6 col-lg-4">
            <div class="md-headline">ВХОД</div>
              <md-field :class="{'md-invalid': errors.has('email')}">
                <label>Email</label>
                <md-input name="email" v-model="user.email" v-validate="'required'" data-vv-name="email"></md-input>
              </md-field>
              <md-field :class="{'md-invalid': errors.has('password')}">
                <label>Пароль</label>
                <md-input name="password" type="password" v-model="user.password" v-validate="'required'"></md-input>
              </md-field>
              <md-button class="md-raised md-green" @click="signIn" :disabled="errors.any()">Войти</md-button>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
import authService from '../services/authService'

export default {
  data: () => ({
    user: {
      email: '',
      password: ''
    }
  }),
  methods: {
    async signIn () {
      try {
        var credentials = {
          username: this.user.email,
          password: this.user.password
        }
        const response = await authService.signIn(credentials)
        this.$store.dispatch('signIn', { type: 'user', item: response.data })
        this.$router.push({ name: 'departments' })
      } catch (error) {
        // @todo: alert
        console.log(error.response.data.message)
      }
    }
  }
}
</script>
