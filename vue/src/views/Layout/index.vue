<script setup>
// import LayoutNav from './components/LayoutNav.vue'
import LayoutHeader from './components/LayoutHeader.vue'
import LayoutFooter from './components/LayoutFooter.vue'
import LayoutFixed from './components/LayoutFixed.vue';

import { useCategorytore } from '@/stores/category';
import { onMounted } from 'vue';

const categoryStore = useCategorytore();

onMounted(() => categoryStore.getCategory())

</script>

<template>
    <LayoutFixed />
    <LayoutHeader />
    <RouterView />
    <LayoutFooter />
</template>