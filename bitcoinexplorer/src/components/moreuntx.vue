<template>
  <div class="hello">
     <h3 style="font-size:25px; text-align:left;">
      <router-link to="/block">BTC/</router-link>未确认交易
    </h3>
    <el-table :data="x" style="width: 100%">
      <el-table-column prop="txhash" label="哈希值" width="600">
        <template slot-scope="scope">
          <a style="color:blue"
            :href="'http://localhost:8080/tx/getbyhash/'+ scope.row.txhash"
          >{{scope.row.txhash}}</a>
        </template>
      </el-table-column>
      <el-table-column prop="timeFormat" label="时间"></el-table-column>
      <el-table-column prop="fees" label="数量">
        <template slot-scope="scope">
          {{scope.row.fees}}BTC
        </template>
      </el-table-column>
      <el-table-column prop="fees" label="金额">
        <template slot-scope="scope">
          {{scope.row.fees}}BTC
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "../api/common";
export default {
  name: "HelloWorld",
  data() {
    return {
      unconfirmedTransactions: [],
      x:[]
    };
  },
  methods: {
    getblocks() {
      axios
        .get("/tx/getRecentUnconfirmed")
        .then(res => {
        this.x = res.data;
        
        })
        .catch(err => {
          console.error(err);
        });
    }
  },
  mounted() {},
  created() {
    this.getblocks();
  },
  computed: {},
  watch: {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
