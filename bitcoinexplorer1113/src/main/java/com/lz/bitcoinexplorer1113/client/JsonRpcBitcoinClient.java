package com.lz.bitcoinexplorer1113.client;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
@Component
public class JsonRpcBitcoinClient {
    private JsonRpcHttpClient jsonRpcHttpClient;

    public JsonRpcBitcoinClient() throws MalformedURLException {
        String s = Base64.getEncoder().encodeToString(("lz" + ":" + "123456").getBytes());
        HashMap<String, String> ma = new HashMap<>();
        ma.put("Authorization","Basic "+s);
        jsonRpcHttpClient=new JsonRpcHttpClient(new URL("http://localhost:18332"),ma);

    }

    public String getBestBlockhash() throws Throwable {
        String bestblockhash = jsonRpcHttpClient.invoke("getbestblockhash", new Object[]{}, String.class);
        return bestblockhash;
    }
}
