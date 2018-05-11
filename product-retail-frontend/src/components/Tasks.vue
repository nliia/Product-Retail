<template>
    <div>
        <div>
            <md-app-content>
                <div class="titles">
                    <p>График работы</p>
                    <p>Главная / Магазины / Магазин 1 / График работы</p>
                </div>
            </md-app-content>
        </div>
        <div class="card-scene">
            <Container
                    orientation="horizontal"
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
                                <div :class="card.props.className" :style="card.props.style">
                                    <p class="task-data">{{card.data['text']}}
                                        <div class="photo" data-title="Марья Ивановна"><img src="../assets/images/person.svg"></div>
                                </div>
                            </Draggable>
                        </Container>
                    </div>
                </Draggable>
            </Container>
        </div>
    </div>
</template>

<script>
import { Container, Draggable } from 'vue-smooth-dnd'
import { applyDrag, generateItems } from '../services/tasksService'

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
        className: 'card',
        style: { backgroundColor: '#eee' }
      },
      data: {
        text: 'Что-то сделать' + i + j,
        worker: {
          name: 'Марья Ивановна'
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
  methods: {
    onColumnDrop: function (dropResult) {
      const scene = Object.assign({}, this.scene)
      scene.children = applyDrag(scene.children, dropResult)
      this.scene = scene
    },

    onCardDrop: function (columnId, dropResult) {
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

    getCardPayload: function (columnId) {
      return index => {
        return this.scene.children.filter(p => p.id === columnId)[0].children[index]
      }
    }
  }
}
</script>
