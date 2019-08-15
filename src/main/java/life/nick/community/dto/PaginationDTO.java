package life.nick.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *@author lijing
 *@date 2019/8/14
 **/
@Data
public class PaginationDTO {
    /**
     * 数据
     */
    private List<QuestionDTO> questionDTOList;

    /**
     *是否有跳转前一页标识
     */
    private Boolean showPrevious;

    /**
     *是否有跳转第一页标识
     */
    private Boolean showFirst;

    /**
     *是否有跳转后一页标识
     */
    private Boolean showNext;

    /**
     *是否有跳转到最后一页标识
     */
    private Boolean showEnd;

    /**
     *当前页
     */
    private Integer page;

    /**
     *当前页码集合
     */
    private List<Integer> pages;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 设置分页信息
     * @param total 总记录数
     * @param page
     * @param size
     */
    public void setPagination(Integer total, Integer page, Integer size) {
        //总页数
        Integer totalPage = total % size == 0 ? total / size : total / size + 1;
        this.totalPage = totalPage;
        //当前页
        this.page = page;
        //当前页面集合
        List<Integer> pageList = new ArrayList();
        pageList.add(page);
        for (int i = 1; i < 4; i++) {
            if (page - i > 0) {
                pageList.add(0,page - i);
            }
            if (page + i <= totalPage) {
                pageList.add(page + i);
            }
        }
        this.pages = pageList;
        //是否有跳转到前一页标识
        this.showPrevious = (page > 1) ? true : false;
        //是否有跳转到第一页标识
        this.showFirst = (page - 3) > 1 ? true : false;
        //是否有跳转到后一页标识
        this.showNext = (page < totalPage) ? true : false;
        //是否有跳转到最后一页标识
        this.showEnd = (page < totalPage - 3) ? true : false;

    }
}

