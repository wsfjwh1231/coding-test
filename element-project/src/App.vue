<template>
  <div id="app">
    <!-- <nav>
      <router-link to="/home">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/">login</router-link>
    </nav> -->
    <router-view/>
  </div>
</template>

<style lang="scss">
// 去掉浏览器本身的外填充
*{
  margin: 0;
}
</style>
