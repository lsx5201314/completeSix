package com.jk.sandbox.controller;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101600700936";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCJISTFWnRX/d/JY/u0KHGIWIW+rtIsC4hV2cR/uzQyAhFogJQstpwy0Aasr6Ws+gpbhk/YFCO90FA5O4y2PAop2nAcXU37tpljbdgq63eZ9Zb1f74yn7aCCBcOLEYcR3AdHWUtMN7wuU10XpeePyNPBXZQX7M9oIHCDdTVgxG1Rs1R1vD4NOMVhRb08Mwvgi87G7iJ90DMMJduEsESflerVmkPfm6HSqR7Onrr11yISvOb2uLbEKheS6+NCEbPsrSAYG1cAksV5o/P8egXvzSxELh904gfV/NrpWrsau5I7DS+zV97f/sEG3dM/lGrN9Nj89RR82HhrdtQPfgfh+9NAgMBAAECggEAe0WCKq9P2zHrlLz+rkuVE/6P7IR3hwSvAI4M6M4+852MTKcZjMBz1fHPrjkP9FmqKfCpohMoth+nnmt76O48LLejBLyTt+3EIe/C3YJjN9HgbLzzG8sbY/Ul1KXUOOO3U1TzeRZvs3LAwBWwsp8LfKPqYgJFvOam/u00IOP8bTnw0krntPWWUb+W2ANlwgcR39KJnzI9ZUIs2fYGrZzmmFKf9823BQc71ccw21VpZDmC2afhnfArWKsLAAteK9jGceqNLoigko2HcdqHnuVi8vZ2zK8YnU9NEED0ReFgT4QNdi6CJtiKlTdlP6cumfrsVudTJEC96bHBxfV6kik3uQKBgQDKC4qQAjDP9xvCes+SMwA3lI87hIszrNPNTA5bNrg/gPqyxoTHy9BiCne71gYI4kiAytlaY32N+1QiUHHRslAkjGCxXAIXCs6wOsCiOVrFrn5q7t6uYUV4VZ8ceee8zmWvh+niYaa8ZjN/UQGPia7II1vjv0I5+wM4UvwazyllkwKBgQCtv8KE7GYA/jaKEu1ua2ES4hYmgc/MvpXegwbjqmmvnKBHpsQR6SMWtqewkdCBtd21YbFzuSwl8z9JH5pVIvyBxpPPLygxWlEOyMe6OuiO2dvB2fuvN6nIemJNnjpWv7XEYH2mf0zQrDPK3d9W5GhQSp2Cnva0zyADwr8aWY5jnwKBgB5sFnUQn2DxCFEERPTykPnNeLOxhXRGda3X4eGCH8QQG6+HjL64xau9f8HcvBPiXqBl6sxdZq5WRZjVHA5DFyYprPWHsRjfG7gVYKQMlsplN8vKI+WF5/vyiH61LFuViGIhyOm5Ym3DxcVJ4T5HsPWZvWBRkBtC3H1CoYs33jfZAoGAecqoXKqk2d9YdbLM0hDdC/KFGlr2QYv62+22v5Gt4ZaF15PzbqagnQROSXv8z1+fWMxxKjBL3RJEc0p+0Vzj6Ug8RgfFQcsQdK+TKVyvtarK23ikbu8yyT/YdpYKSNK7ZDtK+JHVU5TR/UtHic4zvMyA2pX5U0a5J0m00ZCjOfsCgYAY9BDWU9GZHKOrRZaKx/OxG7blWtK1QB/MN9N9SxcjbcUTnfAU5bVfILqDpEh2ulHR4X4BzQsDC+9ChB5Y/CjFNfS8BiHtSB2TG3vyuazOahE2zES6hGkn9qKOPVGX8XVnB9KkH1tGUXWfMjzCxKaCwy1uSo0XW7PnSsQfPGWRcA==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiSEkxVp0V/3fyWP7tChxiFiFvq7SLAuIVdnEf7s0MgIRaICULLacMtAGrK+lrPoKW4ZP2BQjvdBQOTuMtjwKKdpwHF1N+7aZY23YKut3mfWW9X++Mp+2gggXDixGHEdwHR1lLTDe8LlNdF6Xnj8jTwV2UF+zPaCBwg3U1YMRtUbNUdbw+DTjFYUW9PDML4IvOxu4ifdAzDCXbhLBEn5Xq1ZpD35u h0qkezp669dciErzm9ri2xCoXkuvjQhGz7K0gGBtXAJLFeaPz/HoF780sRC4fdOIH1fza6Vq7GruSOw0vs1fe3/7BBt3TP5RqzfTY/PUUfNh4a3bUD34H4fvTQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kyd.free.idcfengye.com/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://127.0.0.1:8083/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
