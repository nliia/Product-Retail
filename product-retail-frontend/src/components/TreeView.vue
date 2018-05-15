<template>
  <div class="tree">
    <li>
      <span @click="toggleLink" class="tree__leaf">
        {{ model.name }}
        <span v-if="isDepartment" :class="[open ? 'tree__department-open' : 'tree__department']"></span>
      </span>
      <ul v-if="isDepartment" v-show="open">
        <tree-view v-for="item in model.children" :key="item.id" :model="item"></tree-view>
      </ul>
    </li>
  </div>
</template>

<script>
export default {
  name: 'TreeView',
  props: ['model'],
  data () {
    return {
      open: false
    }
  },
  computed: {
    isDepartment: function () {
      return !!this.model.children
    }
  },
  methods: {
    toggleLink: function () {
      if (this.isDepartment) {
        this.open = !this.open
      } else {
        let department = this.$parent.model
        let path = this.model.path
        this.$store.dispatch('setCurrentDepartment', { type: 'department', item: department })
        this.$router.push({name: path, params: { id: department.id }})
      }
    }
  }
}
</script>
