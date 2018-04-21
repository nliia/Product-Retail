<template>
    <div>
      <md-app-content>
          <div class="toolbar">
              <md-icon class="md-inactive">email</md-icon>
              <md-icon>notifications</md-icon>
              <a><md-icon>forward</md-icon>Войти</a>
          </div>
          <div class="titles">
            <p>Сотрудники</p>
            <p>Главная / Магазины / Магазин 1 / Сотрудники</p>
            <md-button class="md-raised add-btn">ДОБАВИТЬ</md-button>
          </div>
          <section class="blocks">
              <div class="block">
                  <div class="worker-info">
                      <div class="worker">
                          <img src="../../static/photo.png">
                          <p>Продавец</p>
                      </div>
                      <div class="info">
                          <p class="name">Николай Петров</p>
                          <br>
                          <p>Магазин 1</p>
                          <p>Адрес магазина</p>
                          <p>89887889676</p>
                      </div>
                  </div>
                  <md-divider></md-divider>
                  <div class="btns">
                      <md-button>Редактировать</md-button>
                      <md-button>Удалить</md-button>
                  </div>
              </div>
              <div class="block">
                  <div class="worker-info">
                      <div class="worker">
                          <img src="../../static/photo.png">
                          <p>Продавец</p>
                      </div>
                      <div class="info">
                          <p class="name">Николай Петров</p>
                          <br>
                          <p>Магазин 1</p>
                          <p>Адрес магазина</p>
                          <p>89887889676</p>
                      </div>
                  </div>
                  <md-divider></md-divider>
                  <div class="btns">
                      <md-button>Редактировать</md-button>
                      <md-button>Удалить</md-button>
                  </div>
              </div>
              <div class="block">
                  <div class="worker-info">
                      <div class="worker">
                          <img src="../../static/photo.png">
                          <p>Продавец</p>
                      </div>
                      <div class="info">
                          <p class="name">Николай Петров</p>
                          <br>
                          <p>Магазин 1</p>
                          <p>Адрес магазина</p>
                          <p>89887889676</p>
                      </div>
                  </div>
                  <md-divider></md-divider>
                  <div class="btns">
                      <md-button>Редактировать</md-button>
                      <md-button>Удалить</md-button>
                  </div>
              </div>
              <div class="block">
                  <div class="worker-info">
                      <div class="worker">
                          <img src="../../static/photo.png">
                          <p>Продавец</p>
                      </div>
                      <div class="info">
                          <p class="name">Николай Петров</p>
                          <br>
                          <p>Магазин 1</p>
                          <p>Адрес магазина</p>
                          <p>89887889676</p>
                      </div>
                  </div>
                  <md-divider></md-divider>
                  <div class="btns">
                      <md-button>Редактировать</md-button>
                      <md-button>Удалить</md-button>
                  </div>
              </div>
              <div class="block">
                  <div class="worker-info">
                      <div class="worker">
                          <img src="../../static/photo.png">
                          <p>Продавец</p>
                      </div>
                      <div class="info">
                          <p class="name">Николай Петров</p>
                          <br>
                          <p>Магазин 1</p>
                          <p>Адрес магазина</p>
                          <p>89887889676</p>
                      </div>
                  </div>
                  <md-divider></md-divider>
                  <div class="btns">
                      <md-button>Редактировать</md-button>
                      <md-button>Удалить</md-button>
                  </div>
              </div>
              <div class="block">
                  <div class="worker-info">
                      <div class="worker">
                          <img src="../../static/photo.png">
                          <p>Продавец</p>
                      </div>
                      <div class="info">
                          <p class="name">Николай Петров</p>
                          <br>
                          <p>Магазин 1</p>
                          <p>Адрес магазина</p>
                          <p>89887889676</p>
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
export default {
  name: 'Normal',
  methods: {
    //          menu() {
    //              var menu = document.getElementById('menu');
    //              var currentOpenMenu = null;
    //              menu.onclick = function (event) {
    //                  var subMenu = event.target.closest('.menu_item').querySelector('.menu_wrapper');
    //                  if (this.open) {
    //                      event.target.querySelector('i').innerHTML = 'keyboard_arrow_left';
    //                      subMenu.style.height = '0';
    //                      currentOpenMenu = null;
    //                  } else {
    //                      event.target.querySelector('i').innerHTML = 'keyboard_arrow_down';
    //                      subMenu.style.height = subMenu.firstElementChild.clientHeight + 'px';
    //                      subMenu.firstElementChild.onclick = (event) => event.stopPropagation();
    //                      if (currentOpenMenu){
    //                          currentOpenMenu.style.height = '0';
    //                      }
    //                      currentOpenMenu = subMenu;
    //                  }
    //              this.open = !this.open;
    //              }
    //          },
    //          submenu() {
    //              var menu = document.getElementById('sub_menu');
    //              var currentOpenMenu = null;
    //              menu.onclick = function (event) {
    //                  var subMenu = event.target.closest('.sub_menu_item').querySelector('.sub_menu_wrapper');
    //                  if (this.open) {
    //                      event.target.querySelector('i').innerHTML = 'keyboard_arrow_left';
    //                      subMenu.style.height = '0';
    //                      currentOpenMenu = null;
    //                  } else {
    //                      event.target.querySelector('i').innerHTML = 'keyboard_arrow_down';
    //                      subMenu.style.height = subMenu.firstElementChild.clientHeight + 'px';
    //                      subMenu.firstElementChild.onclick = (event) => event.stopPropagation();
    //                      if (currentOpenMenu){
    //                          currentOpenMenu.style.height = '0';
    //                      }
    //                      currentOpenMenu = subMenu;
    //                  }
    //                  this.open = !this.open;
    //              }
    //          }
  }
}
</script>
