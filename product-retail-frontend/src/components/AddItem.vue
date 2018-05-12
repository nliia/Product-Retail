<template>
  <div class="dialog">
    <md-dialog :md-active.sync="showDialog">
      <md-dialog-title>
        Добавление товара
        <span @click="showDialog = false">
            <md-icon class="fa fa-times dialog__close"></md-icon>
        </span>
      </md-dialog-title>
      <div class="dialog__content">
        <md-field>
            <label>Название</label>
            <md-input v-model="item.name"></md-input>
        </md-field>
        <md-field>
            <label>Цена</label>
            <md-input v-model="item.price" type="number"></md-input>
        </md-field>
        <md-avatar class="image">
            <img :src="item.image" v-if="item.image.length > 0">
            <img src="../assets/images/no-image.svg" v-else>
        </md-avatar>
        <div class="upload">
            <button class="upload__button">ЗАГРУЗИТЬ ФОТО</button>
            <input type="file" @change="imagePreview"/>
        </div>
      </div>
      <md-dialog-actions>
        <md-button class="md-raised md-green" @click="showDialog=false">Сохранить</md-button>
      </md-dialog-actions>
    </md-dialog>
  </div>
</template>

<script>
export default {
  data: () => ({
    showDialog: false,
    item: {
      name: '',
      price: '',
      image: ''
    }
  }),
  methods: {
    imagePreview (event) {
      let input = event.target
      if (input.files && input.files[0]) {
        let reader = new FileReader()
        reader.onload = (e) => {
          this.item.image = e.target.result
        }
        reader.readAsDataURL(input.files[0])
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.md-dialog {
    width: 40%;
    overflow-y: auto;
}

.md-dialog-actions {
    padding: 8px 24px;
}

.md-button .md-ripple {
    padding: 0 20px !important;
}

.md-avatar {
    border-radius: 0;
    width: 110px;
    height: 110px;
    position: relative;
    background: #F3F3F4;

    img {
        height: auto;
    }

    .md-icon {
        right: 0;
        top: 0;
        left: auto;
        transform: none;
    }
}
</style>
