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
                                <label for="normal-input" class="form-control-label">用户名</label>
                                <input name="username" id="normal-input" class="form-control" >
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="normal-input" class="form-control-label">邮箱</label>
                                <input name="email" id="normal-input2"  class="form-control" >
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="card">
            <div class="card-header bg-light">
                用户列表
                <button id="addBtn" class="btn btn-primary" style="float: right;">新增</button>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead id="thead">
                        </thead>
                        <tbody id="tbody">
                        </tbody>
                    </table>
                </div>
                <div id="example" style="text-align: center">
                    <ul id="pageLimit" style="float: right"></ul>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script>

    var pageShowCount = 10; //每页显示的数量
    $(function(){
        //初始化
        initTable();

        //搜索按钮添加点击事件
        $("#searchBtn").click(function(){
            var obj = $("#searchForm").serializeObject();
            //调用方法, “1” 代表当前第 1 页
            loadPage(1);
        });

        //监听回车
        $("#searchForm").keyup(function(event){
            if(event.keyCode ==13){
                loadPage(1);
            }
        });

        //新增按钮点击事件
        $("#addBtn").click(function(){
            layer.open({
                type: 2,
                title: '权限新增',
                shadeClose: true,
                shade: 0.8,
                area: ['60%', '65%'],
                content: '/user' //iframe的url
                ,btn: ['确定', '取消']
                ,yes: function(index, layero){
                    var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
                    var flag = iframeWin.submit();//调用子页面的方法，得到是否成功的标志
                    console.log(flag);
                    if(flag){
                        layer.close(index);
                        swal({
                            icon: "success"
                        });
                    } else {
                        return;
                    }
                    loadPage(getCurrentPage());
                }
                ,btn2: function(index, layero){
                    layer.close(index)
                }
            });
        });

        $(document).tooltip();
    })


    //初始化
    function initTable(){
        $.ajax({
            url:"/user/list",
            type:"post",
            data:{
                currentPage:1,
                pageShowCount:pageShowCount
            },
            success:function(result){
                //渲染表格数据
                loadData(result.data);
                //初始化分页组件
                initPageLimit(result.totalPage);
            }
        })
    }

    //初始化分页
    function initPageLimit(totalPage){
        var options = {
            currentPage: 1,//当前的请求页面。
            totalPages: totalPage,//一共多少页。
            size:"normal",//应该是页眉的大小。
            bootstrapMajorVersion: 3,//bootstrap的版本要求。
            alignment:"right",
            numberOfPages: 5,//设置控件显示的页码数量.即：类型为"page"的操作按钮的数量。
            itemTexts: function (type, page, current) {//如下的代码是将页眉显示的中文显示我们自定义的中文。
                switch (type) {
                    case "first": return "首页";
                    case "prev": return "上一页";
                    case "next": return "下一页";
                    case "last": return "末页";
                    case "page": return page;
                }
            },//点击事件
            onPageClicked:function(event,originalEvent, type,page){
                loadPage(page)
            }
        };
        $('#pageLimit').bootstrapPaginator(options);
    }

    //加载对应页 ,“page” 代表第几页
    function loadPage(page){
        var obj = $("#searchForm").serializeObject();   //序列化表单，获取检索条件，并封装成js对象
        //把 “当前第几页” 和  “每一页显示多少行” 封装到js对象中
        obj.currentPage = page;
        obj.pageShowCount = pageShowCount;

        $.ajax({
            url:"/user/list",
            type:"post",
            data:obj,
            success:function(result){
                //渲染表格
                loadData(result.data);
                //改变当前是第几页，及总页数
                $('#pageLimit').bootstrapPaginator("setOptions",{totalPages:result.totalPage,currentPage:page});
            }
        })
    }

    //绑定点击事件
    function bindEvent(){


        $(".distBtn").click(function(){
            var id = $(this).parent().parent().children(":first").html();

            layer.open({
                type: 2,
                title: '分配角色',
                shadeClose: true,
                shade: 0.8,
                area: ['60%', '65%'],
                content: '/userRole/view/' + id //iframe的url
                ,btn: ['确定', '取消']
                ,yes: function(index, layero){
                    var body = layer.getChildFrame('body', index);
                    var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
                    var flag = iframeWin.doSelect();//调用子页面的方法，得到是否成功的标志
                    layer.close(index);//需要手动关闭窗口
                    if(flag){
                        swal({
                            icon: "success"
                        });
                    } else {
                        swal({
                            icon:"error"
                        })
                    }
                }
                ,btn2: function(index, layero){
                    layer.close(index)
                }
            });

        });


        $('.deleteBtn').click(function(){
            var id = $(this).parent().parent().children(":first").html();
            swal({
                title:"提示",
                text:"删除之后不可恢复，是否确认删除",
                icon:'warning',
                buttons:{
                    cancel:{
                        text:'取消',
                        visible: true,
                        value:false
                    },
                    confirm: {
                        text:"确定",
                        value:true
                    }
                }
            }).then(function(value){
                if(value){
                    deleteData(id);
                }
            });
            return false;
        });

        $(".editBtn").click(function(){
            var id = $(this).parent().parent().children(":first").html();
            $(function(){
                layer.open({
                    type: 2,
                    title: '权限编辑',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['60%', '65%'],
                    content: '/user/' + id //iframe的url
                    ,btn: ['确定', '取消']
                    ,yes: function(index, layero){
                        var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
                        var flag = iframeWin.submit();//调用子页面的方法，得到是否成功的标志
                        if(flag){
                            layer.close(index);
                            swal({
                                icon: "success"
                            });
                        } else {
                            swal({
                                icon: "error"
                            });
                        }

                        loadPage(getCurrentPage());
                    }
                    ,btn2: function(index, layero){
                        layer.close(index)
                    }
                });
            })
        });

    }



    //数据渲染
    function loadData(data){
        $("#tbody").html('');
        $("#thead").html('');
        if(data.length > 0){
            $('#thead').html(' <tr>' +
                '                        <th>ID</th>' +
                '                        <th>用户名</th>' +
                '                        <th>email</th>' +
                '                        <th>操作</th>' +
                '                </tr>')
        }
        for(var i = 0 ; i < data.length; i ++){
            $("#tbody").append('<tr>' +
                '                        <td>'+ data[i].id +'</td>' +
                '                        <td class="text-nowrap">' + data[i].username + '</td>' +
                '                        <td ><a>'+ data[i].email +'</a></td>' +
                '                        <td>' + '<a class="distBtn" href="#">分配角色</a>' +
                '                                 <a class="editBtn" href="#">修改</a>' +
                '                                <a class="deleteBtn" href="#">删除</a>' + '</td>' +
                '                </tr>');
        }
        bindEvent();
        limitWord();
    }

    //获取当前是第几页
    function getCurrentPage(){
        return  $('#pageLimit').bootstrapPaginator("getPages").current;
    }

    /**
     *  限制文本显示数量
     */
    function limitWord () {
        $('.wordlimit').wordLimit(6);
    }


    function deleteData(id){
        $.ajax({
            url:"/user",
            type:"POST",
            data:{
                _method:'DELETE',
                id:id
            },success:function(data){
                if(data.code == 1){
                    console.log(data);
                    var currentPage = $('#pageLimit').bootstrapPaginator("getPages").current;
                    loadPage(currentPage);
                }
            }
        })
    }

</script>

</body>
<jsp:include page="../common/footer.jsp" />

