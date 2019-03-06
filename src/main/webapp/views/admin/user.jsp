<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>
<jsp:include page="../common/index-header.jsp" />
<body class="sidebar-fixed header-fixed">

<div style="width:80%; position: absolute;
            left:50%;
            top:50%;
           transform: translate(-50%,-50%);">

    <div class="card">

        <div class="card-body">
            <form id="formData">
                <div class="row">

                <c:choose>
                    <c:when test="${flag}" >
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="form-control-label">用户名</label>
                                <input id="username" name="username" class="form-control" value="${user.username}"/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="form-control-label">密码</label>
                                <input id="password" name="password" type="password" class="form-control" value="${user.password}"/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="form-control-label">确认密码</label>
                                <input id="repassword" name="repassword" type="password" class="form-control"/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="email" class="form-control-label">邮箱</label>
                                <input name="email" id="email"  class="form-control" value="${user.email}">
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label class="form-control-label">用户名</label>
                                <input class="form-control" readonly value="${user.username}"/>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="email" class="form-control-label">邮箱</label>
                                <input name="email" id="email"  class="form-control" value="${user.email}">
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
                <input type="hidden" name="id" value="${user.id}">
                </div>
            </form>
        </div>
    </div>

</div>
<script>


    function submit(){
        var obj = $("#formData").serializeObject();
        var flag = false;
        <c:choose>
            <c:when test="${flag}">

              if($('#username').val() == ''){
                  swal({
                      title:'警告',
                      text:"请输入用户名",
                      icon: "warning"
                  });
                  return;
              }
             if($('#password').val() == ''){
                 swal({
                     title:'警告',
                     text:"请输入密码",
                     icon: "warning"
                 });
                 return;
              }
             if($('#repassword').val() == ''){
                 swal({
                     title:'警告',
                     text:"请输入确认密码",
                     icon: "warning"
                 });
                 return;
             }
            if($('#repassword').val() != $("#password").val()){
                swal({
                   title:'警告',
                   text:"两次输入密码不一致",
                   icon: "warning"
                });
                return;
             }

             if($('#email').val() == ''){
                 swal({
                     title:'警告',
                     text:"请输入邮箱地址",
                     icon: "warning"
                 });
                 return;
             }
              $.ajax({
                  url:"/user",
                  type:"post",
                  async:false,
                  data:obj,
                  success:function(result){
                      if(result.code == '1'){
                          flag = true;
                      } else {
                          swal({
                              title:'警告',
                              text:result.msg,
                              icon: "warning"
                          });
                      }
                  }
              })
            </c:when>
            <c:otherwise>
        obj._method = 'PUT';
        $.ajax({
            url:"/user",
            type:"post",
            async:false,
            data:obj,
            success:function(result){
                if(result.code == '1'){
                    flag = true;
                }
            }
        })
            </c:otherwise>
        </c:choose>
        return flag;
    }



</script>

</body>
<jsp:include page="../common/footer.jsp" />