<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<jsp:include page="../common/index-header.jsp" />

<body class="sidebar-fixed header-fixed">

<div class="page-wrapper">
    <div class="content">
        <div class="card">
            <div class="card-header bg-light">
                <button id="selectAll" class="btn btn-primary" >全选</button>
            </div>
            <div class="card-body">

                  <ul id="treeDemo" class="ztree"></ul>

            </div>
        </div>
       <input id="roleId" type="hidden" value="${id}">

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
    // var zNodes =[
    //     { id:1, pId:0, name:"can check 1", open:true},
    //     { id:11, pId:1, name:"can check 1-1", open:true},
    //     { id:111, pId:11, name:"can check 1-1-1"},
    //     { id:112, pId:11, name:"can check 1-1-2"},
    //     { id:12, pId:1, name:"can check 1-2", open:true},
    //     { id:121, pId:12, name:"can check 1-2-1"},
    //     { id:122, pId:12, name:"can check 1-2-2"},
    //     { id:2, pId:1, name:"can check 2", checked:true, open:true},
    //     { id:21, pId:2, name:"can check 2-1"},
    //     { id:22, pId:2, name:"can check 2-2", open:true},
    //     { id:221, pId:22, name:"can check 2-2-1", checked:true},
    //     { id:222, pId:22, name:"can check 2-2-2"},
    //     { id:23, pId:2, name:"can check 2-3"}
    // ];

    $(document).ready(function(){
        $.ajax({
            url:"/userRole/tree",
            type:"get",
            data:{
                roleId:$("#roleId").val()
            },
            success:function(zNodes){
                console.log(zNodes);
                zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
                zTreeObj.setting.check.chkboxType = { "Y":"ps", "N":"ps"};

            }
        })

        $("#selectAll").click(function(){
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            treeObj.checkAllNodes(true);
        });

        $("#btn").click(function(){
            var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
            var nodes = treeObj.getCheckedNodes(true);
            console.log(nodes);
            return false;
        });
    });

    function doSelect(){
        var ids = new Array();
        var flag = false;
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getCheckedNodes(true);
        console.log(nodes);
        for(var i = 0 ; i < nodes.length; i++){
            ids[i] = nodes[i].id;
        }
        console.log(ids);
        var roleId = $("#roleId").val();
        var param = {
            id:roleId,
            ids:ids
        }
        $.ajax({
            url:"/userRole/",
            type:"post",
            async:false,
            data:JSON.stringify(param),
            contentType: "application/json",
            success:function(data){
               if(data.code == '1'){
                  flag = true;
               }
            }
        })
       return flag;
    }



</script>



</body>
<jsp:include page="../common/footer.jsp" />

