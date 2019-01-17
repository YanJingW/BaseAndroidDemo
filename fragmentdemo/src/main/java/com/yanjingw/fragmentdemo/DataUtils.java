package com.yanjingw.fragmentdemo;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    public static List<String> getDetailpageData(int pageSize) {
        ArrayList<String> detailpageList = new ArrayList<>();
        for (int i = 0; i < pageSize; i++) {
            String secontTabContent = "我是第" + (i + 1) + "个详情页，共" + pageSize + "个页面";
            detailpageList.add(secontTabContent);
        }
        return detailpageList;
    }
}
