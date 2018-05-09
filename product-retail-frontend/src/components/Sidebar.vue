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
      children: []
    }, {
      name: 'Склады',
      root: true,
      children: []
    }]
  }),
  computed: {
    user: () => {
      return store.getters.user
    },
    departments () {
      let departments = store.getters.departments
      let links = { children:
      [
        {
          name: 'Сотрудники',
          path: 'workers'
        },
        {
          name: 'График работы',
          path: 'schedule'
        },
        {
          name: 'Товары',
          path: 'goods'
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
    }
  }
}
</script>
