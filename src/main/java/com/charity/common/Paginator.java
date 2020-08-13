package com.charity.common;

import com.github.pagehelper.PageInfo;

import java.util.List;


/**
 * 分页通用类
 */
public class Paginator {

    public static void page(List pagenums, PageInfo pageInfo, int pageNum, int pageSize){
        if (pageNum > 3 && pageInfo.getPages() > 5)  //当前端页数超过第三页时,并且查询到的总页数大于5
        {
            if (pageNum >= pageInfo.getPages() - 2) { //specialSelect.getPages()总页数，如果前端页数大于等于总页数-2时
                pagenums.add(pageInfo.getPages() - 4);
                pagenums.add(pageInfo.getPages() - 3);
                pagenums.add(pageInfo.getPages() - 2);
                pagenums.add(pageInfo.getPages() - 1);
                pagenums.add(pageInfo.getPages());
            } else {
                pagenums.add(pageNum - 2);
                pagenums.add(pageNum - 1);
                pagenums.add(pageNum);
                pagenums.add(pageNum + 1);
                pagenums.add(pageNum + 2);
            }
        } else {          //前端页数没超过第三页时
            if (pageInfo.getPages() < 5) //如果总页数小于5
            {
                for (int i = 0; i < pageInfo.getPages(); i++)
                    pagenums.add(i + 1);
            } else {
                pagenums.add("1");
                pagenums.add("2");
                pagenums.add("3");
                pagenums.add("4");
                pagenums.add("5");
            }
        }

    }
}
