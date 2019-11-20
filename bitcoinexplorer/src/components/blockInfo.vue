<template>
  <div class="hello">
    <div style="width:80%; margin:0 auto">
      <h3 style="font-size:25px; text-align:left;">
        <router-link to="/block">BTC/</router-link>块详情
      </h3>

      <table style="width:100%;border-spacing:0px 20px;">
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="该区块的hash值" placement="top">
              <el-button type="text" style="color:#677185">哈希</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.blockhash}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="当前块后面有几块" placement="top">
              <el-button type="text" style="color:#677185">确认书</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.confirmations}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="出块时间" placement="top">
              <el-button type="text" style="color:#677185">时间</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.timeFormat}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="当前块是第几块" placement="top">
              <el-button type="text" style="color:#677185">高度</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.height}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="算出此块的人/矿机" placement="top">
              <el-button type="text" style="color:#677185">挖矿人</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.miner}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="当前块下的总交易数" placement="top">
              <el-button type="text" style="color:#677185">交易数量</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.txsize}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="挖矿的难度" placement="top">
              <el-button type="text" style="color:#677185">难度</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.difficulty}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="Merkle树根hash" placement="top">
              <el-button type="text" style="color:#677185">Merkle树根hash</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.merkleRoot}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="该区块的版本" placement="top">
              <el-button type="text" style="color:#677185">版本</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.version}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="该区块的大小" placement="top">
              <el-button type="text" style="color:#677185">大小</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.sizeondisk.toLocaleString()}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="该区块的大小" placement="top">
              <el-button type="text" style="color:#677185">大小</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.sizeondisk.toLocaleString()}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="该区块的重量" placement="top">
              <el-button type="text" style="color:#677185">重量</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.weight}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="该区块的总交易量" placement="top">
              <el-button type="text" style="color:#677185">总交易量</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.transactionVolume}}</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="出块奖励" placement="top">
              <el-button type="text" style="color:#677185">出块奖励</el-button>
            </el-tooltip>
          </td>
          <td class="td2">12.5BTC</td>
        </tr>
        <tr>
          <td class="td1">
            <el-tooltip class="item" effect="dark" content="在改区块下交易所需要的费用" placement="top">
              <el-button type="text" style="color:#677185">交易费用</el-button>
            </el-tooltip>
          </td>
          <td class="td2">{{block.blockReward}}</td>
        </tr>
      </table>
    </div>
    <div style="width:80%; margin:0 auto">
      <h3 style="font-size:25px; text-align:left;">交易列表</h3>
      <el-pagination background layout="prev, pager, next" :total="total" :page-size="pageSize" @current-change="pageChange" v-if="total>10"></el-pagination>
         
            <div class="sc-1myx216-0 iygrgv">

                <div class="p5q4id-0 fasJHc sc-5vnaz6-1 doVOgS">

                    <div class="fieq4h-0 klQmUt">

                        <div class="sc-2msc2s-0 ifipuA">

                            <div class="fieq4h-0 klQmUt">

                                <div class="ild1xh-0 iZMeUk">

                                    <div direction="vertical" class="sc-1fp9csv-0 iFnncD">
                                        <div class="sc-1xo2hia-0 TegxE">
                                            <div width="50%" class="odi4cq-0 gWMQNM">
                                                <div width="100px" class="ccso3i-0 khKhCx"><span
                                                        class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC sc-1n72lkw-0 hAQsZz"
                                                        opacity="1">Hash</span>
                                                </div>
                                                <div width="calc(100% - 100px)" class="ccso3i-0 ghNQhT"><a
                                                        href="/btc/tx/eab54a5eed390426293c69d522c6852acda97c42bd7ae65c479f7d6b987ce43d"
                                                        class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                        opacity="1">{{tx.txid}}</a>
                                                </div>
                                            </div>
                                            <div width="50%" class="odi4cq-0 gWMQNM">
                                                <div width="100px" class="ccso3i-0 khKhCx">
                                                    <div target="desktop" class="sc-197you3-0 iJjTdP"><span
                                                            class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC sc-1n72lkw-0 hAQsZz"
                                                            opacity="1">Date</span>
                                                    </div>
                                                </div>
                                                <div width="calc(100% - 100px)" class="ccso3i-0 ghNQhT">
                                                    <div class="kad8ah-0 iYkTKw"><span
                                                            class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                            opacity="1">{{tx.time}}</span></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="sc-1xo2hia-0 TegxE">
                                            <div width="50%" class="odi4cq-0 gWMQNM">
                                                <div width="100px" class="ccso3i-0 khKhCx">
                                                    <div target="desktop" class="sc-197you3-0 iJjTdP"><span
                                                            class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC sc-1n72lkw-0 hAQsZz"
                                                            opacity="1">From</span>
                                                    </div>
                                                </div>
                                                <div width="calc(100% - 100px)" class="ccso3i-0 ghNQhT">
                                                    <div class="pc1med-0 dOMXDp">
                                                        <div class="pc1med-1 dtKlmR">
                                                            <div class="ge5wha-0 bLrlXr"><a
                                                                    href="/btc/address/17M2QB7N5wsiydjUeoyAwENd1V56d9PTbz"
                                                                    class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                    opacity="1">17M2QB7N5wsiydjUeoyAwENd1V56d9PTbz</a>
                                                                <div class="ge5wha-1 bWdiuU"><span
                                                                        class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                                        opacity="1">0.01283742 BTC</span><a
                                                                        href="/btc/tx/1108cd0832a001ffa2e4ea1b281674ff5f8adaf3fe71f1f896fdca0fae931de4"
                                                                        class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                        opacity="1">
                                                                        <div><svg viewBox="0 0 496 512"
                                                                                class="sc-1pmbxjh-0 bZRcH sc-1legmm2-0 lcIbin"
                                                                                height="14px" selectable="1"
                                                                                width="14px">
                                                                                <path
                                                                                    d="M336.5 160C322 70.7 287.8 8 248 8s-74 62.7-88.5 152h177zM152 256c0 22.2 1.2 43.5 3.3 64h185.3c2.1-20.5 3.3-41.8 3.3-64s-1.2-43.5-3.3-64H155.3c-2.1 20.5-3.3 41.8-3.3 64zm324.7-96c-28.6-67.9-86.5-120.4-158-141.6 24.4 33.8 41.2 84.7 50 141.6h108zM177.2 18.4C105.8 39.6 47.8 92.1 19.3 160h108c8.7-56.9 25.5-107.8 49.9-141.6zM487.4 192H372.7c2.1 21 3.3 42.5 3.3 64s-1.2 43-3.3 64h114.6c5.5-20.5 8.6-41.8 8.6-64s-3.1-43.5-8.5-64zM120 256c0-21.5 1.2-43 3.3-64H8.6C3.2 212.5 0 233.8 0 256s3.2 43.5 8.6 64h114.6c-2-21-3.2-42.5-3.2-64zm39.5 96c14.5 89.3 48.7 152 88.5 152s74-62.7 88.5-152h-177zm159.3 141.6c71.4-21.2 129.4-73.7 158-141.6h-108c-8.8 56.9-25.6 107.8-50 141.6zM19.3 352c28.6 67.9 86.5 120.4 158 141.6-24.4-33.8-41.2-84.7-50-141.6h-108z">
                                                                                </path>
                                                                            </svg></div>
                                                                    </a></div>
                                                            </div>
                                                            <div class="ge5wha-0 bLrlXr"><a
                                                                    href="/btc/address/1PggYBZ4voSagocAjkvTkiLSP53r8tBYkw"
                                                                    class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                    opacity="1">1PggYBZ4voSagocAjkvTkiLSP53r8tBYkw</a>
                                                                <div class="ge5wha-1 bWdiuU"><span
                                                                        class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                                        opacity="1">0.00191066 BTC</span><a
                                                                        href="/btc/tx/7d2e3808100e030ebba663c0e4bacb6ea14a8e6b54bce551654373007b83f36f"
                                                                        class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                        opacity="1">
                                                                        <div><svg viewBox="0 0 496 512"
                                                                                class="sc-1pmbxjh-0 bZRcH sc-1legmm2-0 lcIbin"
                                                                                height="14px" selectable="1"
                                                                                width="14px">
                                                                                <path
                                                                                    d="M336.5 160C322 70.7 287.8 8 248 8s-74 62.7-88.5 152h177zM152 256c0 22.2 1.2 43.5 3.3 64h185.3c2.1-20.5 3.3-41.8 3.3-64s-1.2-43.5-3.3-64H155.3c-2.1 20.5-3.3 41.8-3.3 64zm324.7-96c-28.6-67.9-86.5-120.4-158-141.6 24.4 33.8 41.2 84.7 50 141.6h108zM177.2 18.4C105.8 39.6 47.8 92.1 19.3 160h108c8.7-56.9 25.5-107.8 49.9-141.6zM487.4 192H372.7c2.1 21 3.3 42.5 3.3 64s-1.2 43-3.3 64h114.6c5.5-20.5 8.6-41.8 8.6-64s-3.1-43.5-8.5-64zM120 256c0-21.5 1.2-43 3.3-64H8.6C3.2 212.5 0 233.8 0 256s3.2 43.5 8.6 64h114.6c-2-21-3.2-42.5-3.2-64zm39.5 96c14.5 89.3 48.7 152 88.5 152s74-62.7 88.5-152h-177zm159.3 141.6c71.4-21.2 129.4-73.7 158-141.6h-108c-8.8 56.9-25.6 107.8-50 141.6zM19.3 352c28.6 67.9 86.5 120.4 158 141.6-24.4-33.8-41.2-84.7-50-141.6h-108z">
                                                                                </path>
                                                                            </svg></div>
                                                                    </a></div>
                                                            </div>
                                                            <div class="ge5wha-0 bLrlXr"><a
                                                                    href="/btc/address/1HKcEkqnHa6PXoKJvJR7r7DyqqkvXx4hG7"
                                                                    class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                    opacity="1">1HKcEkqnHa6PXoKJvJR7r7DyqqkvXx4hG7</a>
                                                                <div class="ge5wha-1 bWdiuU"><span
                                                                        class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                                        opacity="1">0.01408902 BTC</span><a
                                                                        href="/btc/tx/85a30dbbe063cff3b0d1b0035d6c1a722657ba6d3d798980d35ad431a05f0464"
                                                                        class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                        opacity="1">
                                                                        <div><svg viewBox="0 0 496 512"
                                                                                class="sc-1pmbxjh-0 bZRcH sc-1legmm2-0 lcIbin"
                                                                                height="14px" selectable="1"
                                                                                width="14px">
                                                                                <path
                                                                                    d="M336.5 160C322 70.7 287.8 8 248 8s-74 62.7-88.5 152h177zM152 256c0 22.2 1.2 43.5 3.3 64h185.3c2.1-20.5 3.3-41.8 3.3-64s-1.2-43.5-3.3-64H155.3c-2.1 20.5-3.3 41.8-3.3 64zm324.7-96c-28.6-67.9-86.5-120.4-158-141.6 24.4 33.8 41.2 84.7 50 141.6h108zM177.2 18.4C105.8 39.6 47.8 92.1 19.3 160h108c8.7-56.9 25.5-107.8 49.9-141.6zM487.4 192H372.7c2.1 21 3.3 42.5 3.3 64s-1.2 43-3.3 64h114.6c5.5-20.5 8.6-41.8 8.6-64s-3.1-43.5-8.5-64zM120 256c0-21.5 1.2-43 3.3-64H8.6C3.2 212.5 0 233.8 0 256s3.2 43.5 8.6 64h114.6c-2-21-3.2-42.5-3.2-64zm39.5 96c14.5 89.3 48.7 152 88.5 152s74-62.7 88.5-152h-177zm159.3 141.6c71.4-21.2 129.4-73.7 158-141.6h-108c-8.8 56.9-25.6 107.8-50 141.6zM19.3 352c28.6 67.9 86.5 120.4 158 141.6-24.4-33.8-41.2-84.7-50-141.6h-108z">
                                                                                </path>
                                                                            </svg></div>
                                                                    </a></div>
                                                            </div>
                                                            <div class="ge5wha-0 bLrlXr"><a
                                                                    href="/btc/address/1LiTrkiEMBpmCqK7MkSFexeCUrVTCvMaZJ"
                                                                    class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                    opacity="1">1LiTrkiEMBpmCqK7MkSFexeCUrVTCvMaZJ</a>
                                                                <div class="ge5wha-1 bWdiuU"><span
                                                                        class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                                        opacity="1">0.69873032 BTC</span><a
                                                                        href="/btc/tx/88ac2e03dc82ce904beffb893cb1b2e2b5655316bcb62a2e3683510204c548cf"
                                                                        class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                        opacity="1">
                                                                        <div><svg viewBox="0 0 496 512"
                                                                                class="sc-1pmbxjh-0 bZRcH sc-1legmm2-0 lcIbin"
                                                                                height="14px" selectable="1"
                                                                                width="14px">
                                                                                <path
                                                                                    d="M336.5 160C322 70.7 287.8 8 248 8s-74 62.7-88.5 152h177zM152 256c0 22.2 1.2 43.5 3.3 64h185.3c2.1-20.5 3.3-41.8 3.3-64s-1.2-43.5-3.3-64H155.3c-2.1 20.5-3.3 41.8-3.3 64zm324.7-96c-28.6-67.9-86.5-120.4-158-141.6 24.4 33.8 41.2 84.7 50 141.6h108zM177.2 18.4C105.8 39.6 47.8 92.1 19.3 160h108c8.7-56.9 25.5-107.8 49.9-141.6zM487.4 192H372.7c2.1 21 3.3 42.5 3.3 64s-1.2 43-3.3 64h114.6c5.5-20.5 8.6-41.8 8.6-64s-3.1-43.5-8.5-64zM120 256c0-21.5 1.2-43 3.3-64H8.6C3.2 212.5 0 233.8 0 256s3.2 43.5 8.6 64h114.6c-2-21-3.2-42.5-3.2-64zm39.5 96c14.5 89.3 48.7 152 88.5 152s74-62.7 88.5-152h-177zm159.3 141.6c71.4-21.2 129.4-73.7 158-141.6h-108c-8.8 56.9-25.6 107.8-50 141.6zM19.3 352c28.6 67.9 86.5 120.4 158 141.6-24.4-33.8-41.2-84.7-50-141.6h-108z">
                                                                                </path>
                                                                            </svg></div>
                                                                    </a></div>
                                                            </div>
                                                            <div class="ge5wha-0 bLrlXr"><a
                                                                    href="/btc/address/1PyKqkWdu8gkJc45EFXMzT1Xs6dn7zGrdq"
                                                                    class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                    opacity="1">1PyKqkWdu8gkJc45EFXMzT1Xs6dn7zGrdq</a>
                                                                <div class="ge5wha-1 bWdiuU"><span
                                                                        class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                                        opacity="1">0.00261788 BTC</span><a
                                                                        href="/btc/tx/bbb869f6f3fdd5a841f3cc57eacfdf6dc5911b641064986a2e99d24d7191f076"
                                                                        class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                        opacity="1">
                                                                        <div><svg viewBox="0 0 496 512"
                                                                                class="sc-1pmbxjh-0 bZRcH sc-1legmm2-0 lcIbin"
                                                                                height="14px" selectable="1"
                                                                                width="14px">
                                                                                <path
                                                                                    d="M336.5 160C322 70.7 287.8 8 248 8s-74 62.7-88.5 152h177zM152 256c0 22.2 1.2 43.5 3.3 64h185.3c2.1-20.5 3.3-41.8 3.3-64s-1.2-43.5-3.3-64H155.3c-2.1 20.5-3.3 41.8-3.3 64zm324.7-96c-28.6-67.9-86.5-120.4-158-141.6 24.4 33.8 41.2 84.7 50 141.6h108zM177.2 18.4C105.8 39.6 47.8 92.1 19.3 160h108c8.7-56.9 25.5-107.8 49.9-141.6zM487.4 192H372.7c2.1 21 3.3 42.5 3.3 64s-1.2 43-3.3 64h114.6c5.5-20.5 8.6-41.8 8.6-64s-3.1-43.5-8.5-64zM120 256c0-21.5 1.2-43 3.3-64H8.6C3.2 212.5 0 233.8 0 256s3.2 43.5 8.6 64h114.6c-2-21-3.2-42.5-3.2-64zm39.5 96c14.5 89.3 48.7 152 88.5 152s74-62.7 88.5-152h-177zm159.3 141.6c71.4-21.2 129.4-73.7 158-141.6h-108c-8.8 56.9-25.6 107.8-50 141.6zM19.3 352c28.6 67.9 86.5 120.4 158 141.6-24.4-33.8-41.2-84.7-50-141.6h-108z">
                                                                                </path>
                                                                            </svg></div>
                                                                    </a></div>
                                                            </div>
                                                            <div class="ge5wha-0 bLrlXr"><a
                                                                    href="/btc/address/14GZbcEpvRZw3wgrneL78eUBw52uSfBeBx"
                                                                    class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                    opacity="1">14GZbcEpvRZw3wgrneL78eUBw52uSfBeBx</a>
                                                                <div class="ge5wha-1 bWdiuU"><span
                                                                        class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                                        opacity="1">0.00036201 BTC</span><a
                                                                        href="/btc/tx/e955170b20b53b7931dfe5ce1fa674e4a5f6c017dfca00980167762711e53a37"
                                                                        class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                        opacity="1">
                                                                        <div><svg viewBox="0 0 496 512"
                                                                                class="sc-1pmbxjh-0 bZRcH sc-1legmm2-0 lcIbin"
                                                                                height="14px" selectable="1"
                                                                                width="14px">
                                                                                <path
                                                                                    d="M336.5 160C322 70.7 287.8 8 248 8s-74 62.7-88.5 152h177zM152 256c0 22.2 1.2 43.5 3.3 64h185.3c2.1-20.5 3.3-41.8 3.3-64s-1.2-43.5-3.3-64H155.3c-2.1 20.5-3.3 41.8-3.3 64zm324.7-96c-28.6-67.9-86.5-120.4-158-141.6 24.4 33.8 41.2 84.7 50 141.6h108zM177.2 18.4C105.8 39.6 47.8 92.1 19.3 160h108c8.7-56.9 25.5-107.8 49.9-141.6zM487.4 192H372.7c2.1 21 3.3 42.5 3.3 64s-1.2 43-3.3 64h114.6c5.5-20.5 8.6-41.8 8.6-64s-3.1-43.5-8.5-64zM120 256c0-21.5 1.2-43 3.3-64H8.6C3.2 212.5 0 233.8 0 256s3.2 43.5 8.6 64h114.6c-2-21-3.2-42.5-3.2-64zm39.5 96c14.5 89.3 48.7 152 88.5 152s74-62.7 88.5-152h-177zm159.3 141.6c71.4-21.2 129.4-73.7 158-141.6h-108c-8.8 56.9-25.6 107.8-50 141.6zM19.3 352c28.6 67.9 86.5 120.4 158 141.6-24.4-33.8-41.2-84.7-50-141.6h-108z">
                                                                                </path>
                                                                            </svg></div>
                                                                    </a></div>
                                                            </div>
                                                        </div>
                                                        <div class="pc1med-2 VTUoi"></div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div width="50%" class="odi4cq-0 gWMQNM">
                                                <div width="100px" class="ccso3i-0 khKhCx">
                                                    <div target="desktop" class="sc-197you3-0 iJjTdP"><span
                                                            class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC sc-1n72lkw-0 hAQsZz"
                                                            opacity="1">To</span>
                                                    </div>
                                                    <div target="mobile" class="sc-197you3-0 laeGOB"><svg
                                                            enable-background="new 0 0 32 32" height="32px" id="svg2"
                                                            version="1.1" viewBox="0 0 32 32" width="32px"
                                                            class="sc-1ub63u6-0 eeqapA">
                                                            <g id="background">
                                                                <rect fill="none" height="32" width="32"></rect>
                                                            </g>
                                                            <g id="arrow_x5F_full_x5F_right">
                                                                <polygon
                                                                    points="16,2.001 16,10 2,10 2,22 16,22 16,30 30,16  ">
                                                                </polygon>
                                                            </g>
                                                        </svg></div>
                                                </div>
                                                <div width="calc(100% - 100px)" class="ccso3i-0 ghNQhT">
                                                    <div class="azsi2v-0 gTUxnf">
                                                        <div class="azsi2v-1 ftBcwW">
                                                            <div class="sc-19pxzmk-0 oSUtL"><span
                                                                    class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                                    opacity="1">113sP2fiYwevhkurQNqEvADih2p53tKgRf</span>
                                                                <div class="sc-19pxzmk-1 gjUsxW"><span
                                                                        class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                                        opacity="1">0.73051833 BTC</span><a
                                                                        href="/btc/tx/c9dcb9b5eca064f9210647200ffeea3c42ab17c3a089edd26431a4b5c45dfd2d"
                                                                        class="sc-1r996ns-0 dkIjuo sc-1tbyx6t-1 fDJjsh iklhnl-0 dBPJKC"
                                                                        opacity="1">
                                                                        <div><svg viewBox="0 0 496 512"
                                                                                class="sc-1pmbxjh-0 bZRcH sc-1eth4zq-0 hHdoRp"
                                                                                height="14px" selectable="1"
                                                                                width="14px">
                                                                                <path
                                                                                    d="M336.5 160C322 70.7 287.8 8 248 8s-74 62.7-88.5 152h177zM152 256c0 22.2 1.2 43.5 3.3 64h185.3c2.1-20.5 3.3-41.8 3.3-64s-1.2-43.5-3.3-64H155.3c-2.1 20.5-3.3 41.8-3.3 64zm324.7-96c-28.6-67.9-86.5-120.4-158-141.6 24.4 33.8 41.2 84.7 50 141.6h108zM177.2 18.4C105.8 39.6 47.8 92.1 19.3 160h108c8.7-56.9 25.5-107.8 49.9-141.6zM487.4 192H372.7c2.1 21 3.3 42.5 3.3 64s-1.2 43-3.3 64h114.6c5.5-20.5 8.6-41.8 8.6-64s-3.1-43.5-8.5-64zM120 256c0-21.5 1.2-43 3.3-64H8.6C3.2 212.5 0 233.8 0 256s3.2 43.5 8.6 64h114.6c-2-21-3.2-42.5-3.2-64zm39.5 96c14.5 89.3 48.7 152 88.5 152s74-62.7 88.5-152h-177zm159.3 141.6c71.4-21.2 129.4-73.7 158-141.6h-108c-8.8 56.9-25.6 107.8-50 141.6zM19.3 352c28.6 67.9 86.5 120.4 158 141.6-24.4-33.8-41.2-84.7-50-141.6h-108z">
                                                                                </path>
                                                                            </svg></div>
                                                                    </a></div>
                                                            </div>
                                                        </div>
                                                        <div class="azsi2v-2 dxZxNv"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="sc-1xo2hia-0 TegxE">
                                            <div width="50%" class="odi4cq-0 gWMQNM">
                                                <div width="100px" class="ccso3i-0 khKhCx"><span
                                                        class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC sc-1n72lkw-0 hAQsZz"
                                                        opacity="1">Fee</span>
                                                </div>
                                                <div width="calc(100% - 100px)" class="ccso3i-0 ghNQhT">
                                                    <div class="kad8ah-1 hvVSKz"><span
                                                            class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                            opacity="1">0.00002898
                                                            BTC</span><span
                                                            class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf"
                                                            opacity="1">(3.123 sat/B -
                                                            0.781 sat/WU - 928 bytes)</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div width="50%" class="odi4cq-0 gWMQNM">
                                                <div width="100px" class="ccso3i-0 exOfTw">
                                                    <div target="desktop" class="sc-197you3-0 iJjTdP"><span
                                                            class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC sc-1n72lkw-0 hAQsZz"
                                                            opacity="1">Amount</span></div>
                                                </div>
                                                <div width="calc(100% - 100px)" class="ccso3i-0 fcPZPx">
                                                    <div class="kad8ah-2 dwdqdJ"><span
                                                            class="sc-1ryi78w-0 iDdexO sc-16b9dsl-1 epNUkC u3ufsr-0 fMGGJf sc-85fclk-0 cilJQE"
                                                            opacity="1">+{{tx.totalOutput}} BTC</span></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>

                            </div>

                        </div>

                    </div>

                </div>

            </div>
    </div>
  </div>
</template>

<script>
import axios from "../api/common";
import '../assets/vendor/inter.min.css'
import '../assets/vendor/txdetail01.css'
import '../assets/vendor/txdetail02.css'

export default {
  name: "HelloWorld",
  data() {
    return {
      block: {},
      hash: "",
      height: "",
      transactions: [],
      total: "",
      pageSize: ""
    };
  },
  methods: {
    getblock(page) {
      if (this.height != "") {
        axios
          .get("/btc/getblockbyheight/" + this.height, {
            params: { page: page }
          })
          .then(res => {
            console.log(res);
            this.block = res.data;
            this.transactions = res.data.transactions.list;
            this.total=res.data.transactions.total;
            this.pageSize=res.data.transactions.pageSize;
          })
          .catch(err => {
            console.error(err);
          });
      } else {
        axios
          .get("/btc/getblockbyhash/" + this.hash, { params: { page: page } })
          .then(res => {
            console.log(res);
            this.block = res.data;
            this.transactions = res.data.transactions.list;
            this.total=res.data.transactions.total;
            this.pageSize=res.data.transactions.pageSize;
          })
          .catch(err => {
            console.error(err);
          });
      }
    }
  },
  mounted() {
    var s = new URL(location.href);
    var h = s.searchParams.get("height");
    var hs = s.searchParams.get("hash");
    if (h != undefined && h != "") {
      this.height = h;
    }
    if (hs != undefined && hs != "") {
      this.hash = hs;
    }
    this.getblock(1);
  }
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
.td1 {
  border-bottom: 1px solid #bbb;
  width: 30%;
  vertical-align: middle;
  font-size: 14px;
  text-align: center;
}
.td2 {
  border-bottom: 1px solid #bbb;
  width: 70%;
  vertical-align: middle;
  font-size: 14px;
  text-align: center;
}
</style>
