<template>
  <div class="hello">
          <h3 style="font-size:25px; text-align:left;">最新区块</h3><span></span><a style="color:blue; margin-right:30px;" href="/blocklistwithpage">更多区块</a>
          <el-table :data="blocks" style="width:100%;" v-loading="loading">
            <el-table-column prop="height" label="高度" width="150">
              <template slot-scope="scope">
                <a style="color:blue" class="blockhash" :href="'/blockinfo?height='+scope.row.height">{{scope.row.height}}</a>
              </template>
            </el-table-column>
            <el-table-column prop="blockhash" label="哈希" width="400">
              <template slot-scope="scope">
                <a style="color:blue" class="blockhash" :href="'blockinfo?hash='+scope.row.blockhash">{{0+scope.row.blockhash.replace(/00+/,"..")}}</a>
              </template>
            </el-table-column>
            <el-table-column prop="timeFormat" label="时间" width="200"></el-table-column>
            <el-table-column prop="miner" label="矿工" width="200"></el-table-column>
            <el-table-column prop="sizeondisk" label="大小" width="200">
                      <template slot-scope="scope">
                {{scope.row.sizeondisk.toLocaleString()}}byts
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
      blocks: [],
      loading: true
    };
  },
  methods: {
    getblocks() {
      axios
        .get("/btc/blocks")
        .then(res => {
          this.blocks = res.data;
          this.loading=false;
          
          
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
.blockhash {
    text-overflow: ellipsis;
    white-space: nowrap;
    overflow: hidden;
}
</style>
