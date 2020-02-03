/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PaginationDTO
 * Author:   cj
 * Date:     2020-1-13 23:44
 * Description: 分页对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈分页对象〉
 *
 * @author cj
 * @create 2020-1-13
 * @since 1.0.0
 */
@Data
public class PaginationDTO {

    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEedPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        //防止小于分页情况
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        this.page = page;
        //生成分页列表
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            //
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页
        if (page == 1 || page == 0) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        //是否展示下一页
        if (page < totalPage) {
            showNext = true;
        } else {
            showNext = false;
        }

        //是否展示第一页
        if (pages.contains(1) || pages.contains(0)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEedPage = false;
        } else {
            showEedPage = true;
        }
    }
}
