<template>
  <div class="sign">
    <div class="container">
      <div class="row justify-content-md-center">
        <div class="col-sm-12 col-md-6 col-lg-4">
            <md-card>
                <md-card-header>
                    <div class="md-title">Авторизация</div>
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
                </md-card-content>
                <md-card-actions>
                    <router-link to="signUp"><md-button class="md-raised">Зарегистрироваться</md-button></router-link>
                    <md-button class="md-raised md-primary" @click="signIn">Войти</md-button>
                </md-card-actions>
            </md-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SignIn',
  data: () => ({
    user: {
      email: '',
      password: ''
    }
  }),
  methods: {
    // @todo: disabled
    signIn () {
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
