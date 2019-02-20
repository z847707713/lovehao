<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/index-header.jsp" />

<body class="sidebar-fixed header-fixed">

<div class="page-wrapper">

    <jsp:include page="../common/navbar.jsp" />
    <jsp:include page="../common/index-menu.jsp" />
    <div class="content">

        <div class="card">

            <div class="card-header bg-light">
                条件检索
                <button id="searchBtn" class="btn btn-primary" style="float: right;">搜索</button>
            </div>

            <div class="card-body">
                <form id="searchForm">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="normal-input" class="form-control-label">权限</label>
                                <input name="permission" id="normal-input" class="form-control" >
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="normal-input" class="form-control-label">权限名称</label>
                                <input name="permissionName" id="normal-input2"  class="form-control" >
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="card">
            <div class="card-header bg-light">
                角色列表
                <button id="addBtn" class="btn btn-primary" style="float: right;">新增</button>
            </div>
            <div class="card-body">

                  <ul id="treeDemo" class="ztree"></ul>

            </div>
        </div>
    </div>
</div>
</div>

<script>

    var zTreeObj;
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {
        check:{
            enable:true
        },data:{
            simpleData: {
                enable: true
            }
        }
    };
    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    var zNodes =[
        { id:1, pId:0, name:"can check 1", open:true},
        { id:11, pId:1, name:"can check 1-1", open:true},
        { id:111, pId:11, name:"can check 1-1-1"},
        { id:112, pId:11, name:"can check 1-1-2"},
        { id:12, pId:1, name:"can check 1-2", open:true},
        { id:121, pId:12, name:"can check 1-2-1"},
        { id:122, pId:12, name:"can check 1-2-2"},
        { id:2, pId:1, name:"can check 2", checked:true, open:true},
        { id:21, pId:2, name:"can check 2-1"},
        { id:22, pId:2, name:"can check 2-2", open:true},
        { id:221, pId:22, name:"can check 2-2-1", checked:true},
        { id:222, pId:22, name:"can check 2-2-2"},
        { id:23, pId:2, name:"can check 2-3"}
    ];

    $(document).ready(function(){
        zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        zTreeObj.setting.check.chkboxType = { "Y":"ps", "N":"ps"};
    });

</script>



</body>
<jsp:include page="../common/footer.jsp" />

