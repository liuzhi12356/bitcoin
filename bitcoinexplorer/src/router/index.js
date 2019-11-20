import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import ElemlentUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Block from '@/components/block'
import Blocklist from '@/components/blocklist'
import Untranlist from '@/components/untx'
import Blocklistwithpage from '@/components/blocklistwithpage'
import Moreuntx from '@/components/moreuntx'
import Address from '@/components/address'
import BlockInfo from '@/components/blockInfo'
import TransactionInfo from '@/components/transactionInfo'
Vue.use(Router)
Vue.use(ElemlentUi)
export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/block',
      name: 'block',
      component: Block,
      children:[
        {
          path: '/blocklist',
          name: 'blocklist',
          component: Blocklist
        },
        {
          path: '/untranlist',
          name: 'untranlist',
          component: Untranlist
        }
      ]
    }
    ,
    {
          path: '/blocklistwithpage',
          name: 'blocklistwithpage',
          component: Blocklistwithpage
    }
    ,
    {
          path: '/moreuntx',
          name: 'moreuntx',
          component: Moreuntx
    }
    ,
    {
          path: '/address',
          name: 'address',
          component: Address
    }
    ,
    {
          path: '/blockInfo',
          name: 'blockInfo',
          component: BlockInfo
    }
    ,
    {
          path: '/transactionInfo',
          name: 'transactionInfo',
          component: TransactionInfo
    }
    
  ]
})
