<template>
  <div class="page-container">
    <md-app>
      <md-app-drawer md-permanent="full" class="menu">
          <img class="user-info__photo" src="../../static/photo.png">
          <p id="username">Иван Иванов</p>
          <select class="role">
              <option selected>Владелец</option>
              <option>Сотрудник</option>
          </select>
          <div class="container">
              <ul id="menu">
                  <li id="stores" class="menu_item" @click="menu">
                      <a href="#">Магазины <md-icon>keyboard_arrow_left</md-icon></a>
                      <div class="menu_wrapper">
                          <ul id="sub_menu">
                              <li class="sub_menu_item" @click="submenu">
                                  <a href="#">Магазин 1 <md-icon>keyboard_arrow_left</md-icon></a>
                                  <div class="sub_menu_wrapper">
                                      <ul class="sub_sub_menu">
                                          <li class="sub_sub_menu_item">
                                              Сотрудники
                                          </li>
                                          <li>
                                              График работы
                                          </li>
                                          <li class="sub_sub_menu_item">
                                              Товары
                                          </li>
                                      </ul>

                                  </div>
                              </li>
                              <li class="sub_menu_item" @click="submenu">
                                  <a href="#">Магазин 2 <md-icon>keyboard_arrow_left</md-icon></a>
                                  <div class="sub_menu_wrapper">
                                      <ul class="sub_sub_menu">
                                          <li class="sub_sub_menu_item">
                                              <a href="#">Сотрудники</a>
                                          </li>
                                          <li>
                                              <a href="#">График работы</a>
                                          </li>
                                          <li class="sub_sub_menu_item">
                                              <a href="#">Товары</a>
                                          </li>
                                      </ul>

                                  </div>
                              </li>
                          </ul>
                      </div>
                  </li>
                  <li id="storages" class="menu_item" @click="menu">
                      <a href="#">Склады <md-icon>keyboard_arrow_left</md-icon></a>
                  </li>
              </ul>
          </div>

      </md-app-drawer>

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
    </md-app>
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