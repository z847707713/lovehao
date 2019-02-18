<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <input type="hidden" name="id" value="${role.id}">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="normal-input" class="form-control-label">角色</label>
                            <input name="roleName" id="normal-input" class="form-control" value="${role.roleName}">
                        </div>
                    </div>

                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="normal-input" class="form-control-label">角色名</label>
                            <input name="roleDesc" id="normal-input2"  class="form-control" value="${role.roleDesc}">
                        </div>
                    </div>

                </div>
            </form>
        </div>
   </div>

    </div>



<script>





</script>

</body>
<jsp:include page="../common/footer.jsp" />