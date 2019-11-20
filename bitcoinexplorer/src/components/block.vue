<template>
  <div class="hello">
    <el-container style="height: 500px;  ">
      <el-aside width="200px" style=" margin-top:70px">
        <el-menu :default-active="xx" @select="handleSelect" >
          <span style="font-size:20px;">比特币浏览器</span>
          <el-menu-item index="1">
            <span slot="title">最新区块</span>
          </el-menu-item>
          <el-menu-item index="2">
            <span slot="title">未确认交易</span>
          </el-menu-item>
          <el-menu-item index="3">
            <span slot="title">导航三</span>
          </el-menu-item>
          <el-menu-item index="4">
            <span slot="title">导航四</span>
          </el-menu-item>
          <el-menu-item index="5">
            <span slot="title">导航五</span>
          </el-menu-item>
          <el-menu-item index="6">
            <span slot="title">导航六</span>
          </el-menu-item>
        </el-menu>
        
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-input  prefix-icon="el-icon-search" placeholder="请输入区块哈希,地址值,交易哈希进行查询" v-model="input" style="width:400px; margin-right:1px;" clearable></el-input>
          <el-button type="primary" icon="el-icon-search" style="margin-right:300px;">搜索</el-button>
        </el-header>

        <el-main>
          <div>
        <el-breadcrumb separator="/">
                <el-breadcrumb-item v-for="(item,index) in breadcrumbItems" :key="index">{{item}}</el-breadcrumb-item>
                <router-view></router-view>
              </el-breadcrumb>
              </div>
          
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import axios from "../api/common";
import '../assets/custom.css'
export default {
  name: "HelloWorld",
  data() {
    return {
       input:"",
       breadcrumbItems: ['最新区块'],
       isselect:'1',
       xx:'1'
    };
  },
  methods: {
    
    handleSelect(key){
      
      this.isselect=key;

          switch(this.isselect){
            
            case '1':
              this.$router.push("/blocklist");
              this.breadcrumbItems=['最新区块'];
              break;
            case '2':
              this.$router.push("/untranlist");
              this.breadcrumbItems=['未确认交易'];
              break;
          }
          sessionStorage.setItem("isselect",this.isselect);
    }
  },
  mounted() {
    
    var s=sessionStorage.getItem("isselect");
        if(s!=undefined){
             this.isselect=s;
        }
    this.xx=this.isselect;
    this.handleSelect(this.isselect);
  },
  created() {
    
  
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
