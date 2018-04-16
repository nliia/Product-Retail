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

            </md-app-drawer>

            <md-app-content>
                <div class="toolbar">
                    <md-icon class="md-inactive">email</md-icon>
                    <md-icon>notifications</md-icon>
                    <a><md-icon>forward</md-icon>Войти</a>
                </div>
                <div class="titles">
                    <p>График работы</p>
                    <p>Главная / Магазины / Магазин 1 / График работы</p>
                </div>
                <section class="calendar-container">
                    <calendar-view
                            :show-date="showDate"
                            @show-date-change="setShowDate"
                            class="holiday-us-traditional holiday-us-official"
                    ></calendar-view>
                </section>
            </md-app-content>
        </md-app>
    </div>
</template>

<script>
    import CalendarView from "vue-simple-calendar"
    require("vue-simple-calendar/dist/static/css/default.css")
    require("vue-simple-calendar/dist/static/css/holidays-us.css")

    export default {
        name: 'Normal',
        data: function() {
            return { showDate: new Date() }
        },
        components: {
            CalendarView
        },
        methods: {
            setShowDate(d) {
                this.showDate = d;
            },
        }
    }
</script>