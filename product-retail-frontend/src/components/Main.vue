<template>
  <div class="hello">
    <div class="container">
      <div class="row justify-content-md-center align-items-center">
        <div class="col-sm-12 col-md-5 col-lg-4">
          <md-card>
            <md-tabs class="md-transparent" md-alignment="fixed">
              <md-tab id="signIn" md-label="Авторизация">
                <md-field>
                  <label>Email</label>
                  <md-input></md-input>
                </md-field>
                <md-field>
                  <label>Пароль</label>
                  <md-input type="password"></md-input>
                </md-field>
                <md-button class="md-raised">Войти</md-button>
              </md-tab>
              <md-tab id="signUp" md-label="Регистрация">
                <md-field>
                  <label>Email</label>
                  <md-input></md-input>
                </md-field>
                <md-field>
                  <label>Пароль</label>
                  <md-input type="password"></md-input>
                </md-field>
                <md-field>
                  <label>Повторите пароль</label>
                  <md-input type="password"></md-input>
                </md-field>
                <md-button class="md-raised">Зарегистрироваться</md-button>
              </md-tab>
            </md-tabs>
          </md-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld'
}
</script>

<style scoped>
</style>
