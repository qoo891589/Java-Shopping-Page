<template>
  <div>
    <emp-view></emp-view>
  </div>
</template>

<script>
import ElementView from './views/element/ElementView.vue'
import EmpView from './views/Pojo/EmpView.vue'
export default {
  components: { EmpView },
  data() {
    return {
      message: "Hello vue"
    }
  },
  methods: {

  },
}
</script>

<style></style>
