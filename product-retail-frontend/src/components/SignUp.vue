<template>
    <transition name="slide">
        <div class="sign">
            <div class="container sign__form">
                <div class="row justify-content-md-center">
                    <div class="col-xs-12 col-sm-8 col-md-6 col-lg-4">
                        <div class="md-headline">РЕГИСТРАЦИЯ</div>
                        <md-field :class="{'md-invalid': errors.has('email')}">
                            <label>Email</label>
                            <md-input name="email" v-model="user.email" v-validate="'required|email'" data-vv-name="email"></md-input>
                        </md-field>
                        <md-field :class="{'md-invalid': errors.has('password')}">
                            <label>Пароль</label>
                            <md-input name="password" type="password" v-model="user.password" v-validate="'required'"></md-input>
                        </md-field>
                        <md-field :class="{'md-invalid': errors.has('passwordConfirmation')}">
                            <label>Повторите пароль</label>
                            <md-input name="passwordConfirmation" type="password" v-model="user.password_confirmation" v-validate="'required|confirmed:password'"></md-input>
                        </md-field>
                        <md-button class="md-raised md-yellow" @click="signUp" :disabled="errors.any()">Создать аккаунт</md-button>
                        <router-link to="login">
                            <div class="link">Войти</div>
                        </router-link>
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
      password: '',
      password_confirmation: ''
    }
  }),
  methods: {
    async signUp () {
      try {
        var credentials = {
          username: this.user.email,
          password: this.user.password
        }
        const response = await authService.signUp(credentials)
        localStorage.token = response.data.token
        this.$router.push({ name: 'hello' })
      } catch (error) {
        console.log(error.response.data.message)
      }
    }
  }
}
</script>

<style lang='scss' scoped>
  .md-button {
    font-size: 18px;
  }

  .link {
    font-size: 18px;
    color: black;
    margin-top: 20px;

    &:hover {
      text-decoration: underline #F7D354;
    }
  }
</style>
