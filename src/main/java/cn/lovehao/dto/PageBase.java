package cn.lovehao.dto;

public class PageBase {

    private Integer currentPage;
    private Integer pageShowCount;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageShowCount() {
        return pageShowCount;
    }

    public void setPageShowCount(Integer pageShowCount) {
        this.pageShowCount = pageShowCount;
    }
}
