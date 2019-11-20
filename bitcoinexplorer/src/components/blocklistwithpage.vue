<template>
  <div class="hello">
    <h3 style="font-size:25px; text-align:left;">
      <router-link to="/block">BTC/</router-link>块列表
    </h3>
    <el-pagination background layout="prev, pager, next" :total="total" :page-size="pageSize" @current-change="pageChange"></el-pagination>
    <el-table :data="blocks" style="width:100%;">
      <el-table-column prop="height" label="高度" width="100">
        <template slot-scope="scope">
          <a
            style="color:blue"
            :href="'http://localhost:8080/btc/getblockbyheight/'+scope.row.height"
          >{{scope.row.height}}</a>
        </template>
      </el-table-column>
      <el-table-column prop="blockhash" label="哈希" width="700">
        <template slot-scope="scope">
          <a
            style="color:blue"
            :href="'http://localhost:8080/btc/getblockbyhash/'+scope.row.blockhash"
          >{{scope.row.blockhash}}</a>
        </template>
      </el-table-column>
      <el-table-column prop="timeFormat" label="时间" width="100"></el-table-column>
      <el-table-column prop="miner" label="矿工" width="100"></el-table-column>
      <el-table-column prop="sizeondisk" label="大小" width="100">
        <template slot-scope="scope">{{scope.row.sizeondisk.toLocaleString()}}byts</template>
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
      blocks: [],
      page: "1",
      pageSize: "",
      total: ""
    };
  },
  methods: {
    getblocks() {
      axios
        .get("/btc/blocks/" + this.page)
        .then(res => {
          this.blocks = res.data.list;
          this.pageSize = res.data.pageSize;
          this.total = res.data.total;
        })
        .catch(err => {
          console.error(err);
        });
    },
    pageChange(p){
               this.page=p;
               this.getblocks();
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
