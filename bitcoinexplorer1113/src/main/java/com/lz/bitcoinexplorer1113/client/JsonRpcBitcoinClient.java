package com.lz.bitcoinexplorer1113.client;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
@Component
public class JsonRpcBitcoinClient {
    private JsonRpcHttpClient jsonRpcHttpClient;

    @Value("${bitcoin.rest.url}")
    private String url;

    public JsonRpcBitcoinClient() throws MalformedURLException {
        String s = Base64.getEncoder().encodeToString(("lz" + ":" + "123456").getBytes());
        HashMap<String, String> ma = new HashMap<>();
        ma.put("Authorization","Basic "+s);
        jsonRpcHttpClient=new JsonRpcHttpClient(new URL("http://localhost:18332/"),ma);

    }

    public String getBestBlockhash() throws Throwable {
        String bestblockhash = jsonRpcHttpClient.invoke("getbestblockhash", new Object[]{}, String.class);
        return bestblockhash;
    }

    public JSONObject getRawTransaxtion(String txid) throws Throwable {
        JSONObject rawTransaction = jsonRpcHttpClient.invoke("getrawtransaction", new Object[]{txid, true}, JSONObject.class);
        return rawTransaction;
    }
}
