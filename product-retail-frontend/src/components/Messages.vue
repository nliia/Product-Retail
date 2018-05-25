<template>
    <div>
        <md-app-content>
            <div class="breadcrumbs">
                <div class="breadcrumbs__item">
                    <p class="breadcrumbs__item-large">Сообщения</p>
                </div>
            </div>
        </md-app-content>
        <md-card class="message-page">
            <md-card-content>
                <section class="dialogs-container">
                    <div class="dialogs-container__search">
                        <input type="search" placeholder="Поиск">
                    </div>
                    <div class="dialogs-container__dialog" v-on:click="fetchMessages(dialog.id)" v-for="dialog in dialogs" :key="dialog.id" >
                        <div class="dialog__avatar">
                            <img src="../assets/images/person.svg" alt="avatar">
                        </div>
                        <div class="dialog__name">{{ dialog.name }} {{ dialog.surname }}</div>
                        <div class="dialog__role">
                            <div>{{ dialog.role }}</div>
                        </div>
                    </div>
                </section>
                <section class="dialog">
                    <div class="dialog__window">
                        <div v-bind:class="{'reverse': !isCurrentUser(message.sender.id)}" v-for="message in messages" :key="message.id" class="message">
                            <div class="message__avatar">
                                <img src="../assets/images/person.svg">
                            </div>
                            <div class="message__container">
                                <div class="message__data">
                                    <div class="message__name">{{ message.sender.name }} {{ message.sender.surname }}</div>
                                    <div class="message__date"></div>
                                </div>
                                <div class="message__text">{{ message.text }}</div>
                            </div>
                        </div>
                    </div>
                    <form v-on:submit="sendMessage">
                      <div class="dialog__textarea">
                            <input v-model="messageText" type="text" placeholder="Напишите сообщение...">
                            <button>
                              <md-icon class="fa fa-chevron-right"></md-icon>
                            </button>
                      </div>
                    </form>
                </section>
            </md-card-content>
        </md-card>
    </div>
</template>

<script>
import store from '../store/store'
import messageService from '../services/messagesService'

export default {
  data: () => ({
    dialogs: {},
    messages: {},
    collocutor: {},
    loading: false
  }),
  created () {
    this.fetchUsers()
  },
  watch: {
    '$route': 'fetchUsers'
  },
  methods: {
    async fetchUsers () {
      this.loading = true
      const response = await messageService.getUsersToSend()
      this.loading = false
      this.dialogs = response.data.responseData
    },
    async fetchMessages (userId) {
      this.loading = true
      const response = await messageService.getMessages(userId)
      this.loading = false
      this.messages = response.data.responseData
      this.collocutor.id = userId
    },
    isCurrentUser: function (id) {
      if (store.getters.user.id === id) {
        return true
      } else {
        return false
      }
    },
    async sendMessage (e) {
      var credentials = {
        recipient_id: this.collocutor.id,
        text: this.messageText
      }

      var newMessage = {
        text: this.messageText,
        sender: {
          id: store.getters.user.id,
          name: store.getters.user.name,
          surname: store.getters.user.name
        }
      }

      this.messages.push(newMessage)

      this.messageText = ''
      this.loading = true
      await messageService.sendMessage(credentials)
      this.loading = false
      e.preventDefault()
    }
  }
}
</script>
