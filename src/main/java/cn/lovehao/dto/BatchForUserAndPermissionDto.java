package cn.lovehao.dto;

import java.util.List;

public class BatchForUserAndPermissionDto {

    private Integer id;

    private List<Integer> ids;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
