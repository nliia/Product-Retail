<template>
  <div class="sidebar">
      <div class="user">
        <img class="user__photo" src="../assets/images/person.svg">
        <p class="user__name">{{ user.name }} {{ user.surname }}</p>
        <span class="user__post">{{ user.role }}</span>
      </div>
      <ul class="tree-container">
          <tree-view v-for="item in departments" :key="item.id" :model="item"></tree-view>
      </ul>
  </div>
</template>

<script>
import store from '../store/store'
import treeView from '@/components/TreeView'

export default {
  name: 'Sidebar',
  components: {
    treeView
  },
  props: ['model'],
  data: () => ({
    tree: [{
      name: 'Магазины',
      root: true,
      children: [],
      visible: false
    }, {
      name: 'Склады',
      root: true,
      children: [],
      visible: false
    }]
  }),
  computed: {
    user: () => {
      return store.getters.user
    },
    departments () {
      let departments = store.getters.departments
      let links = {
        visible: true,
        children:
      [
        {
          name: 'Сотрудники',
          path: 'workers',
          visible: true
        },
        {
          name: 'График работы',
          path: 'schedule',
          visible: true
        },
        {
          name: 'Товары',
          path: 'goods',
          visible: true
        },
        {
          name: 'Задачи',
          path: 'tasks',
          visible: true
        }
      ]
      }
      for (let dep of departments) {
        this.renderTree(dep, links, this.tree)
      }
      return this.tree
    }
  },
  methods: {
    renderTree (dep, links, tree) {
      Object.assign(dep, links)
      dep.warehouse ? tree[1].children.push(dep) : tree[0].children.push(dep)
      for (let leaf of tree) {
        if (leaf.children.length) {
          leaf.visible = true
        }
      }
    }
  }
}
</script>
