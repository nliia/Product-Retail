<template id="sidebar-template">
    <div>
        <img class="user-info__photo" src="../../static/photo.png">
        <p id="username">{{ user.name }} {{ user.surname }}</p>
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
                            <li class="sub_menu_item" @click="submenu">
                                <a href="#">Магазин 2 <md-icon>keyboard_arrow_left</md-icon></a>
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
                        </ul>
                    </div>
                </li>
                <li id="storages" class="menu_item" @click="menu">
                    <a href="#">Склады <md-icon>keyboard_arrow_left</md-icon></a>
                </li>
            </ul>
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
  }
}
</script>
