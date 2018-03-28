<template>
  <div class="sign">
    <div class="container">
      <div class="row justify-content-md-center">
        <div class="col-sm-12 col-md-6 col-lg-4">
            <md-card>
                <md-card-header>
                    <div class="md-title">Регистрация</div>
                </md-card-header>
                <md-card-content>
                    <md-field>
                        <label>Email</label>
                        <md-input name="email" v-model="user.email" v-validate="'required|email'"></md-input>
                    </md-field>
                    <span v-show="errors.has('email')" class="is-danger">Ошибка</span>
                    <md-field>
                        <label>Пароль</label>
                        <md-input name="password" type="password" v-model="user.password" v-validate="'required'"></md-input>
                    </md-field>
                    <span v-show="errors.has('password')" class="is-danger">Ошибка</span>
                    <md-field>
                        <label>Повторите пароль</label>
                        <md-input name="passwordConfirmation" type="password" v-model="user.passwordConfirmation" v-validate="'required|confirmed:password'"></md-input>
                    </md-field>
                    <span v-show="errors.has('passwordConfirmation')" class="is-danger">Ошибка</span>
                </md-card-content>
                <md-card-actions>
                    <router-link to="signIn"><md-button class="md-raised">Войти</md-button></router-link>
                    <md-button class="md-raised md-primary" @click="signUp">Зарегистрироваться</md-button>
                </md-card-actions>
            </md-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SignUp',
  data: () => ({
    user: {
      email: '',
      password: '',
      passwordConfirmation: ''
    }
  }),
  methods: {
    // @todo: disabled
    signUp () {
      this.$validator.validateAll().then((result) => {
        if (result) {
          // this.$(http).post...
        }
        // error
      })
    }
  }
}
</script>

<style scoped>
    .md-card-content {
        text-align: left;
    }

    .md-field {
        margin: 8px 0 12px;
    }

    .md-card-actions {
        justify-content: space-around;
        padding: 8px 8px 20px;
    }
</style>
