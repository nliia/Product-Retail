<template>
  <div>
    <md-app-content>
      <div class="breadcrumbs">
        <div class="breadcrumbs__item">
          <p class="breadcrumbs__item-large">Задачи</p>
          <div>
            <router-link to="/" class="breadcrumbs__link">Главная</router-link> /
            <span v-if="currentDepartment.warehouse">Склады</span>
            <span v-else>Магазины</span>
            / {{ currentDepartment.name }} /
            <span class="breadcrumbs__item-bold">Задачи</span>
          </div>
        </div>
      </div>
      <div class="card-scene">
        <Container orientation="horizontal"
                   @drop="onColumnDrop($event)"
                   drag-handle-selector=".column-drag-handle"
                   @drag-start="dragStart">
          <Draggable v-for="column in scene.children" :key="column.id">
            <div :class="column.props.className">
              <div class="card-column-header">
                {{column.name}}
              </div>
              <Container class="card-container"
                         group-name="col"
                         @drop="(e) => onCardDrop(column.id, e)"
                         :get-child-payload="getCardPayload(column.id)"
                         drag-class="card-ghost"
                         drop-class="card-ghost-drop">
                <Draggable v-for="card in column.children" :key="card.id">
                  <div class="card" :style="card.props.style">
                    <div class="task-data">{{card.data['text']}}</div>
                    <md-avatar id="avatar">
                      <img src="../assets/images/person.svg" alt="Avatar">
                      <md-tooltip md-direction="top">Мария Иванова</md-tooltip>
                    </md-avatar>
                  </div>
                </Draggable>
              </Container>
            </div>
          </Draggable>
        </Container>
      </div>
    </md-app-content>
  </div>
</template>

<script>
import { Container, Draggable } from 'vue-smooth-dnd'
import { applyDrag, generateItems } from '../services/tasksService'
import store from '../store/store'

const columnNames = [
  'To Do',
  'In Progress',
  'Done'
]

const scene = {
  type: 'container',
  props: {
    orientation: 'horizontal'
  },
  children: generateItems(3, i => ({
    id: `column${i}`,
    type: 'container',
    name: columnNames[i],
    props: {
      orientation: 'vertical',
      className: 'card-container'
    },
    children: generateItems(5, j => ({
      type: 'draggable',
      id: `${i}${j}`,
      props: {
        style: {
          backgroundColor: '#F3F3F4',
          border: 'none',
          borderLeft: '5px solid #bcc0c3',
          borderRight: '5px solid #bcc0c3',
          padding: '15px 0 0 10px',
          display: 'flex',
          width: '100%',
          height: 'auto'
        }
      },
      data: {
        text: 'Что-то сделать' + i + j
      },
      children: {
        type: 'avatar',
        props: {
          style: {
            position: 'absolute',
            right: '15px'
          }
        }
      }
    }))
  }))
}

export default {
  name: 'Cards',
  components: { Container, Draggable },
  data: function () {
    return {
      scene
    }
  },
  computed: {
    currentDepartment: () => {
      return store.getters.currentDepartment
    }
  },
  methods: {
    onColumnDrop (dropResult) {
      const scene = Object.assign({}, this.scene)
      scene.children = applyDrag(scene.children, dropResult)
      this.scene = scene
    },
    onCardDrop (columnId, dropResult) {
      if (dropResult.removedIndex !== null || dropResult.addedIndex !== null) {
        const scene = Object.assign({}, this.scene)
        const column = scene.children.filter(p => p.id === columnId)[0]
        const columnIndex = scene.children.indexOf(column)

        const newColumn = Object.assign({}, column)
        newColumn.children = applyDrag(newColumn.children, dropResult)
        scene.children.splice(columnIndex, 1, newColumn)

        this.scene = scene
      }
    },
    getCardPayload (columnId) {
      return index => {
        return this.scene.children.filter(p => p.id === columnId)[0].children[index]
      }
    },
    dragStart () {
    }
  }
}
</script>

<style lang="scss" scoped>
.md-tooltip {
  font-size: 12px !important;
  background: rgba(0, 0, 0, .8);
}

.smooth-dnd-ghost * {
    position: absolute;
    right: 15px;
    text-align: left;
    width: 100%;
    padding-left: 30px;
    min-height: 70px;
}

.smooth-dnd-ghost img {
    margin-top: -12px;
    height: 75px;
    width: 75px;
}

</style>
