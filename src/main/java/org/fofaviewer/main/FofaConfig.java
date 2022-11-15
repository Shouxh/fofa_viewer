package org.fofaviewer.main;

import java.util.ArrayList;

public class FofaConfig {
    private static FofaConfig config = null;
    private String email;
    private String key;
    private final String page = "1";
    //企业版可以导出10w
    public final int max = 100000;
    private String size = "1000";
    public String API = "https://fofa.info";
    public final String path = "/api/v1/search/all";
    public static final String TIP_API = "https://api.fofa.info/v1/search/tip?q=";
    //public static final String TIP_API = Locale.getDefault()==Locale.CHINA ? "https://api.fofa.so/v1/search/tip?q="
    public ArrayList<String> fields = new ArrayList<String>(){{add("host");add("ip");add("domain");add("port");add("protocol");add("server");}};//title,cert";

    private FofaConfig(){
        this.email = "";
        this.key = "";
    }

    public static FofaConfig getInstance(){
        if (config == null) {
            config = new FofaConfig();
        }
        return config;
    }

    public String getEmail() {
        return email;
    }

    public String getKey() {
        return key;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getParam(String page, boolean isAll) {
        String all = isAll ? "&full=true" : "";
        StringBuilder builder = new StringBuilder(API).append(path).append("?email=").append(email).append("&key=").append(key).append(all).append("&page=");
        if(page != null) {
            return builder.append(page).append("&size=").append(size).append("&fields=").append(getFields()).append("&qbase64=").toString();
        }else{
            return builder.append(this.page).append("&size=").append(size).append("&fields=").append(getFields()).append("&qbase64=").toString();
        }
    }

    public String getFields(){
        StringBuilder builder = new StringBuilder();
        for(String i : this.fields){
            builder.append(i).append(",");
        }
        String a = builder.toString();
        return a.substring(0,a.length()-1);
    }
}
