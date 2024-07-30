<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <i class="el-icon-edit"></i>
    <ul>
      <li v-for="game in games" :key="game.id">
        <el-button>{{ game.name }}</el-button>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      games: [] // 用于存储从API获取的数据
    };
  },
  mounted() {
    // 在组件挂载后调用API
    this.fetchGames();
  },
  methods: {
    fetchGames() {
      axios.get('http://localhost:8080/api/games')
        .then(response => {
          this.games = response.data; // 将API返回的数据赋值给games
        })
        .catch(error => {
          console.error('There was an error fetching the games!', error);
        });
    }
  }
}
</script>

<style scoped>
h1 {
  margin: 20px 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  margin: 5px 0;
}
</style>
