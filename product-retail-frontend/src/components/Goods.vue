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
                    <p>Товары</p>
                    <p>Главная / Магазины / Магазин 1 / Товары</p>
                    <md-button class="md-raised add-btn">ДОБАВИТЬ</md-button>
                </div>
                <section class="blocks">
                    <div class="block">
                        <div class="product-info">
                            <div class="product">
                                <img src="../../static/product.png">
                            </div>
                            <div class="info">
                                <p class="name">Томаты</p>
                                <br>
                                <p>Количество: <span>15</span></p>
                                <p>Цена: <span>150</span> руб.</p>
                            </div>
                        </div>
                        <md-divider></md-divider>
                        <div class="btns">
                            <md-button>Редактировать</md-button>
                            <md-button>Удалить</md-button>
                        </div>
                    </div>
                    <div class="block">
                        <div class="product-info">
                            <div class="product">
                                <img src="../../static/product.png">
                            </div>
                            <div class="info">
                                <p class="name">Томаты</p>
                                <br>
                                <p>Количество: <span>15</span></p>
                                <p>Цена: <span>150</span> руб.</p>
                            </div>
                        </div>
                        <md-divider></md-divider>
                        <div class="btns">
                            <md-button>Редактировать</md-button>
                            <md-button>Удалить</md-button>
                        </div>
                    </div>
                    <div class="block">
                        <div class="product-info">
                            <div class="product">
                                <img src="../../static/product.png">
                            </div>
                            <div class="info">
                                <p class="name">Томаты</p>
                                <br>
                                <p>Количество: <span>15</span></p>
                                <p>Цена: <span>150</span> руб.</p>
                            </div>
                        </div>
                        <md-divider></md-divider>
                        <div class="btns">
                            <md-button>Редактировать</md-button>
                            <md-button>Удалить</md-button>
                        </div>
                    </div>
                    <div class="block">
                        <div class="product-info">
                            <div class="product">
                                <img src="../../static/product.png">
                            </div>
                            <div class="info">
                                <p class="name">Томаты</p>
                                <br>
                                <p>Количество: <span>15</span></p>
                                <p>Цена: <span>150</span> руб.</p>
                            </div>
                        </div>
                        <md-divider></md-divider>
                        <div class="btns">
                            <md-button>Редактировать</md-button>
                            <md-button>Удалить</md-button>
                        </div>
                    </div>
                    <div class="block">
                        <div class="product-info">
                            <div class="product">
                                <img src="../../static/product.png">
                            </div>
                            <div class="info">
                                <p class="name">Томаты</p>
                                <br>
                                <p>Количество: <span>15</span></p>
                                <p>Цена: <span>150</span> руб.</p>
                            </div>
                        </div>
                        <md-divider></md-divider>
                        <div class="btns">
                            <md-button>Редактировать</md-button>
                            <md-button>Удалить</md-button>
                        </div>
                    </div>
                    <div class="block">
                        <div class="product-info">
                            <div class="product">
                                <img src="../../static/product.png">
                            </div>
                            <div class="info">
                                <p class="name">Томаты</p>
                                <br>
                                <p>Количество: <span>15</span></p>
                                <p>Цена: <span>150</span> руб.</p>
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
        name: 'Normal'
    }
</script>